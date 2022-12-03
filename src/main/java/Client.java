import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.*;

public class Client {
    public static void main(String[] args) throws IOException {
        String host = "localhost";

        InetAddress addr = InetAddress.getByName(host);
        Socket clientSocket = new Socket(addr, Server.port);

        try {
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
            System.out.println("New connected accepted");

            out.println("dude");
            String name = in.readLine();
            System.out.println(name);

            out.println("end");
            out.flush();
            clientSocket.setSoTimeout(3000);

        } finally {
            System.out.println("close");
            clientSocket.close();
        }
    }
}