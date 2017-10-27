package wyp_lab09.gadu_gadu;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;


public class Server {
    static public void main(String[] args) throws IOException {
        ServerSocket serverSocket = null;

        try {
            serverSocket = new ServerSocket(6666);
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }

        Socket clientSocket = null;

        try {
            clientSocket = serverSocket.accept();
            System.out.print("new connection accepted: ");
            System.out.println(clientSocket.getInetAddress());
        } catch (IOException e) {
            System.out.println(e.getMessage());
            System.exit(-1);
        }

        PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
        BufferedReader in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));


        Reader rdr = new InputStreamReader(System.in);
        Scanner keyboard = new Scanner(rdr);

        String sentMessage = null;
        String message;

        while (true) {
            if (in.ready() && (sentMessage = in.readLine()) != null) System.out.println("Me: " + sentMessage);
            if (rdr.ready()) {
                message = keyboard.nextLine();
                if (message.equals("end")) {
                    out.println(message);
                    break;
                } else {
                    out.println("Message from your server: " + message);
                }
            }
            if (sentMessage != null && sentMessage.equals("end")) break;
        }

        out.close();
        in.close();
        clientSocket.close();
        serverSocket.close();
    }
}
