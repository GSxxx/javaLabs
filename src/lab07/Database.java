package lab07;

import java.sql.*;

public class Database{
    public static void main(String[] args) {
         Connection conn = null;
         Statement stmt = null;
         ResultSet rs = null;
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            conn =
                    DriverManager.getConnection("jdbc:mysql://mysql.agh.edu.pl/prenc",
                            "prenc","nFHp1Af6gWhTVyfR");


        } catch (SQLException ex) {
            // handle any errors
            System.out.println("SQLException: " + ex.getMessage());
            System.out.println("SQLState: " + ex.getSQLState());
            System.out.println("VendorError: " + ex.getErrorCode());
        }catch(Exception e){e.printStackTrace();}

    try {
        stmt = conn.createStatement();

        // Wyciagamy wszystkie pola z kolumny name
        // znajdujące się w tabeli users
        rs = stmt.executeQuery("SELECT * FROM books");

          while(rs.next()){
            String name = rs.getString(1);
            System.out.println("Isbn: "+name);
        }
    }catch (SQLException ex){
        // handle any errors

        }finally {
        // zwalniamy zasoby, które nie będą potrzebne
        if (rs != null) {
        try {
        rs.close();
        } catch (SQLException sqlEx) { } // ignore
        rs = null;
        }

        if (stmt != null) {
        try {
        stmt.close();
        } catch (SQLException sqlEx) { } // ignore

        stmt = null;
        }
        }
        }
}

