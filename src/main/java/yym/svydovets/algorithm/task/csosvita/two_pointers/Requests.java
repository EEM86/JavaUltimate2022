package yym.svydovets.algorithm.task.csosvita.two_pointers;

import java.util.Scanner;

public class Requests {

    /*
     * Analyze the logs that contain a sequence of 0 and 1 as a result of request's calculation.
     * You must identify and return the length of the longest subarray of 1.
     * 1 <= n <= 1000000
     * Input 0: 6, 110111
     * Output 0: 3
     * Input 1: 6, 101101
     * Output 1: 2
     */
    static int longestSeq(int[] arr, int n) {
        int l = 0, r = 0;
        int max = 0;

        while (r < n) {
            if (arr[r] == 1) {
                max = Math.max(max, r - l + 1);
            } else {
                l = r+1;
            }
            r++;
        }
        return max;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        int i = 0;
        while (sc.hasNext()) {
            arr[i] = sc.nextInt();
            i++;
        }

        final int res = longestSeq(arr, n);
        System.out.println(res);
    }

}
