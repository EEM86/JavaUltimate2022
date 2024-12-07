package yym.svydovets.algorithm.task.csosvita.search_loopy;

import org.apache.commons.lang3.NotImplementedException;

public class AutoLoan {

    /*
     * You have 2 real numbers price and monthly payment, and a single integer number loanTerm.
     * Find the annual percentage rate of the loan, assuming that the initial balance of the loan is price.
     * Print a single number - the resulting yearly interest rate. Your answer must be within 10_{-6} accuracy.
     *
     * Sample Input 0:
     * 2000.00 510.00 4
     * Sample Output 0:
     * 9.562054624583681
     *
     * Explanation 1:
     * Here, we do pay 9.562% annual interest, that means each month
     * we pay 0.7968% of the balance in interest. Our payment schedule looks like this:
     * Month | + Interest | - Payment | = Balance
     * ------------------------------------------
     *       |            |           |  2000.00
     *    1  |     15.94  |   510.00  |  1505.94
     *    2  |     12.00  |   510.00  |  1007.94
     *    3  |      8.03  |   510.00  |   505.97
     *    4  |      4.03  |   510.00  |     0.00
     */
    public static double solveRate(double price, int term, double monthly) {
        throw new NotImplementedException();
    }
}
