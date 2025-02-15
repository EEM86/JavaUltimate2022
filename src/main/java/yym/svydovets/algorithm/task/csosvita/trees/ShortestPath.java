package yym.svydovets.algorithm.task.csosvita.trees;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

/*
 * You are given an m x n integer matrix grid where each cell is either 0 (empty) or 1 (obstacle).
 * You can move up, down, left, or right from and to an empty cell in one step.
 *
 * You start at the upper left corner (0, 0) and want to reach the lower right corner (m - 1, n - 1).
 * You are allowed to eliminate at most k obstacles on the way.
 *
 * Your task is to return the minimum number of steps required to reach the destination.
 * If it is not possible to reach the destination, return -1.
 *
 * 1 <= m, n <= 40
 * grid[i][j] is either 0 or 1.
 * 0 <= k <= m * n
 * grid[0][0] == grid[m - 1][n - 1] == 0
 */
public class ShortestPath {

    public static class GridSolution {

        int[] xAxis = new int[]{0,1,0,-1};
        int[] yAxis = new int[]{1,0,-1,0};

        public int shortestPath(int[][] grid, int k) {
            int rows = grid.length;
            int cols = grid[0].length;
            StepsCounterForObstacles[][] dp = init(rows, cols, k);

            Queue<State> queue = new LinkedList<>();
            queue.offer(new State(0, 0, 0, k));
            dp[0][0].stepsForObstacles.set(k, 0);

            while (!queue.isEmpty()) {
                State cur = queue.poll();

                if (cur.x == rows - 1 && cur.y == cols - 1) {
                    return cur.steps;
                }

                for (int i = 0; i < xAxis.length; i++) {
                    int curX = cur.x + xAxis[i];
                    int curY = cur.y + yAxis[i];

                    if (curX < 0 || curY < 0 || curX >= rows || curY >= cols) {
                        continue;
                    }

                    int stepsForObstacles = cur.obstaclesAmount - grid[curX][curY];
                    int actualStep = cur.steps + 1;

                    if (stepsForObstacles >= 0 && actualStep < dp[curX][curY].stepsForObstacles.get(stepsForObstacles)) {
                        dp[curX][curY].stepsForObstacles.set(stepsForObstacles, actualStep);
                        queue.offer(new State(curX, curY, actualStep, stepsForObstacles));
                    }
                }
            }
            return -1;
        }

        private StepsCounterForObstacles[][] init(int rows, int cols, int k) {
            StepsCounterForObstacles[][] stepsCounter = new StepsCounterForObstacles[rows][cols];
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < cols; j++) {
                    stepsCounter[i][j] = new StepsCounterForObstacles(k);
                }
            }
            return stepsCounter;
        }

        static class StepsCounterForObstacles {
            public List<Integer> stepsForObstacles = new ArrayList<>();

            public StepsCounterForObstacles() {
            }

            public StepsCounterForObstacles(int obstaclesAmount) {
                stepsForObstacles = new ArrayList<>(obstaclesAmount + 1);
                for (int i = 0; i <= obstaclesAmount; i++) {
                    stepsForObstacles.add(Integer.MAX_VALUE);
                }
            }

        }

        static class State {
            int x;
            int y;
            int steps;
            int obstaclesAmount;

            State(int x, int y, int steps, int obstaclesAmount) {
                this.x = x;
                this.y = y;
                this.steps = steps;
                this.obstaclesAmount = obstaclesAmount;
            }
        }
    }

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] grid = new int[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                grid[i][j] = sc.nextInt();
            }
        }
        int k = sc.nextInt();
        var service = new GridSolution();
        final int result = service.shortestPath(grid, k);
        System.out.println(result);
    }
}
