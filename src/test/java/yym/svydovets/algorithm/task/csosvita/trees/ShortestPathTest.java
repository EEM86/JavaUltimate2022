package yym.svydovets.algorithm.task.csosvita.trees;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import yym.svydovets.algorithm.task.csosvita.trees.ShortestPath.GridSolution;

class ShortestPathTest {

    @Test
    void testFindShortestPath1() {
        int[][] grid = new int[][]{
            {0,1,0,0,0},
            {0,0,0,1,0},
            {1,1,1,1,0},
            {1,1,1,1,0}
        };
        var service = new GridSolution();
        final int result = service.shortestPath(grid, 1);
        System.out.println("Final result: " + result);
        assertEquals(7, result);
    }

    @Test
    void testFindShortestPath2() {
        int[][] grid = new int[][]{
            {0,1,1},
            {0,1,1},
            {0,1,0}
        };
        var service = new GridSolution();
        final int result = service.shortestPath(grid, 1);
        System.out.println("Final result: " + result);
        assertEquals(4, result);
    }

    @Test
    void testFindShortestPath3() {
        int[][] grid = new int[][]{
            {0,1,1},
            {0,1,0}
        };
        var service = new GridSolution();
        final int result = service.shortestPath(grid, 1);
        System.out.println("Final result: " + result);
        assertEquals(3, result);
    }

    @Test
    void testFindShortestPath4() {
        int[][] grid = new int[][]{
            {0,1,1,1,0},
            {0,1,1,0,0}
        };
        var service = new GridSolution();
        final int result = service.shortestPath(grid, 2);
        System.out.println("Final result: " + result);
        assertEquals(5, result);
    }

    @Test
    void testFindShortestPath5() {
        int[][] grid = new int[][]{
            {0,0,0},
            {1,1,0},
            {0,0,0},
            {0,1,1},
            {0,0,0}
        };
        var service = new GridSolution();
        final int result = service.shortestPath(grid, 1);
        System.out.println("Final result: " + result);
        assertEquals(6, result);
    }

    @Test
    void testFindShortestPath6() {
        int[][] grid = new int[][]{
            {0,1,1},
            {1,1,1},
            {1,0,0}
        };
        var service = new GridSolution();
        final int result = service.shortestPath(grid, 1);
        System.out.println("Final result: " + result);
        assertEquals(-1, result);
    }

    @Test
    void testFindShortestPath7() {
        int[][] grid = new int[][]{
            {0,0,0,0,0,0,0,0,0,0},
            {0,1,1,1,1,1,1,1,1,0},
            {0,1,0,0,0,0,0,0,0,0},
            {0,1,0,1,1,1,1,1,1,1},
            {0,1,0,0,0,0,0,0,0,0},
            {0,1,1,1,1,1,1,1,1,0},
            {0,1,0,0,0,0,0,0,0,0},
            {0,1,0,1,1,1,1,1,1,1},
            {0,1,0,1,1,1,1,0,0,0},
            {0,1,0,0,0,0,0,0,1,0},
            {0,1,1,1,1,1,1,0,1,0},
            {0,0,0,0,0,0,0,0,1,0}
        };
        var service = new GridSolution();
        final int result = service.shortestPath(grid, 1);
        System.out.println("Final result: " + result);
        assertEquals(20, result);
    }

    @Test
    void testFindShortestPath8() {
        int[][] grid = new int[][]{
            {0,0},
            {1,0},
            {1,0},
            {1,0},
            {1,0},
            {1,0},
            {0,0},
            {0,1},
            {0,1},
            {0,1},
            {0,0},
            {1,0},
            {1,0},
            {0,0}
        };
        var service = new GridSolution();
        final int result = service.shortestPath(grid, 4);
        System.out.println("Final result: " + result);
        assertEquals(14, result);
    }

}