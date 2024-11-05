package yym.svydovets.algorithm.task.csosvita.brute_force;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class OptimizationTest {

    @Test
    void optimizationOn2() {
        int n = 3;
        final int result = Optimization.optimizationOn2(n);
        assertEquals(10, result);
    }

    @Test
    void optimizationOn() {
        int n = 3;
        final int result = Optimization.optimizationOn(n);
        assertEquals(10, result);
    }

    @Test
    void optimizationO1() {
        int n = 3;
        final int result = Optimization.optimizationO1(n);
        assertEquals(10, result);
    }
}