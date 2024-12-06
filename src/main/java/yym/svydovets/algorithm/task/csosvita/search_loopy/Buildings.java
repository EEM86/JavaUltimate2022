package yym.svydovets.algorithm.task.csosvita.search_loopy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Buildings {

    /*
     * You are building ladders with blocks.
     * The i'th step in the ladder contains of i blocks.
     * The ladder with 10 blocks and 4 steps has such view:
     * []
     * [][]
     * [][][]
     * [][][][]
     *
     * You have a number of blocks n.
     * Find the max steps in a ladder that you can build.
     * 1 <= n <= 2^31 - 1
     *
     * Sample input 0:
     * 5
     * Sample Output 0:
     * 2
     * [] first step
     * [] [] second step
     * [] [] x - third step cannot be built because of lack of blocks
     */
    public static int buildings(int n) {
        int good = 0;
        int bad = n + 1;

        while (bad - good > 1) {
            int candidate = bad + (good - bad) / 2;
            if (isGood(candidate, n)) {
                good = candidate;
            } else {
                bad = candidate;
            }
        }
        return good;
    }

    private static boolean isGood(int k, int n) {
        return (k * (k + 1) / 2) <= n;
    }

    public static int buildingsMath(int n) {
        int k = (int) ((Math.sqrt(1 + 8L * n) - 1) / 2);
        if ((long) k * (k + 1) / 2 > n) {
            k--;
        }
        return k;
    }

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();

        final long result = buildings(n);
        System.out.println(result);
    }

}
