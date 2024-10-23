package yym.svydovets.algorithm.task.csosvita;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VykreslenniaTest {

    @Test
    void cutOut() {
        String input = "111111111110011111111";

        final int result = Vykreslennia.cutOut(input);
        assertEquals(4, result);
    }
}