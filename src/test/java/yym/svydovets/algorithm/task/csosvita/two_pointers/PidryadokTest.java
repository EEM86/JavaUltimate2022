package yym.svydovets.algorithm.task.csosvita.two_pointers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PidryadokTest {

    @Test
    void test1() {
        String s = "abb";
        final String result = Pidryadok.pidryadok(s, 1);
        assertEquals("2 1", result);
    }

    @Test
    void test2() {
        String s = "ababa";
        final String result = Pidryadok.pidryadok(s, 2);
        assertEquals("4 1", result);
    }

}