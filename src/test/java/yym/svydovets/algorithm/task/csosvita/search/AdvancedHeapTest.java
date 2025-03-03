package yym.svydovets.algorithm.task.csosvita.search;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import yym.svydovets.algorithm.task.csosvita.sort.AdvancedHeap;

class AdvancedHeapTest {

    @Test
    void testAdvancedHeap1() {
        var heap = new AdvancedHeap();
        heap.add(4);
        heap.add(9);
        int min = heap.getMin();
        assertEquals(4, min);

        heap.remove(4);
        int result = heap.getMin();
        assertEquals(9, result);
    }

    @Test
    void testAdvancedHeap2() {
        var heap = new AdvancedHeap();
        heap.add(22);
        heap.add(-22);
        int result = heap.getMin();
        assertEquals(-22, result);
        heap.remove( -22);
        heap.add(16);
        heap.add(1);
        result = heap.getMin();
        assertEquals(1, result);
        heap.add(-9);
        heap.add(12);
        heap.add(-23);
        heap.add(20);
        heap.remove( 20);
        heap.remove( 22);
        result = heap.getMin();
        assertEquals(-23, result);
        heap.add(-12);
        heap.remove( 12);
        heap.add(5);
        heap.add(10);
        heap.add(22);
        heap.remove( 16);
        heap.add(2);
        heap.remove( -23);
        heap.remove( -12);
        heap.add(12);
        heap.add(-1);
        result = heap.getMin();
        assertEquals(-9, result);
    }

}