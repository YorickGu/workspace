package EchoTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ser = null;
        Socket ss = null;
        PrintWriter out = null;
        BufferedReader buf = null;
        ser = new ServerSocket(1457);
        while (true) {
            ss = ser.accept();
            out = new PrintWriter(ss.getOutputStream(), true);
            buf = new BufferedReader(new InputStreamReader(ss.getInputStream()));
            out.println("Hello World!!");
            out.println("Enter BYE to Exit!!!");
            out.flush();
            while (true) {
                String str = buf.readLine();
                if (str == null) {
                    break;
                } else {
                    out.println("Echo: " + str);
                    out.flush();
                    if (str.trim().equalsIgnoreCase("BYE")) {
                        break;
                    }
                }
            }
            out.close();
            buf.close();
            ss.close();
            ser.close();
        }

    }
}
