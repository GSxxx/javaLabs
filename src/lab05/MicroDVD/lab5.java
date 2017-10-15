package lab05.MicroDVD;

public class lab5 {
    public static void main(String[] args) {
        String inputFileName = "C:\\Users\\gsxxx\\IdeaProjects\\javaLabs\\src\\lab05\\gravity.txt";
        String outputFileName = "C:\\Users\\gsxxx\\IdeaProjects\\javaLabs\\src\\lab05\\gravityOutput.txt";

        try {
            MicroDVD.delay(inputFileName, outputFileName, 20, 25);
        } catch (Exception e) {
            System.out.println("Line: " + e.getStackTrace()[0].getLineNumber());
            System.out.println("Error: " + e.getMessage());
        }
    }
}
