package wyp_lab06Tests;

import static org.junit.Assert.*;

import org.junit.Test;
import wyp_lab06.Heap;

import java.util.ArrayList;
import java.util.List;

public class HeapTest {

    @Test
    public void insert0intoNewHeap_topIs0() {

        Heap heap = new Heap();
        heap.insert(0);

        assertEquals("size should be 1", 1, heap.size());
        assertEquals(0, heap.top(), 0.001);
        assertEquals(1, heap.size());
    }

    @Test
    public void insert0AndThen2intoNewHeap_topIs2() {

        Heap heap = new Heap();
        heap.insert(0);
        heap.insert(2);

        assertEquals("size should be 2", 2, heap.size());
        assertEquals(2, heap.top(), 0.001);
    }

    @Test
    public void insert0And2And3And5And6intoNewHeap_topIs6() {

        Heap heap = new Heap();
        heap.insert(0);
        heap.insert(2);
        heap.insert(3);
        heap.insert(5);
        heap.insert(6);

        assertEquals(6, heap.top(), 0.001);
    }

    @Test
    public void extractMaxFromSmallHeap() {

        Heap heap = new Heap();
        heap.insert(2);
        heap.insert(4);
        heap.insert(9);
        heap.insert(5);
        heap.insert(6);

        assertEquals(9, heap.extract_max(), 0.001);
        assertEquals(4, heap.size(), 0.001);
    }

    @Test
    public void extractMaxFromHugeHeap() {

        Heap heap = new Heap();
        heap.insert(2);
        heap.insert(2);
        heap.insert(9);
        heap.insert(-100);
        heap.insert(5);
        heap.insert(14);
        heap.insert(5);
        heap.insert(18);
        heap.insert(5);
        heap.insert(13);

        assertEquals(18, heap.extract_max(), 0.001);
        assertEquals(9, heap.size(), 0.001);
    }


    @Test
    public void deleteMaxFromSmallHeap() {

        Heap heap = new Heap();
        heap.insert(2);
        heap.insert(4);
        heap.insert(9);
        heap.insert(5);
        heap.insert(6);
        heap.delete_max();
        heap.delete_max();

        assertEquals(5, heap.top(), 0.001);
        assertEquals(3, heap.size(), 0.001);
    }

    @Test
    public void replaceFirstElementInHeap() {

        Heap heap = new Heap();
        heap.insert(2);
        heap.insert(4);
        heap.insert(9);
        heap.insert(5);
        heap.insert(6);
        heap.replace(245);

        assertEquals(245, heap.top(), 0.001);
        assertEquals(5, heap.size(), 0.001);
    }

    @Test
    public void buildHeapFromList() {

        List<Double> myList = new ArrayList<>();
        myList.add(2.);
        myList.add(-21.);
        myList.add(11.);
        myList.add(47.);
        myList.add(99.);
        Heap heap = new Heap(myList);


        assertEquals(99, heap.top(), 0.001);
        assertEquals(5, heap.size(), 0.001);
    }

    @Test
    public void meldTwoHeaps() {

        List<Double> myList = new ArrayList<>();
        List<Double> myList2 = new ArrayList<>();
        myList.add(2.);
        myList.add(1.);
        myList.add(44.);
        myList.add(23.);
        myList.add(6.);
        Heap heap = new Heap(myList);
        myList2.add(2.);
        myList2.add(-21.);
        myList2.add(11.);
        myList2.add(47.);
        myList2.add(99.);
        Heap heap2 = new Heap(myList2);

        heap.meld(heap2);

        assertEquals(99, heap.top(), 0.001);
        assertEquals(10, heap.size(), 0.001);
    }


}
