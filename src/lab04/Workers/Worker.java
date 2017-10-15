package lab04.Workers;

import lab01.Pesel;

public abstract class Worker {
    private Pesel pesel;

    public double getGrossSalary() {
        return grossSalary;
    }

    public void setGrossSalary(double grossSalary) {
        this.grossSalary = grossSalary;
    }

    private double grossSalary;

    public Worker(String pesel) {
        this.pesel = new Pesel(pesel);
        this.grossSalary = 0;
    }

    String getPesel(){
        return this.pesel.getPesel();
    }
    abstract double getNetSalary();
}
