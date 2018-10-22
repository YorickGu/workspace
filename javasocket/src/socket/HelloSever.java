package socket;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloSever {
    public static void main(String[] args) throws IOException {
        ServerSocket sever = null;
        PrintWriter out = null;
        try {
            sever = new ServerSocket(2345);
        } catch (IOException e) {
            System.out.println("连接不上9999端口");
            System.exit(1);
        }
        Socket clientsocket = null;
        try {
            clientsocket = sever.accept();
        } catch (IOException e) {
            System.out.println("accpet failed");
            System.exit(1);
        }
        out = new PrintWriter(clientsocket.getOutputStream(), true);
        out.println("Hello World");
        clientsocket.close();
        sever.close();


    }
}
