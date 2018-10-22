package socket;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class HelloClient {
    public static void main(String[] args) throws IOException {
        Socket hellosocket = null;
        BufferedReader in = null;
        try {
            hellosocket = new Socket("localhost", 2345);
            in = new BufferedReader(new InputStreamReader(hellosocket.getInputStream()));
        } catch (IOException e) {
            System.err.println("Don't know about host:localhost");
            System.exit(1);
        }
        System.out.println(in.readLine());
        in.close();
        hellosocket.close();

    }
}
