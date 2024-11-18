package yym.svydovets.algorithm.task.csosvita.search;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class UniqueTest {

    @Test
    void unique() {
        String s = "abcabcbb";
        final int result = Unique.unique(s);
        assertEquals(3, result);
    }

    @Test
    void unique2() {
        String s = "ab  c";
        final int result = Unique.unique(s);
        assertEquals(3, result);
    }

    @Test
    void unique3() {
        String s = "bbbb";
        final int result = Unique.unique(s);
        assertEquals(1, result);
    }
}