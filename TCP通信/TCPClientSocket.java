package TCP;

import java.io.*;
import java.net.Socket;

public class TCPClientSocket {
    public static void main(String[] args) {
        InputStream inputStream = null;
        OutputStream outputStream = null;
        try {
            Socket socket = new Socket("127.0.0.3",5888);
            inputStream = socket.getInputStream();
            outputStream = socket.getOutputStream();
            DataInputStream dataInputStream = new DataInputStream(inputStream);
            DataOutputStream dataOutputStream = new DataOutputStream(outputStream);
            dataOutputStream.writeUTF("hey");
            String s = null;
            if ((s = dataInputStream.readUTF()) != null) {
                System.out.println(s);
            }
            dataInputStream.close();
            dataOutputStream.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
