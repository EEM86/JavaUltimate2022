package yym.svydovets.algorithm.task.csosvita.brute_force;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SubstractionTest {

    @Test
    void findSequences() {
        int n = 61;
        final String result = Substraction.findSequences(n);
        assertEquals("There are no solutions for " + n, result);
    }

    @Test
    void findSequences2() {
        int n = 3;
        String expected = """
            17469 / 05823 = 3
            17496 / 05832 = 3
            50382 / 16794 = 3
            53082 / 17694 = 3
            61749 / 20583 = 3
            69174 / 23058 = 3
            91746 / 30582 = 3
            96174 / 32058 = 3
            """;
        final String result = Substraction.findSequences(n);
        assertEquals(expected, result);
    }
}