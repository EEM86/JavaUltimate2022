package yym.svydovets.algorithm.task.b_search;

import java.util.Arrays;

public class CocoEatsBananas {

    /*
     * Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas.
     * The guards have gone and will come back in h hours.
     * Koko can decide her bananas-per-hour eating speed of k.
     * Each hour, she chooses some pile of bananas and eats k bananas from that pile.
     * If the pile has less than k bananas, she eats all of them instead
     * and will not eat any more bananas during this hour.
     *
     * Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
     * Return the minimum integer k such that she can eat all the bananas within h hours.
     *
     * 1 <= piles.length <= 104
     * piles.length <= h <= 109
     * 1 <= piles[i] <= 109

     * Example 1:
     * Input: piles = [3,6,7,11], h = 8
     * Output: 4
     */
    public static int minEatingSpeed(int[] piles, int h) {
        int bad = -1;
        int good = getMax(piles);
        while (good - bad > 1) {
            int candidate = bad + (good - bad) / 2;
            if (isGood(candidate, piles, h)) {
                good = candidate;
            } else {
                bad = candidate;
            }
        }
        return good;
    }

    private static boolean isGood(int n, int[] piles, int h) {
        int hoursGone = 0;
        for (int pile : piles) {
            hoursGone += Math.ceil((double) pile / n);
        }
        return hoursGone <= h;
    }

    private static int getMax(int[] piles) {
        return Arrays.stream(piles).max().orElse(0);
    }

}
