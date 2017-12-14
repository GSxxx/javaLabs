import java.sql.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Database {
    private Connection conn = null;
    private ResultSet rs = null;

    ResultSet sendQuery(String query) {
        //inserting pattern
        Pattern r = Pattern.compile("([0-9]{13}) ([A-Z].*) ([A-Z].*[A-Z][a-z]+) ?([0-9]{4})?");
        Matcher m = r.matcher(query);
        int i = 1;

        //timeout
        DriverManager.setLoginTimeout(1);

        while (i <= 3) {
            try {
                System.out.println("Try " + i +"...");
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                conn =
                        DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/prenc",
                                "prenc", "nFHp1Af6gWhTVyfR");
                i = 5;
                System.out.println("Connection established.");
            } catch (SQLException ex) {
                System.out.println("Connection failure.");
                i++;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if(i == 4) {
            System.out.println("Unable to establish connection.");
            return null;
        }

        try {
            Statement stmt = conn.createStatement();
            if (query.matches("[0-9]+"))
                rs = stmt.executeQuery("SELECT * FROM books WHERE isbn='" + query + "'");
            else if (m.find()) {
                stmt.executeUpdate("INSERT INTO books VALUES ('" + m.group(1) + "','" + m.group(2) + "','" + m.group(3) + "'," + m.group(4) + ")");
            } else
                rs = stmt.executeQuery("SELECT * FROM books WHERE author LIKE '% " + query + "'");

        } catch (SQLException ex) {
            ex.getMessage();
        }

        return rs;
    }
}

