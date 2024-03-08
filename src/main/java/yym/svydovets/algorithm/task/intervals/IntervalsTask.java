package yym.svydovets.algorithm.task.intervals;

import java.util.Arrays;

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

}
