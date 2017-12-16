package lab08;

import jdk.nashorn.internal.runtime.regexp.joni.Regex;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BobekServer {
    public static void main(String[] args) throws IOException {

        while (true) {


            String pass = "naperfumowawszy";

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
                System.out.println("Connection accepted.");
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

            Pattern r = Pattern.compile("([A-Z]+) ([^ ]+)(;([^ ]+))?");
            boolean is_logged = false;
            String user="";

            Matcher m = r.matcher(inputLine);
            if (m.find()) {
                if (m.group(1).equals("LOGIN")) {
                    if (m.group(4).equals(pass)) {
                        is_logged = true;
                        user = m.group(2);
                        out.println(Long.toString(user.hashCode() % 1000000000L + 8999999999L));
                    } else {
                        System.out.println(m.group(4));
                        out.print(BobekClient.computeLevenshteinDistance(pass, m.group(4)));
                    }
                }

                if (m.group(1).equals("LOGOUT")) {
                    if (is_logged && m.group(2).equals(Long.toString(user.hashCode() % 1000000000L + 8999999999L))) {
                        is_logged = false;
                        out.println("true");
                    } else {
                        out.println("false");
                    }
                }
                if (m.group(1).equals("LS")) {
                }
                if (m.group(1).equals("GET")) {
                }


            }

            out.close();
            in.close();
            clientSocket.close();
            serverSocket.close();
        }

    }
}
