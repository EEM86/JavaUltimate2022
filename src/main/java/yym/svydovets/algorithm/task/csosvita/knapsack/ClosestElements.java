package yym.svydovets.algorithm.task.csosvita.knapsack;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.stream.Collectors;

public class ClosestElements {

    /*
     * Given a sorted integer array, two ints k and x, return the k closest ints to x in the array.
     * An int is closer to x than an int b if:
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
