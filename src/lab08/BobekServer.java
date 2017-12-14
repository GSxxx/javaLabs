package lab08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class BobekServer {
    public static void main(String[] args) throws IOException {

        while(true) {


            String pass = "zwilgotnieć/jBHIG";

            ServerSocket serverSocket = null;
            try {
                serverSocket = new ServerSocket(3000);
            } catch (IOException e) {
                System.out.println("Could not listen on port: 3000");
                System.exit(-1);
            }

            Socket clientSocket = null;
            try {
                clientSocket = serverSocket.accept();
            } catch (IOException e) {
                System.out.println("Accept failed: 6666");
                System.exit(-1);
            }
            PrintWriter out = new PrintWriter(clientSocket.getOutputStream(), true);
            BufferedReader in = new BufferedReader(
                    new InputStreamReader(
                            clientSocket.getInputStream()));
            String inputLine;


            inputLine = in.readLine();
            if (inputLine.equals(pass)) {
                out.print("xxxxxxxxxx");
            } else {
                System.out.println(inputLine);
                out.print(BobekClient.computeLevenshteinDistance(pass, inputLine));
            }

            out.close();
            in.close();
            clientSocket.close();
            serverSocket.close();
        }

    }
}
