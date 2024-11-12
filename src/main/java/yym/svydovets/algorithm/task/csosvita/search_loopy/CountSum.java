package yym.svydovets.algorithm.task.csosvita.search_loopy;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class CountSum {

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

            // Update the map with the current prefix sum count
            prefixMap.put(prefixSum, prefixMap.getOrDefault(prefixSum, 0) + 1);
        }

        return res;
    }

    public static int countSumOptimal(int[] arr, int k) {
        int res = 0;

        int[] prefix = new int[arr.length+1];

        for (int i = 0; i < arr.length; i++) {
            prefix[i+1] = prefix[i] + arr[i];
        }

        for (int i = 1; i < prefix.length; i++) {
            if (prefix[i] == k) {
                res++;
            }
            if (prefix[i] > k && prefix[i] - arr[i - 1] == k) {
                res++;
            }
        }

        return res;
    }

    private static int rsq(int l, int[] prefix, int r) {
        final int result = prefix[r] - prefix[l];
        return result;
    }

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        final int result = countSumOptimal(arr, k);
        System.out.println(result);
    }

}
