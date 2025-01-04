package yym.svydovets.algorithm.task.csosvita.knapsack;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class EvalTest {

    @Test
    void eval1() {
        String notation = "2 1 + 3 *";
        final int result = Eval.eval(notation);
        assertEquals(9, result);
    }

    @Test
    void eval2() {
        String notation = "4 13 5 / +";
        final int result = Eval.eval(notation);
        assertEquals(6, result);
    }

    @Test
    void eval3() {
        String notation = "2 4 +";
        final int result = Eval.eval(notation);
        assertEquals(6, result);
    }

    @Test
    void eval4() {
        String notation = "2 4 * 8 +";
        final int result = Eval.eval(notation);
        assertEquals(16, result);
    }

    @Test
    void eval5() {
        String notation = "2 4 8 + *";
        final int result = Eval.eval(notation);
        assertEquals(24, result);
    }

    @Test
    void eval6() {
        String notation = "2 4 -";
        final int result = Eval.eval(notation);
        assertEquals(-2, result);
    }

    @Test
    void eval7() {
        String notation = "6 5 -";
        final int result = Eval.eval(notation);
        assertEquals(1, result);
    }

    @Test
    void eval8() {
        String notation = "6 5 3 - -";
        final int result = Eval.eval(notation);
        assertEquals(4, result);
    }
}