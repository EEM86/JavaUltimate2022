package yym.svydovets.algorithm.task.csosvita.heapify;

import java.util.Arrays;
import java.util.Scanner;

public class Candies {

    /*
     * There is n cups with a[i] candies. Good box is when there is no 3 different cups with candies.
     * You can add any candies to any of cups.
     * What the minimum amount of candies you should add to have the good box?
     *
     * Sample Input 0:
     * 4
     * 5 1 2 7
     * Sample Output 0:
     * 3  - you can add 2 candies to the first cup and 1 candy to the second = [7,2,2,7]
     */
    public static long findMinIncrements(long[] arr) {
        if (arr.length < 3) {
            return 0;
        }
        Arrays.sort(arr);
        int n = arr.length;

        long minIncrements = Long.MAX_VALUE;

        for (int i = 0; i < n - 1; i++) {
            long left = arr[i];
            long right = arr[n - 1];

            long leftCost = 0;
            long rightCost = 0;

            for (int j = 0; j <= i; j++) {
                leftCost += (left - arr[j]);
            }

            for (int j = i + 1; j < n; j++) {
                rightCost += (right - arr[j]);
            }

            minIncrements = Math.min(minIncrements, leftCost + rightCost);
        }

        return minIncrements;
    }

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        final long result = findMinIncrements(arr);
        System.out.println(result);
    }
}
