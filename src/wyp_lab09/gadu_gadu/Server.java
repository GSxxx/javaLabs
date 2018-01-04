package wyp_lab09.gadu_gadu;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;


public class Server {
    static public void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(6666);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }

        while (true) {
            Socket clientSocket = serverSocket.accept();

            System.out.print("new connection accepted: ");
            System.out.println(clientSocket.getInetAddress());

            new Thread(new SocketUsage(clientSocket)).start();
        }
    }
}
