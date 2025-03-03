package yym.svydovets.algorithm.task.csosvita.sort;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MergeIntervals {

    /*
     * Given an array of intervals representing video watch times,
     * where each interval is defined as [start, end] —
     * indicating the start and stop times of a video segment.
     * Merge all overlapping intervals and return an array
     * of the non-overlapping intervals that cover the same time range as the input.
     *
     * Your goal is to implement the merge routine to solve this problem.
     *
     * 1 <= n <= 10^5
     * intervals[i].length == 2
     * 0 <= start_i <= end_i <= 10^4
     *
     * Sample Input 0:
     * [[1,3], [2,6], [8,10], [15,18]]
     * Sample Output 0:
     * "1 6
     *  8 10
     *  15 18"
     * Explanation 0:
     * Since intervals [1,3] and [2,6] overlap, merge them into [1,6]
     */
    public static List<int[]> mergeIntervals(int[][] intervals) {
        Arrays.sort(intervals, ((a, b) -> a[0] - b[0]));
        int[] prev = null;
        List<int[]> accum = new ArrayList<>();
        for (int[] interval : intervals) {
            if (prev != null && interval[0] <= prev[1]) {
                prev[1] = Math.max(prev[1], interval[1]);
            } else {
                prev = interval;
                accum.add(interval);
            }
        }
        return accum;
    }
}