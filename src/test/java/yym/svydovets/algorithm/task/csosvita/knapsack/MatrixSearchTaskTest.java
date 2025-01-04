package yym.svydovets.algorithm.task.csosvita.knapsack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MatrixSearchTaskTest {

    @Test
    void findTarget() {
        int[][] matrix = new int[][]
            {{1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}};
        final int result = MatrixSearchTask.findTarget(matrix, 3);
        assertEquals(1, result);
    }

    @Test
    void findTarget2() {
        int[][] matrix = new int[][]
            {{1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}};
        final int result = MatrixSearchTask.findTarget(matrix, 13);
        assertEquals(0, result);
    }

    @Test
    void findTarget3() {
        int[][] matrix = new int[][]
            {{1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}};
        final int result = MatrixSearchTask.findTarget(matrix, 1);
        assertEquals(1, result);
    }

    @Test
    void findTarget4() {
        int[][] matrix = new int[][]
            {{1,3,5,7},
                {23,30,34,60}};
        final int result = MatrixSearchTask.findTarget(matrix, 60);
        assertEquals(1, result);
    }

    @Test
    void findTarget5() {
        int[][] matrix = new int[0][0];
        final int result = MatrixSearchTask.findTarget(matrix, 60);
        assertEquals(0, result);
    }

    @Test
    void findTarget6() {
        int[][] matrix = new int[][]
            {{-1,3,5,7},
                {10,11,16,20},
                {23,30,34,60}};
        final int result = MatrixSearchTask.findTarget(matrix, -1);
        assertEquals(1, result);
    }

    @Test
    void findTarget7() {
        int[][] matrix = new int[][]
            {{-7,-5,-3,-1},
                {10,11,16,20},
                {23,30,34,60}};
        final int result = MatrixSearchTask.findTarget(matrix, -1);
        assertEquals(1, result);
    }

    @Test
    void findTarget8() {
        int[][] matrix = new int[][]
            {{-7,-5,-3,-1},
                {10,11,16,20},
                {23,30,34,60}};
        final int result = MatrixSearchTask.findTarget(matrix, -2);
        assertEquals(0, result);
    }

    @Test
    void findTarget9() {
        int[][] matrix = new int[][]
            {{-17,-15,-13,-11},
                {-10,-9,-6,-2},
                {23,30,34,60}};
        final int result = MatrixSearchTask.findTarget(matrix, -6);
        assertEquals(1, result);
    }
}