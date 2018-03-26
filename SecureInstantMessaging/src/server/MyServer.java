package server;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.security.*;
import javax.crypto.*;
import java.security.interfaces.*;
import java.math.BigInteger;

class MyServer extends JFrame {

    //ServerUI构造函数
    public MyServer() {
        super("Server");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initMsgShowPanel();//调用初始化消息显示面板函数
        initMsgEditPanel();//调用初始化消息编辑面板函数
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());
        pane.add(msgShowPanel, BorderLayout.CENTER);
        pane.add(msgEditPanel, BorderLayout.SOUTH);
        pack();
        msgShowPanel.setBackground(Color.lightGray);
        msgEditPanel.setBackground(Color.lightGray);
        msgShowArea.setBackground(Color.lightGray);
        msgEditArea.setBackground(Color.lightGray);
        setBounds(366,0,550,850);
        setVisible(true);

        try {
            serverKeyRSA = new ServerRSA();//生成服务器端RSA密钥
            ServerDES skeyDES = new ServerDES();
            keyDES = skeyDES.getSecretKey();//生成DES密钥
            serverMsg = new ServerSocket(msgPort);//通信端口
            serverRSA = new ServerSocket(RSAPort);//RSA钥匙传递端口
            serverDES = new ServerSocket(DESPort);//DES密钥传递端口
            new keyThread(serverRSA.accept(), serverDES.accept()).start();
            new recThread(serverMsg.accept()).start();//启动接收监听线程
        } catch (Exception e) {
            System.out.println("server.accept:" + e);
        }

    }
