package lab04.Workers;


public class Student extends Worker {
    public Student(String pesel) {
        super(pesel);
    }

    @Override
    double getNetSalary() {
        return getGrossSalary() * 0.5;
    }
}
