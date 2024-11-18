package yym.svydovets.algorithm.task.csosvita.two_pointers;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;

class NullsTest {

    @Test
    void nulls() {
        int[] arr = new int[]{0,1,2,0,3,0,4,0};
        List<int[]> requests = new ArrayList<>();
        requests.add(new int[]{0,8});
        requests.add(new int[]{2,6});
        requests.add(new int[]{4,8});
        final String result = Nulls.nulls(arr, requests);
        assertEquals("4\n2\n2", result);
    }

    @Test
    void nulls1() {
        int[] arr = new int[]{1,0,5,0,4,2,0,0};
        List<int[]> requests = new ArrayList<>();
        requests.add(new int[]{1,8});
        requests.add(new int[]{0,4});
        requests.add(new int[]{2,7});
        requests.add(new int[]{0,7});
        final String result = Nulls.nulls(arr, requests);
        assertEquals("4\n2\n2\n3", result);
    }

    @Test
    void nulls2() {
        int[] arr = new int[]{3,2,1};
        List<int[]> requests = new ArrayList<>();
        requests.add(new int[]{0,3});
        final String result = Nulls.nulls(arr, requests);
        assertEquals("0", result);
    }
}