package yym.svydovets.algorithm.task.csosvita.brute_force;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import yym.svydovets.algorithm.task.csosvita.brute_force.Room;

class RoomTest {

    @Test
    void testRoom() {
        final String result = Room.room(3, 2, 2, 2);
        assertEquals("YES\n1 0 1 0 1 0", result);
    }

    @Test
    void testRoom2() {
        final String result = Room.room(197, 195, 781, 90);
        assertEquals("NO", result);
    }

    @Test
    void testRoom3() {
        final String result = Room.room(15, 7, 10, 13);
        assertEquals("YES\n5 0 2 0 8 0", result);
    }

    @Test
    void testRoom4() {
        final String result = Room.room(2, 2, 0, 1);
        assertEquals("YES\n1 1 0 0 0 0", result);
    }

    @Test
    void testRoom5() {
        final String result = Room.room(471, 790, 109, 43);
        assertEquals("NO", result);
    }

    @Test
    void testRoom6() {
        final String result = Room.room(2, 4, 0, 0);
        assertEquals("NO", result);
    }

    @Test
    void testRoom7() {
        final String result = Room.room(0, 0, 0, 0);
        assertEquals("NO", result);
    }

}