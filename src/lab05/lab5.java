package lab05;

import java.io.File;

public class lab5 {
    public static void main(String[] args) {
        String inputFileName = "C:" + File.separator + "Users" + File.separator + "gsxxx" +
                File.separator + "Desktop" + File.separator + "gravity.txt";
        String outputFileName = "C:" + File.separator + "Users" + File.separator + "gsxxx" +
                File.separator + "Desktop" + File.separator + "gravityOutput.txt";

        try {
            MicroDVD.delay(inputFileName, outputFileName, 20, 25);
        } catch (Exception e) {
            System.out.println("Line: " + e.getStackTrace()[0].getLineNumber());
            System.out.println("Error: " + e.getMessage());
        }
    }
}
