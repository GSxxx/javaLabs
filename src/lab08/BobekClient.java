package lab08;

import java.io.*;
import java.net.Socket;
import java.util.LinkedList;

public class BobekClient {
    String id;
    private LinkedList<String> list = new LinkedList<>();


    BobekClient() throws IOException {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = new BufferedReader(new FileReader("fetch.txt"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        String data;
        while ((data = bufferedReader.readLine()) != null) {
            list.add(data);
        }
        int distance;
        String out;
        while(list.size()!= 1){
            id = list.get(0);
            out = connectToServer(id);
            if(out.matches("[0-9]{1,9}")){
                distance = Integer.parseInt(out);
                for(int i=1; i < list.size(); i++){
                    if(distance != computeLevenshteinDistance(id, list.get(i))){
                        list.remove(i);
                        i--;
                    }
                }
                list.remove(0);
            } else {
                id = out;
                break;
            }
        }
    }


    private String connectToServer(String password) {
        String output = "";
        String login = "szymon";

        Socket echoSocket = null;
        PrintWriter out = null;
        BufferedReader in = null;

        try {
            echoSocket = new Socket("szymon.ia.agh.edu.pl", 3000);
            out = new PrintWriter(echoSocket.getOutputStream(), true);
            in = new BufferedReader(new InputStreamReader(
                    echoSocket.getInputStream()));

            System.out.println("Connction established.");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        out.printf("LOGIN\n%s;%s", login, password);

        try {
            output = in.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            out.close();
            in.close();
            echoSocket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        return output;
    }


    int minimum(int a, int b, int c) {
        return Math.min(Math.min(a, b), c);
    }

    int computeLevenshteinDistance(CharSequence lhs, CharSequence rhs) {
        int[][] distance = new int[lhs.length() + 1][rhs.length() + 1];

        for (int i = 0; i <= lhs.length(); i++)
            distance[i][0] = i;
        for (int j = 1; j <= rhs.length(); j++)
            distance[0][j] = j;

        for (int i = 1; i <= lhs.length(); i++)
            for (int j = 1; j <= rhs.length(); j++)
                distance[i][j] = minimum(
                        distance[i - 1][j] + 1,
                        distance[i][j - 1] + 1,
                        distance[i - 1][j - 1] + ((lhs.charAt(i - 1) == rhs.charAt(j - 1)) ? 0 : 1));

        return distance[lhs.length()][rhs.length()];
    }


}
