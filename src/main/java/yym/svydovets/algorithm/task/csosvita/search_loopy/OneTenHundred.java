package yym.svydovets.algorithm.task.csosvita.search_loopy;

import java.util.Arrays;
import java.util.Scanner;

public class OneTenHundred {

    /*
     * Let's consider an infinite sequence of digits constructed of ascending powers
     * of 10 written one after another. Here is the beginning of the sequence: 110100100010000...
     * You are to find out what digit is located at the definite position of the sequence.
     *
     * Input format integer N in the first line. The i-th left lines contains the int K_i - the position in sequence.
     *
     * 1 <= N <= 65535
     * 1 <= K_i <= 2^{31}-1
     *
     * Output format N digits 0 or 1 separated with a space.
     * Sample Input 0:
     * 4
     * 3
     * 14
     * 7
     * 6
     * Sample Output 0:
     * 0 0 1 0
     */
    public static String findNumbers(int[] arr) {
        var sb = new StringBuilder();
        long[] ones_pos = new long[65537];
        for (int i = 0; i < ones_pos.length; i++) {
            // use this formula inside binary search to avoid aux memory
            ones_pos[i] = (long) i * (i + 1) / 2 + 1;
        }
        for (int cur : arr) {
            int cand = Arrays.binarySearch(ones_pos, cur);
            String res = cand > -1 ? "1" : "0";
            sb.append(res).append(" ");
        }
        if (!sb.isEmpty()) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        final String result = findNumbers(arr);
        System.out.println(result);
    }

}
