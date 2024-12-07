package yym.svydovets.algorithm.task.csosvita.search_loopy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GarlandTest {

    @Test
    void findLastLampTest1() {
        int n = 8;
        double a = 15;

        final double result = Garland.binarySearchLampHeight(n, a);
        assertEquals(9.75, result, 0.001);
    }

    @Test
    void findLastLampTest2() {
        int n = 692;
        double a = 532.81;

        final double result = Garland.binarySearchLampHeight(n, a);
        assertEquals(446113.344348, result, 0.001);
    }
}