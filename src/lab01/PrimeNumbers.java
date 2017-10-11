package lab01;


import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PrimeNumbers {

    public PrimeNumbers() {
        Scanner keyboard = new Scanner(System.in);
        System.out.println("Podaj liczbę.");
        int value = Integer.valueOf(keyboard.next());
        for (int x : findPrimeNumbersLessThan(value)) {
            System.out.printf("%d ", x);
        }

    }

    private List<Integer> findPrimeNumbersLessThan(int a) {
        List<Integer> l = new ArrayList<>();
        for (int i = 2; i < a; i++) {
            boolean isPrime = true;
            for (int d = 2; (double) d <= Math.sqrt((double) i); d++) {
                if (i % d == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) l.add(i);
        }
        return l;
    }
}
