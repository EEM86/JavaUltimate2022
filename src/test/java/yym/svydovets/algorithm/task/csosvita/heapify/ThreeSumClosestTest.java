package yym.svydovets.algorithm.task.csosvita.heapify;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ThreeSumClosestTest {

    @Test
    void test1() {
        int[] arr = new int[]{-1,2,1,-4};
        int target = 1;
        final int result = ThreeSumClosest.closest3Sum(arr, target);
        assertEquals(2, result);
    }

    @Test
    void test2() {
        int[] arr = new int[]{0,0,0};
        int target = 1;
        final int result = ThreeSumClosest.closest3Sum(arr, target);
        assertEquals(0, result);
    }

}