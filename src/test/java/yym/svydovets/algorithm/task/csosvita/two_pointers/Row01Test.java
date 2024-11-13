package yym.svydovets.algorithm.task.csosvita.two_pointers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Row01Test {

    @Test
    void find01() {
        String s = "00011";
        final int result = Row01.find01(s);
        assertEquals(2, result);
    }

    @Test
    void find02() {
        String s = "00000000001";
        final int result = Row01.find01(s);
        assertEquals(9, result);
    }
}