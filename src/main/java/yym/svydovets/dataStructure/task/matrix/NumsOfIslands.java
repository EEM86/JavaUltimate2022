package yym.svydovets.dataStructure.task.matrix;

import java.util.ArrayDeque;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;

import org.apache.commons.lang3.NotImplementedException;

public class NumsOfIslands {

  public static void main(String[] args) {
    var grid = new char[][]{
        {'1','1','1','1','0'},
        {'1','1','0','1','0'},
        {'1','1','0','0','0'},
        {'0','0','0','0','0'}
    };

    System.out.println(numIslands(grid));
  }

  /*
  Given an m x n 2D binary grid which represents a map of '1's (land) and '0's (water), return the number of islands.
  An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
  You may assume all four edges of the grid are all surrounded by water.
  Example 1:
  Input: grid = [
    {'1','1','1','1','0'},
    {'1','1','0','1','0'},
    {'1','1','0','0','0'},
    {'0','0','0','0','0'}
  ]
  Output: 1
  +++++++++++++++++++++++++++++++++++++
  Example 2:
  Input: grid = [
    {'1','1','0','0','0'},
    {'1','1','0','0','0'},
    {'0','0','1','0','0'},
    {'0','0','0','1','1'}
  ]
  Output: 3
   */
  static int numIslands(char[][] grid) {
    throw new NotImplementedException();
  }

}
