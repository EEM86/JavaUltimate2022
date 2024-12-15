package yym.svydovets.algorithm.task.csosvita.data_structures;

import java.util.Arrays;
import java.util.Scanner;

public class Points {

    /*
     * Given n points on the a-xis, you need to cover them with k segments of equal length.
     * Find the minimum length l.
     *
     * A segment cover all the points within it, including the endpoints.
     * A segment of length 0 is the smallest, while one spanning
     * all points is the largest and guaranteed to cover them.
     *
     * 1 <= n <= 10^5
     * 1 <= k <= n
     * -10^9 <= arr[i] <= 10^9
     *
     * Example 0:
     * arr = [1,2,3,9,8,7], k = 2
     * output = 2
     *
     */
    public static long findMinLength(long[] arr, int k) {
        if (arr.length <= 1) return 0;
        Arrays.sort(arr);
        if (arr[arr.length - 1] == arr[0]) return 0;
        long bad = -1;
        long good = arr[arr.length-1] - arr[0];
        while (good - bad > 1) {
            long candidate = bad + (good - bad) / 2;
            if (isGood(candidate, arr, k)) {
                good = candidate;
            } else {
                bad = candidate;
            }
        }
        return good;
    }

    private static boolean isGood(long candidate, long[] arr, int k) {
        int segmentsUsed = 0;
        int i = 0;
        int n = arr.length;

        while (i < n) {
            segmentsUsed++;
            long segmentStart = arr[i];
            while (i < n && arr[i] <= segmentStart + candidate) {
                i++;
            }
            if (segmentsUsed > k) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        final long result = findMinLength(arr, k);
        System.out.println(result);
    }

}
