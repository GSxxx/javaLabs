package lab04.Workers;


public class Main {
    public static void main(String[] args) {
        Bosses test = new Bosses();

        test.addWorker(new Student("12312381212"));
        test.addWorker(new Student("09801231232"));
        test.addWorker(new FullTimeEmployee("77777312312"));
        test.addWorker(new FullTimeEmployee("12312333312"));

        test.changeGrossSalary(test.find("09801231232"), 666);
        test.changeGrossSalary(test.find("12312333312"), 999);
        test.changeGrossSalary(test.find("77777312312"), 123);
        test.changeGrossSalary(test.find("12312381212"), 1500);

        System.out.println(test.toString());

        test.removeWorker("12312333312");

        System.out.println(test.toString());

        test.sort();

        System.out.println(test.toString());





    }
}
