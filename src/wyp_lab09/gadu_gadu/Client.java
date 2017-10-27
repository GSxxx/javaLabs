package wyp_lab09.gadu_gadu;


import java.io.*;
import java.net.*;
import java.util.Scanner;

public class Client {
    public static void main(String[] args) throws IOException {

        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            echoSocket = new Socket("localhost", 6666);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                    echoSocket.getInputStream()));
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host: localhost.");
            System.exit(1);
        }

        Reader rdr = new InputStreamReader(System.in);
        Scanner keyboard = new Scanner(rdr);

        String sentMessage = null;
        String my_message;

        while (true) {
            if (in.ready() && (sentMessage = in.readLine()) != null) System.out.println("Me: " + sentMessage);
            if (rdr.ready()) {
                my_message = keyboard.nextLine();
                if (my_message.equals("end")) {
                    out.println(my_message);
                    break;
                } else {
                    out.println("Adam: " + my_message);
                }
            }
            if (sentMessage != null && sentMessage.equals("end")) break;
        }


        out.close();
        in.close();
        echoSocket.close();
    }
}
