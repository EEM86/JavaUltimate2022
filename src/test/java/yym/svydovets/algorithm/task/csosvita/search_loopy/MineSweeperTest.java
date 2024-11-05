package yym.svydovets.algorithm.task.csosvita.search_loopy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MineSweeperTest {

    @Test
    void printMineFieldChar() {
        char[][] arr = new char[][]{
            {'0', '0', '*', '0'},
            {'*', '0', '0', '0'},
            {'0', '0', '0', '0'},
            {'0', '*', '0', '*'}
        };
        final String result = MineSweeper.printMineFieldChar(arr);
        System.out.println(result);
    }

    @Test
    void printMineField() {
        int[][] arr = new int[][]{
            {0, 0, -10, 0},
            {-10, 0, 0, 0},
            {0, 0, 0, 0},
            {0, -10, 0, -10}
        };
        final String result = MineSweeper.printMineField(arr);
        System.out.println(result);
    }

    @Test
    void printMineField2() {
        String expected = """
            * 2 1 1 0
            1 2 * 1 0
            0 1 2 2 1
            0 0 1 * 1""";
        int[][] arr = new int[][]{
            {-10, 0, 0, 0, 0},
            {0, 0, -10, 0, 0},
            {0, 0, 0, 0, 0},
            {0, 0, 0, -10, 0}
        };
        final String result = MineSweeper.printMineField(arr);
        assertEquals(expected, result);
    }
}