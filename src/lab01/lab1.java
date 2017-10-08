package lab01;

import java.util.Scanner;

public class lab1 {
    public static void main(String[] args) {

//        //login
//        Scanner keyboard = new Scanner(System.in);
//        System.out.println("Podaj swój login.");
//        String login = keyboard.nextLine();
//
//        System.out.println("Podaj swoje hasło.");
//        String password = keyboard.nextLine();
//
//        if(login.equals("12345") && password.equals("123"))
//            System.out.println("Access granted!");
//        else
//            System.out.println("Access denied!");
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
        Matrix first= new Matrix(2,2,3,4,5,6);
        Matrix second= new Matrix(2,2,6,5,4,3);

        System.out.println(first.toString());
        System.out.println(second.toString());

    }
}
