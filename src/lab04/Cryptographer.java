package lab04;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class Cryptographer {
    static void cryptfile(String inputFile, String outputFile, Algorithm cipher) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(cipher.crypt(line));
                bufferedWriter.newLine();
            }

            bufferedReader.close();
            bufferedWriter.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }

    static void decryptfile(String inputFile, String outputFile, Algorithm cipher) {
        try {
            BufferedReader bufferedReader = new BufferedReader(new FileReader(inputFile));
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(outputFile));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                bufferedWriter.write(cipher.decrypt(line));
                bufferedWriter.newLine();
            }

            bufferedReader.close();
            bufferedWriter.close();

        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
}
