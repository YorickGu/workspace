package EchoTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class EchoClient {
    public static void main(String[] args) throws IOException {
        Socket socket = null;
        PrintWriter out = null;
        BufferedReader in = null;
        socket = new Socket("localhost", 1457);
        out = new PrintWriter(socket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        System.out.println(in.readLine());
        System.out.println(in.readLine());
        BufferedReader stdln = new BufferedReader(new InputStreamReader(System.in));
        String userinput;
        while ((userinput = stdln.readLine()) != null) {
            out.println(userinput);
            System.out.println(in.readLine());
        }
        out.close();
        in.close();
        socket.close();

    }
}
