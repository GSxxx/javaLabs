package lab04.Ciphers;

public class ROT11 implements Algorithm {

    private final static int shift = 11;
    private final static String alphabet = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";

    @Override
    public String crypt(String input) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                output.append(' ');
                continue;
            }
            int position = 0;
            while (alphabet.charAt(position) != input.charAt(i)) position++;
            output.append(alphabet.charAt(position + shift > alphabet.length() - 1 ? position + shift - alphabet.length() : position + shift));
        }
        return output.toString();
    }

    @Override
    public String decrypt(String input) {
        StringBuilder output = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                output.append(' ');
                continue;
            }
            int position = 0;
            while (alphabet.charAt(position) != input.charAt(i)) position++;
            output.append(alphabet.charAt(position - shift < 0 ? position - shift + alphabet.length() - 1 : position - shift));
        }
        return output.toString();
    }
}
