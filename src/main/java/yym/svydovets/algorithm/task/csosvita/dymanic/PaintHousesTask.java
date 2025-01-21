package yym.svydovets.algorithm.task.csosvita.dymanic;

public class PaintHousesTask {

    /*
     * You have 3 colors: R, G and B. You need to paint houses.
     * Two neighbors must not be the same color.
     * First and last houses are not neighbors.
     * We have a cost for painting and need to find the minimum cost to finish the work.
     * Example for 3 houses:
     * 1 100 100
     * 100 1 100
     * 100 100 1
     * Expected result: 3, because R,G,B is the smallest price.
     */
    public static int paint(int[][] cost) {
        int n = cost.length;
        int[][] dp = new int[n][3];

        dp[0][0] = cost[0][0];
        dp[0][1] = cost[0][1];
        dp[0][2] = cost[0][2];

        for (int i = 1; i < n; i++) {
            dp[i][0] = Math.min(dp[i-1][1], dp[i-1][2]) + cost[i][0];
            dp[i][1] = Math.min(dp[i-1][0], dp[i-1][2]) + cost[i][1];
            dp[i][2] = Math.min(dp[i-1][1], dp[i-1][0]) + cost[i][2];
        }

        return Math.min(dp[n-1][0], Math.min(dp[n-1][1], dp[n-1][2]));
    }

}
