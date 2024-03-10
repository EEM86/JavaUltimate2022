package yym.svydovets.algorithm.task.geometry;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RotateImageTaskTest {

    private RotateImageTask service;

    @BeforeEach
    void setUp() {
        service = new RotateImageTask();
    }

    @Test
    void testRotate_v1() {
        int[][] matrix = new int[][]{{1,2,3}, {4,5,6}, {7,8,9}};

        service.rotate(matrix);

        assertEquals(7, matrix[0][0]);
        assertEquals(4, matrix[0][1]);
        assertEquals(1, matrix[0][2]);
        assertEquals(8, matrix[1][0]);
        assertEquals(5, matrix[1][1]);
        assertEquals(2, matrix[1][2]);
        assertEquals(9, matrix[2][0]);
        assertEquals(6, matrix[2][1]);
        assertEquals(3, matrix[2][2]);
    }

    @Test
    void testRotate_v2() {
        int[][] matrix = new int[][]{{5,1,9,11}, {2,4,8,10}, {13,3,6,7}, {15,14,12,16}};

        service.rotate(matrix);

        assertEquals(15, matrix[0][0]);
        assertEquals(13, matrix[0][1]);
        assertEquals(2, matrix[0][2]);
        assertEquals(5, matrix[0][3]);
        assertEquals(14, matrix[1][0]);
        assertEquals(3, matrix[1][1]);
        assertEquals(4, matrix[1][2]);
        assertEquals(1, matrix[1][3]);
        assertEquals(12, matrix[2][0]);
        assertEquals(6, matrix[2][1]);
        assertEquals(8, matrix[2][2]);
        assertEquals(9, matrix[2][3]);
        assertEquals(16, matrix[3][0]);
        assertEquals(7, matrix[3][1]);
        assertEquals(10, matrix[3][2]);
        assertEquals(11, matrix[3][3]);
    }
}
