package lab04.Ciphers;

public class lab4 {
    public static void main(String arg[]) {
        String inputFileName = "C:\\Users\\gsxxx\\IdeaProjects\\javaLabs\\src\\lab04\\Ciphers\\tmp.txt";
        String outputFileName = "C:\\Users\\gsxxx\\IdeaProjects\\javaLabs\\src\\lab04\\Ciphers\\out.txt";

        Algorithm cipher= new ROT11();

        Cryptographer.cryptfile(inputFileName,outputFileName,cipher);
    }
}
