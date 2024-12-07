package yym.svydovets.algorithm.task.csosvita.search_loopy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SearchTest {

    @Test
    void search() {
        int[] arr = new int[]{1,2,2,2,3,4};
        final String result = Search.searchOptimal(arr, 2);
        assertEquals("1 3 3", result);
    }

    @Test
    void search2() {
        int[] arr = new int[]{1,2,2,2,3,4};
        final String result = Search.searchOptimal(arr, 3);
        assertEquals("4 4 1", result);
    }

    @Test
    void search3() {
        int[] arr = new int[]{1,2,2,2,3,4};
        final String result = Search.searchOptimal(arr, 5);
        assertEquals("-1 -1 0", result);
    }

    @Test
    void search4() {
        int[] arr = new int[]{1,2,3,5,6,7};
        final String result = Search.searchOptimal(arr, 4);
        assertEquals("-1 -1 0", result);
    }
}