package wyp_lab09.gadu_gadu;

import java.io.*;
import java.net.Socket;
import java.util.Scanner;

public class SocketUsage implements Runnable {

    private Socket clientSocket;
    private PrintWriter out;
    private BufferedReader in;

    SocketUsage(Socket clientSocket) throws IOException {
        this.clientSocket = clientSocket;
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    @Override
    public void run() {

        Reader rdr = new InputStreamReader(System.in);
        Scanner keyboard = new Scanner(rdr);

        String sentMessage = null;
        String message;

        try {
            while (!Thread.currentThread().isInterrupted()) {
                if (in.ready() && (sentMessage = in.readLine()) != null) System.out.println(sentMessage);
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
                Thread.sleep(500);
            }

            out.close();
            in.close();
        } catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
