package yym.svydovets.algorithm.task.csosvita.data_structures;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Scanner;

public class GoodSubarrayCounter {
    // todo this solution was written with GPT help and passed all tests.
    // Create stress test for the solution in Segments
    // don't forget to debug this solution
    public static long countGoodSubarrays(long[] arr, long k) {
        int n = arr.length;
        int left = 0;
        long count = 0;

        // Deques to maintain indices of max and min elements in the window
        Deque<Integer> maxDeque = new LinkedList<>();
        Deque<Integer> minDeque = new LinkedList<>();

        for (int right = 0; right < n; right++) {
            // Maintain the max deque
            while (!maxDeque.isEmpty() && arr[maxDeque.peekLast()] <= arr[right]) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(right);

            // Maintain the min deque
            while (!minDeque.isEmpty() && arr[minDeque.peekLast()] >= arr[right]) {
                minDeque.pollLast();
            }
            minDeque.addLast(right);

            // Check if the current window is valid
            while (arr[maxDeque.peekFirst()] - arr[minDeque.peekFirst()] > k) {
                left++;
                // Remove elements that are out of the current window
                if (maxDeque.peekFirst() < left) {
                    maxDeque.pollFirst();
                }
                if (minDeque.peekFirst() < left) {
                    minDeque.pollFirst();
                }
            }

            // Count all subarrays ending at 'right' that are good
            count += (right - left + 1);
        }

        return count;
    }

    // Main method for demonstration
    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        long k = sc.nextLong();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }
        final long res = countGoodSubarrays(arr, k);
        System.out.println(res);
    }
}

