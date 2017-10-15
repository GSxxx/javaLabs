package lab04.Workers;


public class FullTimeEmployee extends Worker {
    public FullTimeEmployee(String pesel) {
        super(pesel);
    }

    @Override
    double getNetSalary() {
        return getGrossSalary() * 0.77;
    }
}
