package client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.*;
import java.security.*;
import javax.crypto.*;
import java.security.interfaces.*;
import java.math.BigInteger;

class MyClient extends JFrame {

    public MyClient() {
        super("Client");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        initConnectPanel();//初始化连接面板
        initMsgShowPanel();//初始化消息显示面板
        initMsgEditPanel();//初始化消息编辑面板

        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());
        pane.add(connectPanel, BorderLayout.NORTH);
        pane.add(msgShowPanel, BorderLayout.CENTER);
        pane.add(msgEditPanel, BorderLayout.SOUTH);

        pack();
        msgShowPanel.setBackground(Color.lightGray);
        msgEditPanel.setBackground(Color.lightGray);
        msgShowArea.setBackground(Color.lightGray);
        msgEditArea.setBackground(Color.lightGray);
        setBounds(900,0,550,850);
        setVisible(true);

        try {
            clientKeyRSA = new ClientRSA();//生成客户端RSA密钥
        } catch (Exception e) {
            System.out.println("RSA密钥生成出错：" + e);
        }
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
    /**
     *初始化连接面板
     */
    private void initConnectPanel() {
        connectPanel = new JPanel();
        connectPanel.setLayout(new FlowLayout());

        final JButton connectButton = new JButton("Connection");

        connectButton.setFont(font);
        connectButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {
                connectServer(ipAddress.getText());
                connectButton.setEnabled(false);
            }
        });

        ipAddress = new JTextField(10);
        ipAddress.setText("127.0.0.1");

        connectPanel.add(connectButton);
        connectPanel.add(ipAddress);
    }

    private void connectServer(String serverAddress) {//连接服务器
        try {
            clientMsg = new Socket(serverAddress, msgPort);
            clientRSA = new Socket(serverAddress, RSAPort);
            clientDES = new Socket(serverAddress, DESPort);
            if (clientMsg.isBound() == true &&
                    clientRSA.isBound() == true &&
                    clientDES.isBound() == true) {
                msgShowArea.append("成功连接服务器！" + "\n");


                new keyThread(clientRSA, clientDES).start();//接收密钥线程
                new recThread(clientMsg).start();//接收信息线程
            } else {
                msgShowArea.append("连接失败！" + "\n");
            }
        } catch (Exception e) {
            System.out.println("连接出错:" + e);
        }
    }

    class keyThread extends Thread {//接收密钥线程

        private ObjectInputStream ObjISDES;   //DES密钥输入流
        private ObjectInputStream ObjISRSA;   //RSA密钥输入流
        private ObjectOutputStream ObjOSRSA;  //RSA密钥输出流
        byte[] bkeyDES;
        Cipher cipher;

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

        public keyThread(Socket sRSA, Socket sDES) throws IOException {
            ObjOSRSA = new ObjectOutputStream(sRSA.getOutputStream());
            ObjISRSA = new ObjectInputStream(sRSA.getInputStream());
            ObjISDES = new ObjectInputStream(sDES.getInputStream());

            ObjOSRSA.writeObject(clientKeyRSA.getPublicKey());
            ObjOSRSA.flush();  //发送RSA密钥输出流

            try {
                cipher = Cipher.getInstance("RSA");
                cipher.init(Cipher.UNWRAP_MODE, clientKeyRSA.getPrivateKey());//初始化
            } catch (Exception e) {
                System.out.println("Cipher:" + e);
            }
        }

        //生成各密钥，并保存到本地文件
        public void run() {
            try {
                serverPBK = (RSAPublicKey) ObjISRSA.readObject();
                ObjOSRSA.close();
                ObjISRSA.close();

                bkeyDES = (byte[]) ObjISDES.readObject();
                keyDES = (SecretKey) cipher.unwrap(bkeyDES, "DES", Cipher.SECRET_KEY);
                ObjISDES.close();
                //生成相应的密钥
                msgShowArea.append("客户端私钥：" + bytesToHexString(clientKeyRSA.getPrivateKey().getEncoded()) + "\n");
                msgShowArea.append("客户端公钥：" + bytesToHexString(clientKeyRSA.getPublicKey().getEncoded()) + "\n");
                msgShowArea.append("服务器公钥：" + bytesToHexString(serverPBK.getEncoded()) + "\n");
                msgShowArea.append("DES密钥：" + bytesToHexString(keyDES.getEncoded()) + "\n");
                msgShowArea.setCaretPosition(msgShowArea.getText().length());
                //保存公钥的字节数组
                File f1 = new File("PrivateKey.dat");  //保存客户端私钥到文件PrivateKey.dat
                FileOutputStream fout1 = new FileOutputStream(f1);
                fout1.write(clientKeyRSA.getPrivateKey().getEncoded()); //得到客户端私钥的字节数组
                fout1.close();  //关闭文件输出流
                System.out.println("保存客户端私钥到文件: " + f1.getAbsolutePath());

                File f2 = new File("PublicKey.dat");  //保存客户端公钥到文件PublicKey.dat
                FileOutputStream fout2 = new FileOutputStream(f2);
                fout2.write(clientKeyRSA.getPublicKey().getEncoded()); //得到客户端公钥的字节数组
                fout2.close();  //关闭文件输出流
                System.out.println("保存客户端公钥到文件: " + f2.getAbsolutePath());

                File f3 = new File("serverPBK.dat");  //保存服务端公钥到文件serverPBK.dat
                FileOutputStream fout3 = new FileOutputStream(f3);
                fout3.write(serverPBK.getEncoded()); //得到服务端公钥的字节数组
                fout3.close();  //关闭文件输出流
                System.out.println("保存服务器公钥到文件: " + f3.getAbsolutePath());

                File f4 = new File("keyDES.dat");  //保存客户端DES密钥到文件keyDES.dat
                FileOutputStream fout4 = new FileOutputStream(f4);
                fout4.write(keyDES.getEncoded()); //得到客户端DES密钥的字节数组
                fout4.close();  //关闭文件输出流
                System.out.println("保存DES密钥到文件: " + f4.getAbsolutePath());

            } catch (Exception e) {
                System.out.println(e);
            }
        }
    }

    class recThread extends Thread {//接收信息线程

        private byte[] eData;//接收到的加密信息
        private byte[] data;//原始消息
        private byte[] eSData;//接收到的加密签名：
        private byte[] sData;//MD5WithRSA签名信息
        private String str;


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

        public recThread(Socket sMsg) throws IOException {//线程构造函数
            ObjOSMsg = new ObjectOutputStream(sMsg.getOutputStream());//创建输出流
            ObjISMsg = new ObjectInputStream(sMsg.getInputStream());//创建输入流
        }

        public void run() {//线程监听函数
            try {
                while (true) {
                    eData = (byte[]) ObjISMsg.readObject();
                    data = ClientDES.SEnc(keyDES, "DEC", eData);
                    str = new String(data);
                    eSData = (byte[]) ObjISMsg.readObject();
                    sData = ClientDES.SEnc(keyDES, "DEC", eSData);
                    Jm = str;
                    if (!ClientSign.CheckSign(serverPBK, data, sData)) {
                        str = "信息验证错误。";
                    }
                    if (detailShow.isSelected()) {
                        msgShowArea.append("接收到的信息为加密信息：" + "\n");
                        msgShowArea.append("接收到的加密信息：" + bytesToHexString(eData) + "\n");
                        msgShowArea.append("接收到的加密签名：" + bytesToHexString(eSData) + "\n");
                    } else {
                        msgShowArea.append("Server: " + str + "\n");
                    }
                    msgShowArea.append("\n");
                    msgShowArea.append("\n");
                    msgShowArea.setCaretPosition(msgShowArea.getText().length());
                }
            } catch (Exception e) {
                System.out.println("消息接收错误：" + e);
            }

        }
    }

    /**
     *初始化消息显示面板
     */
    private void initMsgShowPanel() {   //初始化消息显示面板
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
    private void initMsgEditPanel() { //初始化消发送编辑面板
        msgEditPanel = new JPanel();
        msgEditPanel.setLayout(new BorderLayout());

        JLabel label = new JLabel("Input。。。: ");
        label.setFont(font);

        msgEditArea = new JTextArea(5, 50);
        msgEditArea.setLineWrap(true);
        JScrollPane msgEditPane = new JScrollPane();
        msgEditPane.setViewportView(msgEditArea);

        JPanel buttonPanel = new JPanel();
        JButton sendButton = new JButton("发送");
        sendButton.setFont(font);

        JButton sendButton1 = new JButton("解密");
        sendButton1.setFont(font);
        // boolean result=true;

        sendButton.addActionListener(new ActionListener() {

            public void actionPerformed(ActionEvent e) {//发送消息
                try {
                    boolean result1 = wordFilter();
                    if (result1 == true) {
                        byte[] data = msgEditArea.getText().getBytes();
                        byte[] sData = ClientSign.Sign(clientKeyRSA.getPrivateKey(), data);
                        byte[] eData = ClientDES.SEnc(keyDES, "ENC", data);
                        byte[] eSData = ClientDES.SEnc(keyDES, "ENC", sData);

                        ObjOSMsg.writeObject(eData);
                        ObjOSMsg.flush();
                        ObjOSMsg.writeObject(eSData);
                        ObjOSMsg.flush();

                        if (detailShow.isSelected()) {
                            msgShowArea.append("该信息已被加密：" + "\n");
                            msgShowArea.append("加密后的信息：" + bytesToHexString(eData) + "\n");
                            msgShowArea.append("加密后的签名：" + bytesToHexString(eSData) + "\n");
                        }else {
                            msgShowArea.append("Client: " + msgEditArea.getText() + "\n");
                        }
                        msgShowArea.append("\n");
                        msgShowArea.append("\n");
                        msgShowArea.setCaretPosition(msgShowArea.getText().length());
                        msgEditArea.setText(null);
                    } else {
                        JOptionPane.showMessageDialog(null, "文字内容不当，请重新输入！");
                        msgEditArea.setText("");
                    }
                } catch (Exception b) {
                    System.out.println("消息发送错误:" + b);
                }

            }
        });

        sendButton1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                msgShowArea.append("Server: " + Jm + "\n");
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

    public boolean wordFilter() { // 发送文字过滤
        boolean result = true;
        try {
            String badWord = this.getFile("D:\\Programming\\JetBrains\\idea files\\SecureInstantMessaging\\src\\badword.txt");

            String badWordList[] = badWord.split(",");
            for (int i = 0; i < badWordList.length; i++) {

                String word = msgEditArea.getText();
                //如果查找有相同的关键字，则返回false,否则返回true
                if (word.indexOf(badWordList[i]) != -1) {
                    result = false;
                    return result;
                }
            }
        } catch (Exception e) {
            String Wrong1 = "文字过滤出错！";   //提示出错
            JOptionPane.showMessageDialog(null, "Wrong1"); //显示相应的错误
            e.printStackTrace();
        }
        return result;
    }

    public String getFile(String file) { // 获取文件
        String fileString = "";
        try {
            File files = new File(file);

            FileReader fileReader = new FileReader(files);
            BufferedReader read = new BufferedReader(fileReader);
            while (true) {
                String line = read.readLine();
                if (line == null) {
                    break;
                }
                fileString += (line);

            }
            read.close();

        } catch (FileNotFoundException e) {
            // TODO 自动生成 catch 块
            e.printStackTrace();
        } catch (IOException e) {
            // TODO 自动生成 catch 块
            e.printStackTrace();
        }

        return fileString;
    }

    /**
     *字节数组转换为字符串表示的二进制数
     */
    private static String byteToBinary(byte[] bytes) {
        BigInteger bi = new BigInteger(bytes);
        return bi.toString(2);
    }
    private JPanel connectPanel;//链接面板
    private JTextField ipAddress;//服务器IP地址输入框
    private JPanel msgShowPanel;//信息显示面板
    private JTextArea msgShowArea;//信息显示框
    private JPanel msgEditPanel;//信息编辑面板
    private JTextArea msgEditArea;//信息发送编辑框
    private JCheckBox detailShow;//是否显示详细加密信息
    private Socket clientMsg,  clientRSA,  clientDES;//信息、RSA密钥、DES 密钥Socket
    private static final int msgPort = 11268;//信息发送接收端口
    private static final int RSAPort = 11234;//RSA密钥发送接收端口
    private static final int DESPort = 11233;//DES密钥发送接收端口
    private ObjectInputStream ObjISMsg;//信息输入流
    private ObjectOutputStream ObjOSMsg;//信息输出流
    private ClientRSA clientKeyRSA;/*客户端密钥*/
    private PublicKey serverPBK;/*服务端公钥*/
    private SecretKey keyDES;/*DES密钥*/
    private Font font = new Font("Dialog", Font.BOLD, 18);//设置字体样式
    private String Jm = null;
}

class Client {                    //主函数

    public static void main(String[] args) {
        new MyClient();             //生成新的 MyClient()对象
    }
}    