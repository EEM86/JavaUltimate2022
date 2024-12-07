package yym.svydovets.algorithm.task.csosvita.search_loopy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BuildingsTest {

    @Test
    void buildings() {
        int n = 5;
        final int result = Buildings.buildings(n);
        assertEquals(2, result);
    }

    @Test
    void buildings2() {
        int n = 8;
        final int result = Buildings.buildings(n);
        assertEquals(3, result);
    }

    @Test
    void buildings3() {
        int n = (int) Math.pow(2, 31) - 1;
        final int result = Buildings.buildings(n);
        assertEquals(2147483646, result);
    }
}