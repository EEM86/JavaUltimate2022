package yym.svydovets.algorithm.task.csosvita.dymanic;

import java.util.Arrays;

public class PerfectSquaresTask {

    /*
     * Given an integer n, return the least number of perfect square numbers that sum to n.
     * A perfect square is an integer that is the square of an integer; in other words,
     * it is the product of some integer with itself.
     * For example, 1, 4, 9, and 16 are perfect squares while 3 and 11 are not.
     *
     * 1 <= n <= 10^4
     *
     * Sample input: 12
     * Sample Output: 3 // 12 = 4 + 4 + 4
     */
    public static int getLeastNum(int n) {
        int[] dp = new int[n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                dp[i] = Math.min(dp[i], dp[i - j*j] + 1);
            }
        }
        return dp[n] == Integer.MAX_VALUE ? -1 : dp[n];
    }

}
