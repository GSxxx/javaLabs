package lab04.Ciphers;

import java.io.*;

public class lab4 {
    public static void main(String arg[]) {
        String inputFileName = ("C:"+File.separator+"Users"+File.separator+"gsxxx"+File.separator+"Desktop"+File.separator+"tmp.txt");
        String outputFileName = ("C:"+File.separator+"Users"+File.separator+"gsxxx"+File.separator+"Desktop"+File.separator+"out.txt");

        Algorithm cipher= new ROT11();

        Cryptographer.cryptfile(inputFileName,outputFileName,cipher);
    }
}
