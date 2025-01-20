package yym.svydovets.algorithm.task.csosvita.dymanic;

import java.util.Arrays;

public class PlayGameTask {


    /*
     * You have two arrays, player and computer. If the value in the player[i] <= computer[i],
     * the player loses this value (unit). The player knows computer's array values before start.
     *
     * Example:
     * computer array = [5,15,100,1,5]
     * player array = [5,15,100,1,5]
     * Player can put his values in a way that maximum result will be 120 (100+15+5)
     */
    public static int getMaxVinDp(int[] player, int[] computer) {
        Arrays.sort(player);
        Arrays.sort(computer);

        int n = player.length;
        int m = computer.length;

        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                if (player[i - 1] > computer[j - 1]) {
                    dp[i][j] = Math.max(dp[i][j], dp[i - 1][j - 1] + player[i - 1]);
                }
            }
        }

        return dp[n][m];
    }

    public static int getMaxWin(int[] player, int[] computer) {
        Arrays.sort(player);
        Arrays.sort(computer);
        int playerIdx = player.length - 1;
        int computerIdx = computer.length - 1;
        int maxValue = 0;

        while (playerIdx >= 0 && computerIdx >= 0) {
            if (player[playerIdx] > computer[computerIdx]) {
                // Player wins this round
                maxValue += player[playerIdx];
                computerIdx--; // Move to the next largest computer value
            }
            // Move to the next largest player value regardless
            playerIdx--;
        }
        return maxValue;
    }

}
