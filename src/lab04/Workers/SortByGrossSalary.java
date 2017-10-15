package lab04.Workers;

import java.util.Comparator;

public class SortByGrossSalary implements Comparator<Worker> {
    @Override
    public int compare(Worker o1, Worker o2) {
        return (int) (o1.getGrossSalary() - o2.getGrossSalary());
    }
}
