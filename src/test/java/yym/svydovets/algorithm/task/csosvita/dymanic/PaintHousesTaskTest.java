package yym.svydovets.algorithm.task.csosvita.dymanic;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class PaintHousesTaskTest {

    @Test
    void paint1() {
        int[][] cost = new int[][]{
            {1, 100, 100},
            {100, 1, 100},
            {100, 100, 1}
        };
        final int result = PaintHousesTask.paint(cost);
        assertEquals(3, result);
    }

    @Test
    void paint2() {
        int[][] cost = new int[][]{
            {1, 100, 100},
            {100, 100, 100},
            {100, 100, 1}
        };
        final int result = PaintHousesTask.paint(cost);
        assertEquals(102, result);
    }

    @Test
    void paint3() {
        int[][] cost = new int[][]{
            {26, 40, 83},
            {49, 60, 57},
            {13, 89, 99}
        };
        final int result = PaintHousesTask.paint(cost);
        assertEquals(96, result);
    }

    @Test
    void paint4() {
        int[][] cost = new int[][]{
            {30, 19, 5},
            {64, 77, 64},
            {15, 19, 97},
            {4, 71, 57},
            {90, 86, 84},
            {93, 32, 91}
        };
        final int result = PaintHousesTask.paint(cost);
        assertEquals(208, result);
    }

    @Test
    void paint5() {
        int[][] cost = new int[][]{
            {71, 39, 44},
            {32, 83, 55},
            {51, 37, 63},
            {89, 29, 100},
            {83, 58, 11},
            {65, 13, 15},
            {47, 25, 29},
            {60, 66, 19}
        };
        final int result = PaintHousesTask.paint(cost);
        assertEquals(253, result);
    }
}