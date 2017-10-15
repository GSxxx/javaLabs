package lab04.Workers;

import lab01.Pesel;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;

public class Bosses {
    private LinkedList<Worker> workers = new LinkedList<>();

    void addWorker(Worker input) {
        workers.add(input);
    }

    void removeWorker(String input) {
        for (Worker x : workers) {
            if (x.getPesel().equals(input)) {
                workers.remove(x);
                break;
            }
        }
    }

    Worker find(String pesel) {
        for (Worker x : workers) {
            if (x.getPesel().equals(pesel)) {
                return x;
            }
        }
        return null;
    }

    void changeGrossSalary(Worker input, double salary) {
        input.setGrossSalary(salary);
    }

    double getGrossSalary(Worker input) {
        return input.getGrossSalary();
    }

    double getNetSalary(Worker input) {
        return input.getNetSalary();
    }

    @Override
    public String toString() {
        StringBuilder output = new StringBuilder();
        for (Worker x : workers) {
            output.append("ID: ")
                    .append(x.getPesel())
                    .append(" Gross Salary: ")
                    .append(String.format("%.2f", x.getGrossSalary()))
                    .append(" Net Salary: ")
                    .append(String.format("%.2f", x.getNetSalary()))
                    .append(x instanceof Student ? " (Student)" : " (Full-time employee)")
                    .append("\n");
        }
        return output.toString();
    }

    public void sort(){
        workers.sort(new SortByGrossSalary());
    }


}
