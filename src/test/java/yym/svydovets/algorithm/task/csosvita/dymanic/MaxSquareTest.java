package yym.svydovets.algorithm.task.csosvita.dymanic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MaxSquareTest {

    @Test
    void getMaxSquare() {
        String[][] grid = new String[][]{
            {"#","#"},
            {"#", "."},
            {".","#"}
        };

        final int result = MaxSquare.getMaxSquare(grid);
        assertEquals(1, result);
    }

    @Test
    void getMaxSquare2() {
        String[][] grid = new String[][]{
            {"#","#", "#"},
            {"#", "#", "."}
        };

        final int result = MaxSquare.getMaxSquare(grid);
        assertEquals(2, result);
    }

    @Test
    void getMaxSquare3() {
        String[][] grid = new String[][]{
            {"#","#", "#"},
            {"#", ".", "#"},
            {"#", "#", "#"}
        };

        final int result = MaxSquare.getMaxSquare(grid);
        assertEquals(1, result);
    }

    @Test
    void getMaxSquare4() {
        String[][] grid = new String[][]{
            {"1","1"},
            {".", " "}
        };

        final int result = MaxSquare.getMaxSquare(grid);
        assertEquals(0, result);
    }

    @Test
    void getMaxSquare5() {
        String[][] grid = new String[][]{
            {"#","#", "#"},
            {"#", "#", "#"},
            {"#", "#", "#"}
        };

        final int result = MaxSquare.getMaxSquare(grid);
        assertEquals(3, result);
    }

    @Test
    void getMaxSquare6() {
        String[][] grid = new String[][]{
            {"#",".", "#"},
            {"#", "#", "#"},
            {"#", "#", "#"}
        };

        final int result = MaxSquare.getMaxSquare(grid);
        assertEquals(2, result);
    }
}