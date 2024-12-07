package yym.svydovets.algorithm.task.csosvita.search_loopy;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class AutoLoanTest {

    @Test
    void solveRate() {
        double price = 15000.00;
        int term = 48;
        double monthly = 364.00;

        final double result = AutoLoan.solveRate(price, term, monthly);
        assertEquals(7.6878563945, result, 1e-6);
    }

    @Test
    void solveRate2() {
        double price = 6800.00;
        int term = 68;
        double monthly = 100.00;

        final double result = AutoLoan.solveRate(price, term, monthly);
        assertEquals(0.000000000000133, result, 1e-6);
    }

    @Test
    void solveRate3() {
        double price = 2000.00;
        int term = 4;
        double monthly = 510.00;

        final double result = AutoLoan.solveRate(price, term, monthly);
        assertEquals(9.562054624583681, result, 1e-6);
    }
}