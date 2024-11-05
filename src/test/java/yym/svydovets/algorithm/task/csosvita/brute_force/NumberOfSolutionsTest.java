package yym.svydovets.algorithm.task.csosvita.brute_force;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class NumberOfSolutionsTest {

    @Test
    void getSolutions() {
        int a = -1;
        int b = 9;
        int c = 70;
        int d = 0;
        int e = 15;

        final int result = NumberOfSolutions.getSolutions(e, a, b, c, d);
        assertEquals(2, result);
    }

    @Test
    void getSolutions2() {
        int a = 2;
        int b = 4;
        int c = 9;
        int d = 1;
        int e = 5;

        final int result = NumberOfSolutions.getSolutions(e, a, b, c, d);
        assertEquals(0, result);
    }
}