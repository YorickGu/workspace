package UDP.Test;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPreceive {
    public static void main(String[] args) throws IOException {
        DatagramSocket ds = null;
        byte[] buf = new byte[1024];
        DatagramPacket dp = null;
        ds = new DatagramSocket(9000);
        dp = new DatagramPacket(buf, 1024);
        ds.receive(dp);
        String str = new String(dp.getData(), 0, dp.getLength())
                     + "  from  " + dp.getAddress().getHostAddress() + " : " + dp.getPort();
        System.out.println(str);
        ds.close();
    }
}
