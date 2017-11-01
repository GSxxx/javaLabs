package wyp_lab06;

import java.util.ArrayList;
import java.util.List;

public class Heap {

    private int heapSize = 0;
    private ArrayList<Double> tab = new ArrayList<>();

    public Heap() {
    }

    public Heap(List<Double> list) {
        tab = (ArrayList<Double>) list;
        heapSize = list.size();
        for (int i = heapSize / 2; i >= 0; i--) {
            heapify(i);
        }
    }

    public void insert(double value) {
        int currentIndex = heapSize;
        int parentIndex = parentIndex(currentIndex);
        tab.add(value);
        while (isChildGreaterThanParent(currentIndex, parentIndex)) {
            swapElements(currentIndex, parentIndex);
            currentIndex = parentIndex;
            parentIndex = parentIndex(currentIndex);
        }
        heapSize++;
    }

    public double extract_max() {
//        if (heapSize == 0) throw new Exception();
        swapExactElements(0, heapSize - 1);
        double value = tab.get(heapSize - 1);
        tab.remove(heapSize - 1);
        heapSize--;
        heapify(0);
        return value;
    }

    public void delete_max() {
//        if (heapSize == 0) throw new Exception();
        swapExactElements(0, heapSize - 1);
        tab.remove(heapSize - 1);
        heapSize--;
        heapify(0);
    }


    private void heapify(int i) {
        int left = i * 2 + 1;
        int right = (i + 1) * 2;
        int largest = i;

        if (left < heapSize && tab.get(left) > tab.get(i)) {
            largest = left;
        }
        if (right < heapSize && tab.get(right) > tab.get(largest)) {
            largest = right;
        }
        if (largest != i) {
            swapExactElements(i, largest);
            heapify(largest);
        }


    }

    public void replace(double i) {
        tab.set(0, i);
    }

    public void meld(Heap secondHeap) {
        this.tab.addAll(secondHeap.tab);
        heapSize += secondHeap.heapSize;
        for (int i = heapSize / 2; i >= 0; i--) {
            heapify(i);
        }
    }

    public Heap merge(Heap secondHeap) {
        Heap outHeap = new Heap();
        outHeap.tab.addAll(this.tab);
        outHeap.tab.addAll(secondHeap.tab);
        outHeap.heapSize = this.heapSize + secondHeap.heapSize;
        for (int i = outHeap.heapSize / 2; i >= 0; i--) {
            outHeap.heapify(i);
        }
        return outHeap;
    }


    //useful methods

    private boolean isChildGreaterThanParent(int currentIndex, int parentIndex) {
        return tab.get(currentIndex) > tab.get(parentIndex);
    }

    private void swapElements(int currentIndex, int parentIndex) {
        Double parentValue = parentValue(currentIndex);
        Double currentValue = tab.get(currentIndex);
        tab.set(parentIndex, currentValue);
        tab.set(currentIndex, parentValue);
    }

    private void swapExactElements(int firstIndex, int secondIndex) {
        Double tempValue = tab.get(secondIndex);
        tab.set(secondIndex, tab.get(firstIndex));
        tab.set(firstIndex, tempValue);
    }

    private Double parentValue(int currentIndex) {
        return tab.get(parentIndex(currentIndex));
    }

    private int parentIndex(int currentIndex) {
        return currentIndex / 2;
    }

    public int size() {
        return heapSize;
    }

    public double top() {
        return tab.get(0);
    }

}
