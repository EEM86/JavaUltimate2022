package yym.svydovets.algorithm.task.csosvita.heapify;

import java.util.Arrays;
import java.util.Scanner;

public class ThreeSumClosest {

    /*
     * Given an array of length n and an integer target.
     * Find 3 integers in the array such the sum is closest to target.
     * Return the sum of the 3 integers closest to target.
     * You may assume that each input would have exactly one solution.
     *
     * 3 <= n <= 100_000
     * -1000 <= nums[i] <= 100_000
     * -10^4 <= target <= 10^4
     *
     * Sample Input 0:
     * -1 2 1 -4
     * 1
     * Sample Output 0:
     * 2
     */
    public static int closest3Sum(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        int closest = Integer.MAX_VALUE;
        for (int i = 0; i < n - 2; i++) {
            int cur = arr[i];
            int l = i+1, r = n-1;
            while (l < r) {
                int sum = cur + arr[l] + arr[r];
                if (isGood(closest, sum, target)) {
                    closest = sum;
                }
                if (sum < target) {
                    l++;
                } else if (sum > target) {
                    r--;
                } else {
                    return sum;
                }
            }
        }
        return closest;
    }

    private static boolean isGood(int closest, int sum, int target) {
        int sumDiff = Math.abs(target - sum);
        int closestDiff = Math.abs(target - closest);

        return sumDiff < closestDiff;
    }

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        String line = sc.nextLine();
        int target = sc.nextInt();
        final String[] numbers = line.split(" ");
        int[] arr = new int[numbers.length];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(numbers[i]);
        }
        final int result = closest3Sum(arr, target);
        System.out.println(result);
    }

}
