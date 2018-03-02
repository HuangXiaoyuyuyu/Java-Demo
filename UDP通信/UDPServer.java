package UDP;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class UDPServer {
    public static void main(String[] args) {
        try {
            DatagramSocket datagramSocket = new DatagramSocket(5678);

            byte[] buf = new byte[1024];
            DatagramPacket datagramPacket = new DatagramPacket(buf,buf.length);
            datagramSocket.receive(datagramPacket);

            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(buf);
            DataInputStream dataInputStream = new DataInputStream(byteArrayInputStream);
            System.out.println(dataInputStream.readLong());
            //System.out.println(new String(buf,0,datagramPacket.getLength()));
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
