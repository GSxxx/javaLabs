package lab02;

public class lab2 {
    public static void main(String[] args) {

        //test do zadania 3
        Punkt2D first = new Punkt2D(3, 2);
        Punkt2D second = new Punkt2D(1, 5);

        System.out.println(first.distance(second));

        //test do zadania 4
        Punkt3D first3D = new Punkt3D(3, 3, 3);
        Punkt3D second3D = new Punkt3D(3, 5, 3);

        System.out.println(first3D.distance(second3D));

        Test test = new Test();
        test.main();
    }
}
