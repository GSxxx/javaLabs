package lab04.Ciphers;

public interface Algorithm {
    String  crypt(String input);
    String decrypt(String input);
}
