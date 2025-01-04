package yym.svydovets.algorithm.task.csosvita.knapsack;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class ClosestElementsTest {

    @Test
    void getClosest() {
        int k = 4;
        int x = 3;
        int[] arr = new int[]{1,2,3,4,5};
        String res = ClosestElements.findClosestElements(k, arr, x);
        assertEquals("1 2 3 4", res);
    }

    @Test
    void getClosest2() {
        int k = 4;
        int x = -1;
        int[] arr = new int[]{1,2,3,4,5};
        String res = ClosestElements.findClosestElements(k, arr, x);
        assertEquals("1 2 3 4", res);
    }

    @Test
    void getClosest3() {
        int k = 4;
        int x = -1;
        int[] arr = new int[]{1,2,3,4,5};
        final String res = ClosestElements.findClosestElements(k, arr, x);
        assertEquals("1 2 3 4", res);
    }
}