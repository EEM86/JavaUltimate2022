package yym.svydovets.algorithm.task.intervals;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class IntervalsTaskTest {

    private IntervalsTask service;

    @BeforeEach
    void setUp() {
        service = new IntervalsTask();
    }

    @Test
    void testInterval_v1() {
        int[][] intervals = new int[][]{{1,2}, {2,3}, {3,4}, {1,3}};

        final int result = service.eraseOverlapIntervals(intervals);

        assertEquals(1, result);
    }

    @Test
    void testInterval_v2() {
        int[][] intervals = new int[][]{{1,2}, {1,2}, {1,2}};

        final int result = service.eraseOverlapIntervals(intervals);

        assertEquals(2, result);
    }

    @Test
    void testInterval_v3() {
        int[][] intervals = new int[][]{{1,2}, {2,3}};

        final int result = service.eraseOverlapIntervals(intervals);

        assertEquals(0, result);
    }

    @Test
    void canVisit_v1() {
        int[][] intervals = new int[][]{{0,30}, {5,10}, {15, 20}};

        boolean result = service.canVisit(intervals);

        assertFalse(result);
    }

    @Test
    void canVisit_v2() {
        int[][] intervals = new int[][]{{5,10}, {15, 20}};

        boolean result = service.canVisit(intervals);

        assertTrue(result);
    }

    @Test
    void canVisit_v3() {
        int[][] intervals = new int[][]{{5,10}, {10, 20}};

        boolean result = service.canVisit(intervals);

        assertTrue(result);
    }

    @Test
    void minimumRoomsRequired_v1() {
        int[][] intervals = new int[][]{{0,30}, {5, 10}, {15, 20}};

        int result = service.minimumRoomsRequired(intervals);

        assertEquals(2, result);
    }

    @Test
    void minimumRoomsRequired_v2() {
        int[][] intervals = new int[][]{{5, 10}, {15, 20}};

        int result = service.minimumRoomsRequired(intervals);

        assertEquals(1, result);
    }

    @Test
    void minimumRoomsRequired_v3() {
        int[][] intervals = new int[][]{{5, 50}, {20, 40}, {35, 50}};

        int result = service.minimumRoomsRequired(intervals);

        assertEquals(3, result);
    }
}