package yym.svydovets.algorithm.task.matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumsOfIslandsTest {

  @Test
  void testNumIslands_v1() {
    var grid = new char[][]{
        {'1','1','1','1','0'},
        {'1','1','0','1','0'},
        {'1','1','0','0','0'},
        {'0','0','0','0','0'}
    };
    int expected = 1;

    int actual = NumsOfIslands.numIslands(grid);

    assertEquals(expected, actual);
  }

  @Test
  void testNumIslands_v2() {
    var grid = new char[][]{
        {'1','1','0','0','0'},
        {'1','1','0','0','0'},
        {'0','0','1','0','0'},
        {'0','0','0','1','1'}
    };
    int expected = 3;

    int actual = NumsOfIslands.numIslands(grid);

    assertEquals(expected, actual);
  }

}