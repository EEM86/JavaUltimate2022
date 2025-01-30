package yym.svydovets.algorithm.task.csosvita.graphs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IslandTaskTest {

    @Test
    void findIslands1() {
        int[][] grid = new int[][]{
            {1,1,1,1,0},
            {1,1,0,1,0},
            {1,1,0,0,0},
            {0,0,0,0,0},
        };
        final int result = IslandTask.findIslands(grid);
        assertEquals(1, result);
    }

    @Test
    void findIslands2() {
        int[][] grid = new int[][]{
            {1,1,0,0,0},
            {1,1,0,0,0},
            {0,0,1,0,0},
            {0,0,0,1,1},
        };
        final int result = IslandTask.findIslands(grid);
        assertEquals(3, result);
    }
}