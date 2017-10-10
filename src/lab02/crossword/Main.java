package lab02.crossword;

public class Main {
    public static void main(String[] args){
        InteliCwDB test = new InteliCwDB("/home/prenc/Documents/IdeaProjects/javaLabs/src/lab02/crossword/cwdb.txt");
        System.out.printf(test.getRandom().toString());
    }
}
