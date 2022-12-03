import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static final int port = 8080;

    public static void main(String[] args) throws IOException {

        try (ServerSocket serverSocket = new ServerSocket(port)) {
            try (Socket clienSocket = serverSocket.accept();
                 PrintWriter out = new PrintWriter(clienSocket.getOutputStream(), true);
                 BufferedReader in = new BufferedReader(new InputStreamReader(clienSocket.getInputStream()))) {
                while (true) {
                    System.out.println("New connected accepted");
                    final String name = in.readLine();

                    out.println(String.format("Hi %s, your is %d", name, clienSocket.getPort()));
                    if (name.equals("end"))
                        break;
                }
            }
        }
    }
}