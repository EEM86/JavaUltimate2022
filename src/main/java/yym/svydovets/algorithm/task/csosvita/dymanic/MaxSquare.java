package yym.svydovets.algorithm.task.csosvita.dymanic;

import java.util.Scanner;

public class MaxSquare {

    /*
     * Field is colored in black and white colors.
     * Find the square of the maximum size.
     *
     * 1 <= rows <= 500
     * 1 <= cols <= 500
     *
     * Sample Input:
     * ###
     * #.#
     * ###
     * Sample Output:
     * 1 // the square must be fully colored
     */
    public static int getMaxSquare(String[][] grid) {
        int rows = grid.length;
        int cols = grid[0].length;

        int[][] dp = new int[rows+1][cols+1];
        int maxAmount = 0;

        for (int i = 1; i <= rows; i++) {
            for (int j = 1; j <= cols; j++) {
                if ("#".equals(grid[i-1][j-1])) {
                    dp[i][j] = Math.min(Math.min(dp[i-1][j], dp[i][j-1]), dp[i-1][j-1]) + 1;
                    maxAmount = Math.max(maxAmount, dp[i][j]);
                }
            }
        }
        return maxAmount;
    }

}
