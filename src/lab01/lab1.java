package lab01;

import lab05.MatrixWithExceptions.MatrixDimensionsException;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class lab1 {
    public static void main(String[] args) {

//        Login log = new Login ("ala", "makota");
//        try{
//            InputStreamReader rd = new InputStreamReader(System.in);
//            BufferedReader bfr = new BufferedReader(rd);
//
//            System.out.println("wpisz login");
//            String login = bfr.readLine();
//            System.out.println("wpisz hasło");
//            String haslo = bfr.readLine();
//
//        if(log.check(login,haslo)) System.out.println("OK");
//        else System.out.println("Błąd danych");
//
//        }catch(IOException e){e.printStackTrace();}


//
//
//
//        //test do peselu
//        Pesel p = new Pesel("90990909909");
//
//        if (Pesel.check(p))
//            System.out.println("Pesel is correct!");
//        else
//            System.out.println("Pesel is incorrect!!!");

        //test do macierzy
        Matrix first= new Matrix(2,3,3,4,5,6,7,8);
        Matrix second= new Matrix(3,2,6,5,4,3,2,1);


        try {
            System.out.println((first.mul(second)).toString());
        } catch (MatrixDimensionsException e) {
            e.printStackTrace();
        }
//
//
//        try {
//            System.out.println(first.add(second).toString());
//            System.out.println(first.mul(second).toString());
//        } catch (MatrixDimensionsException e) {
//            e.printStackTrace();
//        }

        //test do primem numbers
//        new PrimeNumbers();

    }
}
