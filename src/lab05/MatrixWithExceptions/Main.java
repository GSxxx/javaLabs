package lab05.MatrixWithExceptions;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String filename = "C:\\Users\\gsxxx\\IdeaProjects\\javaLabs\\src\\lab05\\MatrixWithExceptions\\in.txt";
        String filename2 = "C:\\Users\\gsxxx\\IdeaProjects\\javaLabs\\src\\lab05\\MatrixWithExceptions\\in2.txt";
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filename));
            UpgradedMatrix A = new UpgradedMatrix(reader);
            reader = new BufferedReader(new FileReader(filename2));
            UpgradedMatrix B = new UpgradedMatrix(reader);
            System.out.println(A.toString());
            System.out.println(B.toString());
            System.out.println(A.add(B).toString());
            System.out.println(A.mul(B).toString());


        } catch (IOException | MatrixDimensionsException e) {
            System.out.printf(e.getMessage());
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    e.getMessage();
                }
            }
        }
    }
}
