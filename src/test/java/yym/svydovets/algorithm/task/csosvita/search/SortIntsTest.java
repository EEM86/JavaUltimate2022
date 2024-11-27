package yym.svydovets.algorithm.task.csosvita.search;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SortIntsTest {

    @Test
    void test1() {
        int[] arr = new int[]{5,2,3,1};
        final int[] result = SortInts.sort(arr);

        assertEquals(1, result[0]);
        assertEquals(2, result[1]);
        assertEquals(3, result[2]);
        assertEquals(5, result[3]);
    }

    @Test
    void testInsertionSort() {
        int[] arr = new int[]{5,2,3,1};
        final int[] result = SortInts.insertionSort(arr);

        assertEquals(1, result[0]);
        assertEquals(2, result[1]);
        assertEquals(3, result[2]);
        assertEquals(5, result[3]);
    }

    @Test
    void auxSort() {
        int[] arr = new int[]{5,2,3,1};
        final int[] result = SortInts.auxSort(arr, 0, arr.length);

        assertEquals(1, result[0]);
        assertEquals(2, result[1]);
        assertEquals(3, result[2]);
        assertEquals(5, result[3]);
    }

}