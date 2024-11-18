package yym.svydovets.algorithm.task.csosvita.two_pointers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;
import org.junit.jupiter.api.Test;

class SquaresOfNumsTest {

    @Test
    void testFindSquare() {
        final List<Integer> res = SquaresOfNums.findSquares(16);
        assertEquals(4, res.get(0));
    }

    @Test
    void testFindSquare2() {
        final List<Integer> res = SquaresOfNums.findSquares(30);
        assertEquals(1, res.get(0));
        assertEquals(2, res.get(1));
        assertEquals(5, res.get(2));
    }

    @Test
    void testFindSquare3() {
        final List<Integer> res = SquaresOfNums.findSquares(4);
        assertEquals(2, res.get(0));
    }

    @Test
    void testFindSquare4() {
        final List<Integer> res = SquaresOfNums.findSquares(3);
        assertEquals(1, res.get(0));
        assertEquals(1, res.get(1));
        assertEquals(1, res.get(2));
    }

}