package yym.svydovets.algorithm.task.csosvita.search_loopy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CountSumTest {

    @Test
    void countSum() {
        int[] arr = new int[]{1,2,3};

        final int result = CountSum.countSum(arr, 3);
        assertEquals(2, result);
    }

    @Test
    void countSum2() {
        int[] arr = new int[]{1,1,1};

        final int result = CountSum.countSum(arr, 2);
        assertEquals(2, result);
    }

    @Test
    void countSum3() {
        int[] arr = new int[]{2,1,-5,7,3,6,-11,4,2};

        final int result = CountSum.countSum(arr, 3);
        assertEquals(4, result);
    }
}