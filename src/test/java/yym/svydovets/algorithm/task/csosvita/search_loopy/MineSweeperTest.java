package yym.svydovets.algorithm.task.csosvita.search_loopy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MineSweeperTest {

    @Test
    void printMineField() {
        String[][] board = new String[][]{
            {"0", "0", "*", "0"},
            {"*", "0", "0", "0"},
            {"0", "0", "0", "0"},
            {"0", "*", "0", "*"},
        };
        String expected = """
            1 2 * 1
            * 2 1 1
            2 2 2 1
            1 * 2 *""";

        final String[][] resultBoard = MineSweeper.generateBoard(board);
        final String result = MineSweeper.boardToString(resultBoard);
        assertEquals(expected, result);
    }

    @Test
    void printMineField2() {
        String[][] board = new String[][]{
            {"*", "0", "0", "0", "0"},
            {"0", "0", "*", "0", "0"},
            {"0", "0", "0", "0", "0"},
            {"0", "0", "0", "*", "0"},
        };
        String expected = """
            * 2 1 1 0
            1 2 * 1 0
            0 1 2 2 1
            0 0 1 * 1""";

        final String[][] resultBoard = MineSweeper.generateBoard(board);
        final String result = MineSweeper.boardToString(resultBoard);
        assertEquals(expected, result);
    }
}