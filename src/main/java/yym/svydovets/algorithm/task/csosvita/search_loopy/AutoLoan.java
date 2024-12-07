package yym.svydovets.algorithm.task.csosvita.search_loopy;

import java.util.Scanner;

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
        double bad = -1.0;
        double good = 101.0;
        double epsilon = 1e-6;

        while (good - bad > epsilon) {
            double cand = (good + bad) / 2.0;
            if (isGood(cand, price, term, monthly)) {
                good = cand;
            } else {
                bad = cand;
            }
        }

        return good;
    }

    private static boolean isGood(double rate, double price, int term, double monthly) {
        double monthRate = rate / 1200;
        while (term-- != 0) {
            price += price * monthRate - monthly;
        }
        return price >= 0;
    }

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        String[] tokens = sc.nextLine().split(" ");
        double price = Double.parseDouble(tokens[0]);
        double monthly = Double.parseDouble(tokens[1]);
        int term = Integer.parseInt(tokens[2]);

        double rate = solveRate(price, term, monthly);
        System.out.println(rate);
        sc.close();
    }

}
