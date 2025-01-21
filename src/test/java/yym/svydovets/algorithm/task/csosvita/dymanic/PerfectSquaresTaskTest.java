package yym.svydovets.algorithm.task.csosvita.dymanic;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PerfectSquaresTaskTest {

    @Test
    void getLeastNum1() {
        int n = 12;
        final int result = PerfectSquaresTask.getLeastNum(n);

        assertEquals(3, result);
    }

    @Test
    void getLeastNum2() {
        int n = 13;
        final int result = PerfectSquaresTask.getLeastNum(n);

        assertEquals(2, result);
    }
}