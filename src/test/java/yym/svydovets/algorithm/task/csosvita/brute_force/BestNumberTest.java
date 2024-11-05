package yym.svydovets.algorithm.task.csosvita.brute_force;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class BestNumberTest {

    @Test
    void getBestNumber() {
        final int result = BestNumber.getBestNumber(15, 30);
        assertEquals(29, result);
    }

    @Test
    void getBestNumber2() {
        final int result = BestNumber.getBestNumber(14, 16);
        assertEquals(-1, result);
    }
}