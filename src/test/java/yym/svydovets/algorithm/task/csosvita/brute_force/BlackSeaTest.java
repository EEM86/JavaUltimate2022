package yym.svydovets.algorithm.task.csosvita.brute_force;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BlackSeaTest {

    @Test
    void blackSea() {
        int row = 2;
        int col = 2;
        int[] arr = new int[]{1,1,1,1};

        final String result = BlackSea.blackSea(row, col, arr);
        assertEquals("1,000000", result);
    }

    @Test
    void blackSea2() {
        int row = 2;
        int col = 3;
        int[] arr = new int[]{0,0,1,1,0,1};

        final String result = BlackSea.blackSea(row, col, arr);
        assertEquals("0,500000", result);
    }
}