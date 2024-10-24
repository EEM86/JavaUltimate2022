package yym.svydovets.algorithm.task.csosvita;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class UniformNumTest {

    @Test
    void testGetUniform() {
        long a = 75, b = 300;

        final long result = UniformNum.getUniformNum(a, b);
        assertEquals(5, result);
    }

    @Test
    void testGetUniform2() {
        long a = 1, b = 8;

        final long result = UniformNum.getUniformNum(a, b);
        assertEquals(8, result);
    }

    /*
     * This test should work less than a few seconds.
     * I should add a timeout exception for this test execution later.
     */
    @Test
    void testGetUniform3() {
        long a = 1, b = (long) Math.pow(10, 12);

        final long result = UniformNum.getUniformNum(a, b);
        assertEquals(108, result);
    }

    @ParameterizedTest
    @ValueSource(longs = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 11, 22, 33, 44, 55, 66, 77, 88, 99, 111, 222, 333, 444, 555})
    void testIsUniformTrue(long n) {
        final boolean isUniform = UniformNum.isUniform(n);

        assertTrue(isUniform);
    }

    @ParameterizedTest
    @ValueSource(longs = {12, 25, 101, 112, 122, 131, 133, 144, 151, 202, 223, 303, 335, 363})
    void testIsUniformFalse(long n) {
        final boolean isUniform = UniformNum.isUniform(n);

        assertFalse(isUniform);
    }

    @Test
    void testIsUniformOneNum() {
        int n = 101;
        final boolean isUniform = UniformNum.isUniform(n);

        assertFalse(isUniform);
    }



}