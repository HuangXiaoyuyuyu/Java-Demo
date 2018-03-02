package UDP;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetSocketAddress;
import java.net.SocketException;

public class UDPClient {
    public static void main(String[] args) {
        //byte[] buf = new String("Hello World").getBytes();
        long l = 10000000l;
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        DataOutputStream dataOutputStream = new DataOutputStream(byteArrayOutputStream);
        try {
            dataOutputStream.writeLong(l);
            byte[] buf = byteArrayOutputStream.toByteArray();
            DatagramPacket datagramPacket = new DatagramPacket(buf,buf.length,
                                            new InetSocketAddress("127.0.0.1",5678));
            DatagramSocket datagramSocket = new DatagramSocket(9999);
            datagramSocket.send(datagramPacket);
            datagramSocket.close();
        } catch (SocketException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
