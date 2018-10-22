package ThreadEchoSever;

import java.io.IOException;
import java.net.ServerSocket;

public class EchoSever {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = null;
        boolean listening = true;
        try {
            ss = new ServerSocket(1111);
        } catch (IOException e) {
            System.out.println("can ont link to 1111");
            System.exit(1);
        }
        while (listening) {
            new EchoMultiSever(ss.accept()).start();
        }
        ss.close();

    }
}
