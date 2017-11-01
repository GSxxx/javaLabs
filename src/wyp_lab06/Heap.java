package wyp_lab06;

import java.util.ArrayList;
import java.util.List;

public class Heap<T extends Comparable<? super T>> {

    private int heapSize = 0;
    private ArrayList<T> tab = new ArrayList<>();

    public Heap() {
    }

    public Heap(List<T> list) {
        tab = (ArrayList<T>) list;
        heapSize = list.size();
        for (int i = heapSize / 2; i >= 0; i--) {
            heapify(i);
        }
    }

    public void insert(T value) {
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

    public T extract_max() {
//        if (heapSize == 0) throw new Exception();
        swapExactElements(0, heapSize - 1);
        T value = tab.get(heapSize - 1);
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

        if (left < heapSize && tab.get(left).compareTo(tab.get(i)) > 0) {
            largest = left;
        }
        if (right < heapSize && tab.get(right).compareTo(tab.get(largest)) > 0) {
            largest = right;
        }
        if (largest != i) {
            swapExactElements(i, largest);
            heapify(largest);
        }


    }

    public void replace(T i) {
        tab.set(0, i);
    }

    public void meld(Heap<T> secondHeap) {
        this.tab.addAll(secondHeap.tab);
        heapSize += secondHeap.heapSize;
        for (int i = heapSize / 2; i >= 0; i--) {
            heapify(i);
        }
    }

    public Heap<T> merge(Heap<T> secondHeap) {
        Heap<T> outHeap = new Heap<>();
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
        return tab.get(currentIndex).compareTo(tab.get(parentIndex)) > 0;
    }

    private void swapElements(int currentIndex, int parentIndex) {
        T parentValue = parentValue(currentIndex);
        T currentValue = tab.get(currentIndex);
        tab.set(parentIndex, currentValue);
        tab.set(currentIndex, parentValue);
    }

    private void swapExactElements(int firstIndex, int secondIndex) {
        T tempValue = tab.get(secondIndex);
        tab.set(secondIndex, tab.get(firstIndex));
        tab.set(firstIndex, tempValue);
    }

    private T parentValue(int currentIndex) {
        return tab.get(parentIndex(currentIndex));
    }

    private int parentIndex(int currentIndex) {
        return currentIndex / 2;
    }

    public int size() {
        return heapSize;
    }

    public T top() {
        return tab.get(0);
    }

}
