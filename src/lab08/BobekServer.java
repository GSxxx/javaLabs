package lab08;

import sun.awt.image.ImageWatched;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BobekServer {
    public static void main(String[] args) throws IOException {

        TreeMap<String, LinkedList<String>> users = new TreeMap<>();
        LinkedList<String> tmp = new LinkedList<>();
        tmp.add(Long.toString("prenc".hashCode() % 1000000000L + 8999999999L));
        tmp.add("naperfumowawszy");
        tmp.add("0");
        tmp.add("plik1");
        tmp.add("plik2");
        tmp.add("plik3");
        users.put("prenc", tmp);

        TreeMap<String,String> data = new TreeMap<>();
        data.put("plik1","aaaaaaaaaaaaa");
        data.put("plik2","Ala ma kota");
        data.put("plik3","Rere kum kum");


        while (true) {

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

            Pattern r = Pattern.compile("([A-Z]+) ([^ ;]+)(;([^ ]+))? ?([^ ]+)?");

            Matcher m = r.matcher(inputLine);
            if (m.find()) {
                if (m.group(1).equals("LOGIN")) {
                    String user = m.group(2);
                    if (m.group(4).equals(users.get(user).get(1))) {
                        out.println(Long.toString(user.hashCode() % 1000000000L + 8999999999L));
                        users.get(user).set(2, "1");
                    } else {
                        System.out.println(m.group(4));
                        out.print(BobekClient.computeLevenshteinDistance(users.get(user).get(1), m.group(4)));
                    }
                }

                if (m.group(1).equals("LOGOUT")) {
                    boolean found = false;
                    for (Map.Entry<String, LinkedList<String>> entry : users.entrySet()) {
                        if (Long.toString(entry.getKey().hashCode() % 1000000000L + 8999999999L).equals(m.group(2))
                                && entry.getValue().get(2).equals("1")) {
                            out.println("true");
                            found = true;
                            break;
                        }
                    }
                    if(!found) out.println("false");
                }
                if (m.group(1).equals("LS")) {
                    boolean found = false;
                    for (Map.Entry<String, LinkedList<String>> entry : users.entrySet()) {
                        if (Long.toString(entry.getKey().hashCode() % 1000000000L + 8999999999L).equals(m.group(2))
                                && entry.getValue().get(2).equals("1")) {
                            StringBuilder output = new StringBuilder();
                            for (int i = 3; i < entry.getValue().size(); i++) {
                                if (i == entry.getValue().size() - 1) {
                                    output.append(entry.getValue().get(i));
                                } else {
                                    output.append(entry.getValue().get(i)).append(";");
                                }
                            }
                            out.println(output);
                            found = true;
                            break;
                        }
                    }
                    if(!found) out.println("false");
                }
                if (m.group(1).equals("GET")) {
                    boolean found = false;
                    for (Map.Entry<String, LinkedList<String>> entry : users.entrySet()) {
                        if (Long.toString(entry.getKey().hashCode() % 1000000000L + 8999999999L).equals(m.group(2))
                                && entry.getValue().get(2).equals("1")) {
                            String output;
                            output = data.get(m.group(5));
                            out.println(output);
                            found = true;
                            break;
                        }
                    }
                    if(!found) out.println("false");
                }


            }

            out.close();
            in.close();
            clientSocket.close();
            serverSocket.close();
        }

    }
}
