package yym.svydovets.algorithm.task.csosvita.search_loopy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InfiniteSequenceOfDigitsTest {

    @Test
    void findNumbers() {
        int[] arr = new int[]{3,14,7,6};
        final String result = InfiniteSequenceOfDigits.findNumbers(arr);
        assertEquals("0 0 1 0", result);
    }
}