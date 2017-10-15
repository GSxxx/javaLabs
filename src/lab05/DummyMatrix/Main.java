package lab05.DummyMatrix;

import lab05.MatrixWithExceptions.MatrixDimensionsException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        String filename = "C:\\Users\\gsxxx\\IdeaProjects\\javaLabs\\src\\lab05\\DummyMatrix\\in.txt";
        String filename2 = "C:\\Users\\gsxxx\\IdeaProjects\\javaLabs\\src\\lab05\\DummyMatrix\\in2.txt";
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(filename));
            DummyMatrix A = new DummyMatrix(reader);
            reader = new BufferedReader(new FileReader(filename2));
            DummyMatrix B = new DummyMatrix(reader);
            System.out.println(A.toString());
            System.out.println(B.toString());
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
