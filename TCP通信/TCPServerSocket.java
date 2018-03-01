package TCP;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPServerSocket {
    public static void main(String[] args) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            ServerSocket serverSocket = new ServerSocket(5888);
            Socket socket = serverSocket.accept();
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            String s = null;
            if ((s = dataInputStream.readUTF()) != null) {
                System.out.println(s);
                System.out.println("from: " +socket.getInetAddress());
                System.out.println("Port: " +socket.getPort());
            }
            dataOutputStream.writeUTF("hi hello");
            dataInputStream.close();
            dataOutputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
