package lab08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.LinkedList;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NewThread implements Runnable {

    private PrintWriter out;
    private BufferedReader in;

    NewThread(Socket clientSocket) throws IOException {
        out = new PrintWriter(clientSocket.getOutputStream(), true);
        in = new BufferedReader(new InputStreamReader(clientSocket.getInputStream()));
    }

    @Override
    public void run() {
        try {
            String inputLine;
            inputLine = in.readLine();

            Pattern r = Pattern.compile("([A-Z]+) ([^ ;]+)(;([^ ]+))? ?([^ ]+)?");
            Matcher m = r.matcher(inputLine);

            if (m.find()) {
                if (m.group(1).equals("LOGIN")) {
                    String user = m.group(2);
                    if (m.group(4).equals(BobekServer.users.get(user).get(1))) {
                        out.println(Long.toString(user.hashCode() % 1000000000L + 8999999999L));
                        synchronized (BobekServer.users) {
                            BobekServer.users.get(user).set(2, "1");
                        }
                    } else {
                        out.print(BobekClient.computeLevenshteinDistance(BobekServer.users.get(user).get(1), m.group(4)));
                    }
                }

                if (m.group(1).equals("LOGOUT")) {
                    boolean found = false;
                    for (Map.Entry<String, LinkedList<String>> entry : BobekServer.users.entrySet()) {
                        if (Long.toString(entry.getKey().hashCode() % 1000000000L + 8999999999L).equals(m.group(2))
                                && entry.getValue().get(2).equals("1")) {
                            out.println("true");
                            found = true;
                            break;
                        }
                    }
                    if (!found) out.println("false");
                }
                if (m.group(1).equals("LS")) {
                    boolean found = false;
                    for (Map.Entry<String, LinkedList<String>> entry : BobekServer.users.entrySet()) {
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
                    if (!found) out.println("false");
                }
                if (m.group(1).equals("GET")) {
                    boolean found = false;
                    for (Map.Entry<String, LinkedList<String>> entry : BobekServer.users.entrySet()) {
                        if (Long.toString(entry.getKey().hashCode() % 1000000000L + 8999999999L).equals(m.group(2))
                                && entry.getValue().get(2).equals("1")) {
                            String output;
                            output = BobekServer.data.get(m.group(5));
                            out.println(output);
                            found = true;
                            break;
                        }
                    }
                    if (!found) out.println("false");
                }
            }

            out.close();
            in.close();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
