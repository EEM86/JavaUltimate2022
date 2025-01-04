package yym.svydovets.algorithm.task.csosvita.knapsack;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class ClosestElements {

    /*
     * Given a sorted integer array, two ints k and x, return the k closest ints to x in the array.
     * An 'a' int is closer to x than an int 'b' if:
     * |a-x| <  |b-x|, or
     * |a-x| == |b-x| and a < b
     *
     * 1 <= k <= arr.length
     * 1 <= arr.length <= 10^4
     * -10^4 <= arr[i], x <= 10^4
     * arr is sorted in ascending order
     *
     * Sample Input 0:
     * 4 3
     * 1 2 3 4 5
     *
     * Sample Output 0:
     * 1 2 3 4
     */
    public static String findClosestElements(int k, int[] arr, int x) {
        int left = 0, right = arr.length - k;

        // Binary search to find the leftmost position
        while (left < right) {
            int mid = (left + right) / 2;
            // Compare mid and mid + k based on their distance to x
            if (x - arr[mid] > arr[mid + k] - x) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        var sb = new StringBuilder();
        for (int i = left; i < left + k; i++) {
            sb.append(arr[i]);
            if (i != left + k - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }

    public static String getClosest(int k, int[] arr, int x) {
        Comparator<Integer> comp = createComparator(x);
        PriorityQueue<Integer> pq = new PriorityQueue<>(comp);
        for (int el : arr) {
            pq.add(el);
            if (pq.size() > k) {
                pq.poll();
            }
        }
        return pq.stream()
            .sorted()
            .map(String::valueOf)
            .collect(Collectors.joining(" "));
    }

    private static Comparator<Integer> createComparator(int x) {
        return (a, b) -> {
            if (a.equals(b))
                return 0;
            if (Math.abs(a - x) < Math.abs(b - x)) {
                return 1;
            }
            if (Math.abs(a - x) == Math.abs(b - x) && a < b) {
                return 1;
            }
            return -1;
        };
    }

}
