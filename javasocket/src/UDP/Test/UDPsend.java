package UDP.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

public class UDPsend {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = null;
        DatagramPacket dp = null;
        ds = new DatagramSocket(3000);
        String str = "Hello!!";
        dp = new DatagramPacket(str.getBytes(),str.length(), InetAddress.getByName("localhost"),9000);
        ds.send(dp);
        ds.close();
    }
}
