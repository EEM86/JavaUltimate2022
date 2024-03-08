package yym.svydovets.algorithm.task.intervals;

import java.util.Arrays;
import java.util.stream.Stream;

public class IntervalsTask {

    /* Mid
     * https://leetcode.com/problems/non-overlapping-intervals/
     *
     * Given an array of intervals where intervals[i] = [starti, endi],
     * return the minimum number of intervals you need to remove to make
     * the rest of the intervals non-overlapping
     *
     * Example 1:
     * Input: intervals = [[1,2],[2,3],[3,4],[1,3]]
     * Output: 1
     * Explanation: [1,3] can be removed and the rest of the intervals are non-overlapping.
     */
    public int eraseOverlapIntervals(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        int end=intervals[0][1];
        int count=1;
        for(int i=1;i<intervals.length;i++){
            if(intervals[i][0]>=end){
                end=intervals[i][1];
                count++;
            }
        }
        return intervals.length-count;
    }

    /*
     * Easy
     *
     * Given an array of meeting time intervals consisting of start and end times
     * [[s1,e1],[s2,e2],...] (si < ei), determine if a person could attend all meetings.
     *
     * Example:
     * Input: intervals = [(0,30),(5,10),(15,20)]
     * Output: false
     * Explanation: (0,30), (5,10) and (0,30),(15,20) will conflict
     */
    public boolean canVisit(int[][] intervals) {
        Arrays.sort(intervals, (a,b) -> a[0] - b[0]);
        int prev = intervals[0][1];
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] < prev) {
                return false;
            } else {
                prev = intervals[i][1];
            }
        }
        return true;
    }

    /*
     * Medium
     *
     * Given an array of meeting time intervals consisting of start and end times
     * [[s1,e1]], [s2,e2], ...] (si < ei), find the minimum number of conference rooms required.
     *
     * Example:
     * Input: intervals = [(0,30), (5,10), (15,20)]
     * Output: 2
     * We need two meeting rooms: room1 = (0,30), room2 = (5,10), (15,20)
     */
    public int minimumRoomsRequired(int[][] intervals) {
        final Integer[] start = Stream.of(intervals)
            .map(i -> i[0])
            .sorted()
            .toArray(Integer[]::new);
        final Integer[] end = Stream.of(intervals)
            .map(i -> i[1])
            .sorted()
            .toArray(Integer[]::new);
        int count = 0, res = 0;

        int endPointer = 0, startPointer = 0;

        while (startPointer < intervals.length) {
            if (start[startPointer] < end[endPointer]) {
                count++;
                startPointer++;
            } else {
                count--;
                endPointer++;
            }
            res = Math.max(res, count);
        }

        return res;
    }

}
