package yym.svydovets.algorithm.task.csosvita.knapsack;

public class KnapsackTask {

    /*
     * Given an array of n items, each with a known weight w_i and cost c_i,
     * you need to select a segment of this array that
     * the total weight does not exceed s and the total cost is maximized.
     *
     * 1 <= n <= 100_000
     * 1 <= s <= 100_000_000
     * 1 <= w_i <= 1000_000_000
     * 1 <= c_i <= 1000_000_000
     *
     * Sample Input 0:
     * 6 20
     * 9 7 6 5 8 4
     * 7 1 3 6 8 3
     */
    public static long getMax(int[] weight, int s, int[] cost) {
        long max = 0;
        int l = 0;
        long curWeight = 0;

        long curMax = 0;
        for (int r = 0; r < cost.length; r++) {
            curMax += cost[r];
            curWeight += weight[r];
            while (curWeight > s) {
                curMax -= cost[l];
                curWeight -= weight[l];
                l++;
            }
            max = Math.max(max, curMax);
        }
        return max;
    }

}
