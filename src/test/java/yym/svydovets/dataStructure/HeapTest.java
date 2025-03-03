package yym.svydovets.dataStructure;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HeapTest {

    @Test
    void buildHeap() {
        int[] arr = {1, 3, 5, 4, 6, 13, 10, 9, 8, 15, 17};
        final Heap heap = new Heap();
        heap.buildHeap(arr, arr.length);

        assertEquals(17, arr[0]);
    }
}