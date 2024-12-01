package yym.svydovets.algorithm.task.csosvita.heapify;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class CandiesTest {

    @Test
    void findMinIncrements() {
        long[] arr = new long[]{5,1,2,7};
        final long result = Candies.findMinIncrements(arr);
        assertEquals(3, result);
    }

    @Test
    void findMinIncrements2() {
        long[] arr = new long[]{1,1,1};
        final long result = Candies.findMinIncrements(arr);
        assertEquals(0, result);
    }

    @Test
    void findMinIncrements3() {
        long[] arr = new long[]{1};
        final long result = Candies.findMinIncrements(arr);
        assertEquals(0, result);
    }

    @Test
    void findMinIncrements4() {
        long[] arr = new long[]{10, 20, 30};
        final long result = Candies.findMinIncrements(arr);
        assertEquals(10, result);
    }

    @Test
    void findMinIncrements5() {
        long[] arr = new long[]{1, 2, 3, 4};
        final long result = Candies.findMinIncrements(arr);
        assertEquals(2, result);
    }
}