package yym.svydovets.algorithm.task.csosvita.data_structures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PointsTest {

    @Test
    void findMinLength() {
        long[] arr = new long[]{1,2,3,9,8,7};
        final long result = Points.findMinLength(arr, 2);
        assertEquals(2, result);
    }

    @Test
    void findMinLength1() {
        long[] arr = new long[]{2,-4,-5,1,0,-3,-1,4};
        final long result = Points.findMinLength(arr, 2);
        assertEquals(4, result);
    }

    @Test
    void findMinLength2() {
        long[] arr = new long[]{2};
        final long result = Points.findMinLength(arr, 1);
        assertEquals(0, result);
    }

    @Test
    void findMinLength3() {
        long[] arr = new long[]{2,2,2,2};
        final long result = Points.findMinLength(arr, 2);
        assertEquals(0, result);
    }

    @Test
    void findMinLength4() {
        long[] arr = new long[]{-1000000000L, 0, 1000000000L};
        final long result = Points.findMinLength(arr, 2);
        assertEquals(1000000000, result);
    }

    @Test
    void findMinLength5() {
        long[] arr = new long[]{1000000000L, 1000000002L, 1000000004L};
        final long result = Points.findMinLength(arr, 2);
        assertEquals(2, result);
    }
}