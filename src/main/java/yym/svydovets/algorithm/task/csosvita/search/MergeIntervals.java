package yym.svydovets.algorithm.task.csosvita.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class MergeIntervals {

    public static String mergeIntervals(int[][] intervals) {
        Arrays.sort(intervals, ((a, b) -> a[0] - b[0]));
        int[] prev = null;
        List<int[]> accum = new ArrayList<>();
        for (int[] interval : intervals) {
            if (isOverlapped(interval, prev)) {
                prev[1] = Math.max(prev[1], interval[1]);
            } else {
                prev = interval;
                accum.add(interval);
            }
        }

        var sb = new StringBuilder();
        for (int[] interval : accum) {
            sb.append(interval[0]).append(" ").append(interval[1]).append("\n");
        }
        if (!sb.isEmpty()) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private static boolean isOverlapped(int[] interval, int[] prev) {
        return prev != null && interval[0] <= prev[1];
    }

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[][] intervals = new int[n][2];
        for (int i = 0; i < n; i++) {
            intervals[i] = new int[]{sc.nextInt(), sc.nextInt()};
        }
        final String result = mergeIntervals(intervals);
        System.out.println(result);
    }

}
