package yym.svydovets.algorithm.task.csosvita.search;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;
import yym.svydovets.algorithm.task.csosvita.sort.MergeIntervals;

class MergeIntervalsTest {

    @Test
    void mergeIntervals() {
        int[][] intervals = new int[][]{{1,3}, {2,6}, {8,10}, {15, 18}};
        String expected = """
            1 6
            8 10
            15 18""";
        List<int[]> result = MergeIntervals.mergeIntervals(intervals);
        Arrays.sort(intervals);
        assertEquals(1, result.get(0)[0]);
        assertEquals(6, result.get(0)[1]);
        assertEquals(8, result.get(1)[0]);
        assertEquals(10, result.get(1)[1]);
        assertEquals(15, result.get(2)[0]);
        assertEquals(18, result.get(2)[1]);
    }

    @Test
    void mergeIntervals2() {
        int[][] intervals = new int[][]{{1,4}, {4,5}};
        String expected = """
            1 5""";
        List<int[]> result = MergeIntervals.mergeIntervals(intervals);
        assertEquals(1, result.get(0)[0]);
        assertEquals(5, result.get(0)[1]);
    }

    @Test
    void mergeIntervals3() {
        int[][] intervals = new int[][]{{2,3}, {2,2}, {3,3}, {1, 3}, {5,7}, {2,2}, {4,6}};
        String expected = """
            1 3
            4 7""";
        List<int[]> result = MergeIntervals.mergeIntervals(intervals);
        assertEquals(1, result.get(0)[0]);
        assertEquals(3, result.get(0)[1]);
        assertEquals(4, result.get(1)[0]);
        assertEquals(7, result.get(1)[1]);
    }
}