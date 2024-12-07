package yym.svydovets.algorithm.task.csosvita.search_loopy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MinEvenTest {

    @Test
    void minEven() {
        int[] arr = new int[]{3,7,4,6};
        final int result = MinEven.minEven(arr);
        assertEquals(4, result);
    }

    @Test
    void minEven2() {
        int[] arr = new int[]{1,3,5,7};
        final int result = MinEven.minEven(arr);
        assertEquals(-1, result);
    }
}