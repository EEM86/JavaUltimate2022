package yym.svydovets.algorithm.task.intervals;

import org.apache.commons.lang3.NotImplementedException;

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
        throw new NotImplementedException();
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
        throw new NotImplementedException();
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
        throw new NotImplementedException();
    }

}