//    Image image = new ImageIcon("D:\\Programming\\JetBrains\\idea files\\SecureInstantMessaging\\src\\images\\1.jpg").getImage();
//    public void paint(Graphics graphics){
//        super.paint(graphics);
//        graphics.drawImage(image,0,0,this.getContentPane());
//    }

    //将字节数组转化为16进制
    public String bytesToHexString(byte[] src){
        StringBuilder stringBuilder = new StringBuilder("");
        if (src == null || src.length <= 0) {
            return null;
        }
        for (int i = 0; i < src.length; i++) {
            int v = src[i] & 0xFF;
            String hv = Integer.toHexString(v);
            if (hv.length() < 2) {
                stringBuilder.append(0);
            }
            stringBuilder.append(hv);
        }
        return stringBuilder.toString();
    }

    class keyThread extends Thread {//接收密钥线程

        private ObjectOutputStream ObjOSDES;
        private ObjectOutputStream ObjOSRSA;
        private ObjectInputStream ObjISRSA;
        byte[] keyDESbyte;

        public keyThread(Socket sRSA, Socket sDES) throws IOException {
            ObjOSDES = new ObjectOutputStream(sDES.getOutputStream());//DES密钥的输出流
            ObjOSRSA = new ObjectOutputStream(sRSA.getOutputStream());//服务器端的RSA公钥输出流
            ObjISRSA = new ObjectInputStream(sRSA.getInputStream());//接收客户端的RSA公钥输入流
        }

        //将字节数组转化为16进制
        public String bytesToHexString(byte[] src){
            StringBuilder stringBuilder = new StringBuilder("");
            if (src == null || src.length <= 0) {
                return null;
            }
            for (int i = 0; i < src.length; i++) {
                int v = src[i] & 0xFF;
                String hv = Integer.toHexString(v);
                if (hv.length() < 2) {
                    stringBuilder.append(0);
                }
                stringBuilder.append(hv);
            }
            return stringBuilder.toString();
        }

        public void run() {
            try {
                clientPBK = (RSAPublicKey) ObjISRSA.readObject();

                ObjOSRSA.writeObject(serverKeyRSA.getPublicKey());
                ObjOSRSA.flush();
                ObjOSRSA.close();
                ObjISRSA.close();

                keyDESbyte = ServerRSA.wrapkey(keyDES, clientPBK);
                ObjOSDES.writeObject(keyDESbyte);
                ObjOSDES.flush();
                ObjOSDES.close();

                msgShowArea.append("服务器私钥：" + bytesToHexString(serverKeyRSA.getPrivateKey().getEncoded()) + "\n");
                msgShowArea.append("服务器公钥：" + bytesToHexString(serverKeyRSA.getPublicKey().getEncoded()) + "\n");
                msgShowArea.append("客户端公钥：" + bytesToHexString(clientPBK.getEncoded()) + "\n");
                msgShowArea.append("DES密钥：" + bytesToHexString(keyDES.getEncoded()) + "\n");
                msgShowArea.setCaretPosition(msgShowArea.getText().length());
            } catch (Exception e) {
                System.out.println("keyThread:" + e);
            }
        }
    }

    class recThread extends Thread {//接收信息线程

        private byte[] eData;
        private byte[] data;
        private byte[] eSData;
        private byte[] sData;
        private String str;

        public recThread(Socket c) throws IOException {//线程构造函数
            ObjOSMsg = new ObjectOutputStream(c.getOutputStream());//why要先建立outputStream?
            ObjISMsg = new ObjectInputStream(c.getInputStream());//创建输入流
        }

        //将字节数组转化为16进制
        public String bytesToHexString(byte[] src){
            StringBuilder stringBuilder = new StringBuilder("");
            if (src == null || src.length <= 0) {
                return null;
            }
            for (int i = 0; i < src.length; i++) {
                int v = src[i] & 0xFF;
                String hv = Integer.toHexString(v);
                if (hv.length() < 2) {
                    stringBuilder.append(0);
                }
                stringBuilder.append(hv);
            }
            return stringBuilder.toString();
        }

        public void run() {//线程监听函数
            try {
                while (true) {
                    eData = (byte[]) ObjISMsg.readObject();
                    data = ServerDES.SEnc(keyDES, "DEC", eData);
                    str = new String(data);
                    eSData = (byte[]) ObjISMsg.readObject();
                    sData = ServerDES.SEnc(keyDES, "DEC", eSData);
                    Jm = str;

                    if (!ServerSign.CheckSign(clientPBK, data, sData)) {
                        str = "信息验证错误。";
                    }
                    if (detailShow.isSelected()) {
                        msgShowArea.append("接收到的信息为加密信息：" + "\n");
                        msgShowArea.append("接收到的加密信息：" + bytesToHexString(eData) + "\n");
                        msgShowArea.append("接收到的加密签名：" + bytesToHexString(eSData) + "\n");
                    } else {
                        msgShowArea.append("Client: " + str + "\n");
                    }
                    msgShowArea.append("\n");
                    msgShowArea.append("\n");
                    msgShowArea.setCaretPosition(msgShowArea.getText().length());
                }
            } catch (Exception e) {
                System.out.println("消息接收错误：" + e);
            }
            ;
        }
    }

    /**
     *初始化消息显示面板
     */
    private void initMsgShowPanel() {
        msgShowPanel = new JPanel();
        msgShowPanel.setLayout(new BorderLayout());

        JLabel label = new JLabel("Chatting~~: ");
        label.setFont(font);

        msgShowArea = new JTextArea(10, 50);
        msgShowArea.setEditable(false);
        msgShowArea.setLineWrap(true);

        JScrollPane msgShowPane = new JScrollPane();
        msgShowPane.setViewportView(msgShowArea);

        msgShowPanel.add(label, BorderLayout.NORTH);
        msgShowPanel.add(msgShowPane, BorderLayout.CENTER);
    }

    /**
     *初始化消息编辑面板
     */
    private void initMsgEditPanel() {
        msgEditPanel = new JPanel();
        msgEditPanel.setLayout(new BorderLayout());

        JLabel label = new JLabel("Input。。。: ");
        label.setFont(font);

        msgEditArea = new JTextArea(5, 50);
        msgEditArea.setLineWrap(true);
        JScrollPane msgEditPane = new JScrollPane();
        msgEditPane.setViewportView(msgEditArea);

        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new FlowLayout());

        JButton sendButton = new JButton("发送");
        sendButton.setFont(font);
        JButton sendButton1 = new JButton("解密");
        sendButton1.setFont(font);
        sendButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {//发送消息
                try {
                    byte[] data = msgEditArea.getText().getBytes();
                    byte[] sData = ServerSign.Sign(serverKeyRSA.getPrivateKey(), data);
                    byte[] eData = ServerDES.SEnc(keyDES, "ENC", data);
                    byte[] eSData = ServerDES.SEnc(keyDES, "ENC", sData);

                    ObjOSMsg.writeObject(eData);//发送加密后的消息
                    ObjOSMsg.flush();
                    ObjOSMsg.writeObject(eSData);//发送加密后的签名
                    ObjOSMsg.flush();
                    if (detailShow.isSelected()) {
                        msgShowArea.append("该信息已被加密：" + "\n");
                        msgShowArea.append("加密后的信息：" + byteToBinary(eData) + "\n");
                        msgShowArea.append("加密后的签名：" + byteToBinary(eSData) + "\n");
                    } else {
                        msgShowArea.append("Server: " + msgEditArea.getText() + "\n");
                    }
                    msgShowArea.append("\n");
                    msgShowArea.append("\n");
                    msgShowArea.setCaretPosition(msgShowArea.getText().length());
                    msgEditArea.setText(null);
                } catch (Exception b) {
                    System.out.println("消息发送错误:" + b);
                }
            }
        });

        sendButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                msgShowArea.append("Client: " + Jm + "\n");
                Jm = null;
                msgShowArea.append("\n");
                msgShowArea.append("\n");
            }
        });

        buttonPanel.add(sendButton);
        buttonPanel.add(sendButton1);
        detailShow = new JCheckBox("密文发送/接收");
        buttonPanel.add(detailShow);

        msgEditPanel.add(label, BorderLayout.NORTH);
        msgEditPanel.add(msgEditPane, BorderLayout.CENTER);
        msgEditPanel.add(buttonPanel, BorderLayout.SOUTH);
    }

    /**
     *字节数组转换为字符串表示的二进制数
     */
    private static String byteToBinary(byte[] bytes) {
        BigInteger bi = new BigInteger(bytes);
        return bi.toString(2);
    }
    private JPanel msgShowPanel;
    private JTextArea msgShowArea;
    private JPanel msgEditPanel;
    private JTextArea msgEditArea;
    private JCheckBox detailShow;
    private ServerSocket serverMsg,  serverRSA,  serverDES;
    private static final int msgPort = 11268;
    private static final int RSAPort = 11234;
    private static final int DESPort = 11233;
    private ObjectInputStream ObjISMsg;
    private ObjectOutputStream ObjOSMsg;
    private ServerRSA serverKeyRSA;/*服务端密钥*/
    private PublicKey clientPBK;/*客户端公钥*/
    private SecretKey keyDES;/*DES密钥*/
    private Font font = new Font("Dialog", Font.BOLD, 18);
    private String Jm = null;
}


class Server {

    public static void main(String[] args) {
        new MyServer();
    }
}