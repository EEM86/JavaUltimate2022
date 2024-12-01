package yym.svydovets.algorithm.task.csosvita.heapify;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CubeTest {

    @Test
    void findCube() {
        final String result = Cube.findCube(3);
        assertEquals("41063625", result);
    }

    @Test
    void findCube2() {
        final String result = Cube.findCube(5);
        assertEquals("127035954683", result);
    }

    @Test
    void sort() {
        final String result = Cube.sortDigits(11390625);
        assertEquals("96532110", result);
    }
}