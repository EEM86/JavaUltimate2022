package yym.svydovets.algorithm.task.csosvita.search_loopy;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.Test;

class MultiplyTest {

    @Test
    void findMaxMultiply() {
        List<Integer> arr = List.of(4,3,5,2,5);

        final int[] result = Multiply.findMaxMultiply(arr);
        assertEquals(5, result[0]);
        assertEquals(5, result[1]);
    }

    @Test
    void findMaxMultiply2() {
        List<Integer> arr = List.of(4,3,-5,2,5);

        final int[] result = Multiply.findMaxMultiply(arr);
        assertEquals(4, result[0]);
        assertEquals(5, result[1]);
    }

    @Test
    void findMaxMultiply3() {
        List<Integer> arr = List.of(-4, -5, 0, 2, 3);

        final int[] result = Multiply.findMaxMultiply(arr);
        assertEquals(-5, result[0]);
        assertEquals(-4, result[1]);
    }

    @Test
    void findMaxMultiply4() {
        List<Integer> arr = List.of(Integer.MAX_VALUE, Integer.MIN_VALUE, Integer.MAX_VALUE, 2, 4);

        final int[] result = Multiply.findMaxMultiply(arr);
        assertEquals(Integer.MAX_VALUE, result[0]);
        assertEquals(Integer.MAX_VALUE, result[1]);
    }

    @Test
    void findMaxMultiply5() {
        List<Integer> arr = List.of(1, 1);

        final int[] result = Multiply.findMaxMultiply(arr);
        assertEquals(1, result[0]);
        assertEquals(1, result[1]);
    }

    @Test
    void findMaxMultiply6() {
        List<Integer> arr = List.of(0, 1);

        final int[] result = Multiply.findMaxMultiply(arr);
        assertEquals(0, result[0]);
        assertEquals(1, result[1]);
    }

    @Test
    void findMaxMultiply7() {
        List<Integer> arr = List.of(0, 0);

        final int[] result = Multiply.findMaxMultiply(arr);
        assertEquals(0, result[0]);
        assertEquals(0, result[1]);
    }

    @Test
    void findMaxMultiply8() {
        List<Integer> arr = List.of(-1, 0, 1);

        final int[] result = Multiply.findMaxMultiply(arr);
        assertEquals(0, result[0]);
        assertEquals(1, result[1]);
    }

    @Test
    void findMaxMultiply9() {
        List<Integer> arr = List.of(3, 5, -7, -9, -2);

        final int[] result = Multiply.findMaxMultiply(arr);
        assertEquals(-9, result[0]);
        assertEquals(-7, result[1]);
    }
}