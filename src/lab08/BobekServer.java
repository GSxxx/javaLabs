package lab08;


import wyp_lab09.gadu_gadu.SocketUsage;

import java.io.IOException;
import java.lang.Thread;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.*;


public class BobekServer {
    static TreeMap<String, LinkedList<String>> users;
    static TreeMap<String, String> data;

    public static void main(String[] args) throws IOException {
        users = new TreeMap<>();
        LinkedList<String> tmp = new LinkedList<>();
        tmp.add(Long.toString("prenc".hashCode() % 1000000000L + 8999999999L));
        tmp.add("naperfumowawszy");
        tmp.add("0");
        tmp.add("plik1");
        tmp.add("plik2");
        tmp.add("plik3");
        users.put("prenc", tmp);

        data = new TreeMap<>();
        data.put("plik1", "aaaaaaaaaaaaa");
        data.put("plik2", "Ala ma kota");
        data.put("plik3", "Rere kum kum");


        ServerSocket serverSocket = null;
        try {
            serverSocket = new ServerSocket(3000);
        } catch (IOException e) {
            System.out.println("Could not listen on port: 3000");
            System.exit(-1);
        }

        while (true) {
            Socket clientSocket = null;
            try {
                clientSocket = serverSocket.accept();
                System.out.println("Connection accepted.");
            } catch (IOException e) {
                System.out.println("Accept failed: 3000");
                System.exit(-1);
            }

            new Thread(new NewThread(clientSocket)).start();
        }
    }
}
