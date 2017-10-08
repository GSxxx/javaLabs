package lab02;

import java.util.LinkedList;
import java.util.Scanner;

class Test {
    private LinkedList<Punkt3D> points;

    Test() {
        this.points = new LinkedList<>();
    }

    void main() {
        System.out.println("1. Wczytaj punkt 3D");
        System.out.println("2. Wyświetl wszystkie punkty");
        System.out.println("3. Oblicz odległość");
        System.out.println("4. Zakończ");
        System.out.println("?");

        Scanner keyboard = new Scanner(System.in);
        boolean stop = true;
        while (stop) {
            System.out.println("Podaj opcję.");
            String input = keyboard.nextLine();


            switch (input) {
                case "1":
                    System.out.println("Podaj x.");
                    double x = Double.valueOf(keyboard.nextLine());

                    System.out.println("Podaj y.");
                    double y = Double.valueOf(keyboard.nextLine());

                    System.out.println("Podaj z.");
                    double z = Double.valueOf(keyboard.nextLine());

                    points.add(new Punkt3D(x, y, z));

                    System.out.println(String.format("Wgrano punkt o współrzędnych (%.2f,%.2f,%.2f).", x, y, z));
                    break;
                case "2":
                    if (points.isEmpty()) {
                        System.out.println("Nie wgrano punktów!");
                        break;
                    }
                    for (Punkt3D point : points) {
                        System.out.println(String.format("Punkt o współrzędnych (%.2f,%.2f,%.2f).", point.getX(), point.getY(), point.getZ()));
                    }
                    break;
                case "3":
                    if (points.isEmpty()) {
                        System.out.println("Nie wgrano jeszcze punktów!");
                        break;
                    }

                    System.out.println("Podaj punkt względem, którego mam obliczyć odległość.");
                    System.out.println("Podaj x.");
                    double tmp_x = Double.valueOf(keyboard.nextLine());

                    System.out.println("Podaj y.");
                    double tmp_y = Double.valueOf(keyboard.nextLine());

                    System.out.println("Podaj z.");
                    double tpm_z = Double.valueOf(keyboard.nextLine());

                    for (Punkt3D point : points) {
                        System.out.println(String.format("Odległość to: %.2f", point.distance(new Punkt3D(tmp_x, tmp_y, tpm_z))));
                    }

                    break;

                case "4":
                    stop = false;
            }
        }
    }
}
