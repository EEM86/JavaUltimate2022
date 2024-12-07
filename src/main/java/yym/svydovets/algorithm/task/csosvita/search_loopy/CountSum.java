package yym.svydovets.algorithm.task.csosvita.search_loopy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountSum {

    /*
     * Given an array of integers and an integer n,
     * return the total number of subarrays whose sum equals to k.
     * A subarray is a contiguous non-empty sequence of elements within an array.
     *
     * The first input line has an integer n - the size of the array and an integer k.
     * The next line has n integers: the contents of the array.
     *
     * 1 <= n <= 2*10^5
     * -10^9 <= a_i <= 10^9
     * -10^7 <= k <= 10^7
     *
     * Sample Input 0:
     * 3 3
     * 1 2 3
     * Sample Output 0:
     * 2
     */
    public static int countSum(int[] arr, int k) {
        int res = 0;
        int prefixSum = 0;
        Map<Integer, Integer> prefixMap = new HashMap<>();
        prefixMap.put(0, 1);  // Base case to handle subarrays starting at index 0

        for (int r = 0; r < arr.length; r++) {
            prefixSum += arr[r];

            // Check if there's a previous prefix sum that makes prefixSum - previous = k
            if (prefixMap.containsKey(prefixSum - k)) {
                res += prefixMap.get(prefixSum - k);
            }

            if (prefixMap.containsKey(prefixSum)) {
                prefixMap.put(prefixSum, prefixMap.get(prefixSum) + 1);
            } else {
                prefixMap.put(prefixSum, 1);
            }
        }

        return res;
    }

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        final int result = countSum(arr, k);
        System.out.println(result);
    }

}
