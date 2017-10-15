package lab01;

public class Pesel {
    private String pesel;

    public String getPesel() {
        return pesel;
    }

    public Pesel(String pesel) {
        this.pesel = pesel;
    }

    static boolean check(Pesel input) {
        if (input.pesel.length() != 11) return false;

        int pattern[] = {9, 7, 3, 1, 9, 7, 3, 1, 9, 7};
        int result = 0;

        for (int i = 0; i < 10; i++) {
            result += Character.getNumericValue(input.pesel.charAt(i)) * pattern[i];
        }
        result = result % 10;

        return result == Character.getNumericValue(input.pesel.charAt(10));
    }
}
