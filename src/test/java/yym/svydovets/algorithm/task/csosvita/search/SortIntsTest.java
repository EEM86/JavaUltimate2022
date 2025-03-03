package yym.svydovets.algorithm.task.csosvita.search;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import org.junit.jupiter.api.Test;
import yym.svydovets.algorithm.task.csosvita.sort.SortInts;

class SortIntsTest {

    @Test
    void test1() {
        int[] arr = new int[]{5,2,3,1};
        final int[] result = SortInts.mergeSort(arr);

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

    @Test
    void nonRecursiveMergeSort() {
        int[] arr = new int[]{5,2,3,1};
        SortInts.nonRecursiveSort(arr);

        assertEquals(1, arr[0]);
        assertEquals(2, arr[1]);
        assertEquals(3, arr[2]);
        assertEquals(5, arr[3]);
    }

    @Test
    void nonRecursiveMergeSort2() {
        int[] arr = new int[]{8,7,6,5,4,3,2,1};
        SortInts.nonRecursiveSort(arr);

        assertEquals(1, arr[0]);
        assertEquals(2, arr[1]);
        assertEquals(3, arr[2]);
        assertEquals(4, arr[3]);
        assertEquals(5, arr[4]);
        assertEquals(6, arr[5]);
        assertEquals(7, arr[6]);
        assertEquals(8, arr[7]);
    }

    @Test
    void auxMergeTest() {
        String[] names = new String[]{"Mary", "John", "Emma"};
        int[] heights = new int[]{180,165,170};
        final String[] strings = SortInts.sortPeople(names, heights);
        System.out.println(Arrays.toString(strings));
        System.out.println(Arrays.toString(heights));
        assertEquals("Mary", strings[0]);
        assertEquals("Emma", strings[1]);
        assertEquals("John", strings[2]);
    }

    @Test
    void auxMergeTest2() {
        String[] names = new String[]{"IEO","Sgizfdfrims","QTASHKQ","Vk","RPJOFYZUBFSIYp","EPCFFt","VOYGWWNCf","WSpmqvb"};
        int[] heights = new int[]{17233,32521,14087,42738,46669,65662,43204,8224};
        final String[] strings = SortInts.sortPeople(names, heights);
        System.out.println(Arrays.toString(strings));
        System.out.println(Arrays.toString(heights));
    }

}