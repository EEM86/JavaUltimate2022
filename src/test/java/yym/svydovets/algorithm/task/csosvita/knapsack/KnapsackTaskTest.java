package yym.svydovets.algorithm.task.csosvita.knapsack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class KnapsackTaskTest {

    @Test
    void getMax() {
        int[] weight = new int[]{9,7,6,5,8,4};
        int[] cost = new int[]{7,1,3,6,8,3};
        int s = 20;

        final long result = KnapsackTask.getMax(weight, s, cost);
        assertEquals(17, result);
    }

    @Test
    void getMax2() {
        int[] weight = new int[]{1,2,3};
        int[] cost = new int[]{10,20,30};
        int s = 6;

        final long result = KnapsackTask.getMax(weight, s, cost);
        assertEquals(60, result);
    }

    @Test
    void getMax3() {
        int[] weight = new int[]{5, 6, 7};
        int[] cost = new int[]{10,20,30};
        int s = 4;

        final long result = KnapsackTask.getMax(weight, s, cost);
        assertEquals(0, result);
    }

    @Test
    void getMax4() {
        int[] weight = new int[]{2, 3, 4};
        int[] cost = new int[]{15, 10, 20};
        int s = 7;

        final long result = KnapsackTask.getMax(weight, s, cost);
        assertEquals(30, result);
    }

    @Test
    void getMax5() {
        int[] weight = new int[]{1, 2, 1, 3, 2};
        int[] cost = new int[]{5, 10, 5, 15, 10};
        int s = 5;

        final long result = KnapsackTask.getMax(weight, s, cost);
        assertEquals(25, result);
    }
}