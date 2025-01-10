package yym.svydovets.algorithm.task.csosvita.greedy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import yym.svydovets.algorithm.task.csosvita.greedy.SeatManagerTask.SeatManager;

class SeatManagerTaskTest {

    @Test
    void testSeatManager() {
        var sm = new SeatManager(5);
        assertEquals(1, sm.reserve());
        assertEquals(2, sm.reserve());
        sm.unreserve(2);
        assertEquals(2, sm.reserve());
        assertEquals(3, sm.reserve());
        assertEquals(4, sm.reserve());
        assertEquals(5, sm.reserve());
        sm.unreserve(5);
        assertEquals(1, sm.seats.size());
    }

}