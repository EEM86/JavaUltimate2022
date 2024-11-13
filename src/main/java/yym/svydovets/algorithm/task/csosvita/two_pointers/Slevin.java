package yym.svydovets.algorithm.task.csosvita.two_pointers;

import java.util.Scanner;

public class Slevin {

    /*
     * There are N cars. How many sets of cars are there in a row at locations L to R such that
     * the sum of their numbers is K?
     * 1 <= N <= 100_000
     * 1 <= K <= 10^9
     *
     * Example: if N = 5, K = 17, cars are [17, 7, 10, 7, 10] - there are 4 sets:
     * 17 (l=1, r=1); 7,10 (l=2, r=3); 10, 7(l=3, r=4); 7,10(l=4, r=5)
     */
    public static int luckySlevinNumbers(int[] arr, int k) {
        int luckySum = 0;
        int curSum = 0;
        int l = 0, r = 0;

        while (r < arr.length) {
            curSum += arr[r];

            while (curSum > k) {
                curSum -= arr[l++];
            }
            if (curSum == k) {
                luckySum++;
            }
            r++;
        }

        return luckySum;
    }

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int k = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        final int result = luckySlevinNumbers(arr, k);
        System.out.println(result);
    }

}
