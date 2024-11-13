package yym.svydovets.algorithm.task.csosvita.two_pointers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TreesTest {

    @Test
    void trees() {
        int k = 3;
        int[] arr = new int[]{1,2,1,3,2};

        final int[] result = Trees.trees(arr, k);
        assertEquals(2, result[0]);
        assertEquals(4, result[1]);
    }

    @Test
    void trees2() {
        int k = 4;
        int[] arr = new int[]{2,4,2,3,3,1};

        final int[] result = Trees.trees(arr, k);
        assertEquals(2, result[0]);
        assertEquals(6, result[1]);
    }
}