package yym.svydovets.algorithm.task.csosvita.knapsack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import yym.svydovets.algorithm.task.csosvita.knapsack.PingTask.RecentCounter;

class PingTaskTest {

    @Test
    void testRequests() {
        RecentCounter counter = new RecentCounter();
        assertEquals(1, counter.ping(1));
        assertEquals(2, counter.ping(100));
        assertEquals(3, counter.ping(3001));
        assertEquals(3, counter.ping(3002));
    }

    @Test
    void testRequests2() {
        RecentCounter counter = new RecentCounter();
        assertEquals(1, counter.ping(1));
    }

    @Test
    void testRequests3() {
        RecentCounter counter = new RecentCounter();
        assertEquals(1, counter.ping(1));
        assertEquals(2, counter.ping(100));
        assertEquals(1, counter.ping(3110));
    }

    @Test
    void testRequests4() {
        RecentCounter counter = new RecentCounter();
        assertEquals(1, counter.ping(1));
        assertEquals(2, counter.ping(2));
        assertEquals(3, counter.ping(3));
        assertEquals(4, counter.ping(4));
        assertEquals(5, counter.ping(3000));
    }

    @Test
    void testRequests5() {
        RecentCounter counter = new RecentCounter();
        assertEquals(1, counter.ping(1));
        assertEquals(2, counter.ping(1));
        assertEquals(3, counter.ping(1));
        assertEquals(1, counter.ping(4000));
    }

    @Test
    void testRequests6() {
        RecentCounter counter = new RecentCounter();
        assertEquals(1, counter.ping(1));
        assertEquals(2, counter.ping(3000));
        assertEquals(1, counter.ping(2_000_000_000));
    }

}