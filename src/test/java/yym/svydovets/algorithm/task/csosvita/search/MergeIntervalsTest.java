package yym.svydovets.algorithm.task.csosvita.search;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MergeIntervalsTest {

    @Test
    void mergeIntervals() {
        int[][] intervals = new int[][]{{1,3}, {2,6}, {8,10}, {15, 18}};
        String expected = """
            1 6
            8 10
            15 18""";
        final String result = MergeIntervals.mergeIntervals(intervals);
        assertEquals(expected, result);
    }

    @Test
    void mergeIntervals2() {
        int[][] intervals = new int[][]{{1,4}, {4,5}};
        String expected = """
            1 5""";
        final String result = MergeIntervals.mergeIntervals(intervals);
        assertEquals(expected, result);
    }

    @Test
    void mergeIntervals3() {
        int[][] intervals = new int[][]{{2,3}, {2,2}, {3,3}, {1, 3}, {5,7}, {2,2}, {4,6}};
        String expected = """
            1 3
            4 7""";
        final String result = MergeIntervals.mergeIntervals(intervals);
        assertEquals(expected, result);
    }
}