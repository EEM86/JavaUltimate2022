package yym.svydovets.algorithm.task.csosvita.brute_force;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class HomogeneousNumTest {

    @Test
    void testGetUniform() {
        long a = 75, b = 300;

        final long result = HomogeneousNum.getUniformNum(a, b);
        assertEquals(5, result);
    }

    @Test
    void testGetUniform2() {
        long a = 1, b = 8;

        final long result = HomogeneousNum.getUniformNum(a, b);
        assertEquals(8, result);
    }

    /*
     * This test should work less than a few seconds.
     * I should add a timeout exception for this test execution later.
     */
    @Test
    void testGetUniform3() {
        long a = 1, b = (long) Math.pow(10, 12);

        final long result = HomogeneousNum.getUniformNum(a, b);
        assertEquals(108, result);
    }

}
