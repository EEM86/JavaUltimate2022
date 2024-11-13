package yym.svydovets.algorithm.task.csosvita.two_pointers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SlevinTest {

    @Test
    void testLuckySlevin1() {
        int[] arr = new int[]{17,7,10,7,10};
        int k = 17;

        final int result = Slevin.luckySlevinNumbers(arr, k);
        assertEquals(4, result);
    }

    @Test
    void testLuckySlevin2() {
        int[] arr = new int[]{1,2,3,4,1};
        int k = 10;

        final int result = Slevin.luckySlevinNumbers(arr, k);
        assertEquals(2, result);
    }

    @Test
    void testLuckySlevin3() {
        int[] arr = new int[]{1,2,3,4,1};
        int k = 17;

        final int result = Slevin.luckySlevinNumbers(arr, k);
        assertEquals(0, result);
    }

    @Test
    void testLuckySlevin4() {
        int[] arr = new int[]{1,1,1,1,1};
        int k = 1;

        final int result = Slevin.luckySlevinNumbers(arr, k);
        assertEquals(5, result);
    }

}