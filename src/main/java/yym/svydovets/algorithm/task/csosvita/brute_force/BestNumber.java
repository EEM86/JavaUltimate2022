package yym.svydovets.algorithm.task.csosvita.brute_force;

public class BestNumber {


    /*
     * You have A and B - positive integers. A is better than B if the sum of the squares of the digits of A
     * is greater than the sum of the squares of the digits of B. If the sum of squares is the same, the number
     * with the smaller value is bette.
     *
     * Find the best prime number in the interval [L,R] inclusive. If there is no such number, print -1.
     *
     * 2 <= L <= R <= 50_000
     * Sample Input 0:  15 30
     * Sample Output 0: 29
     */
    public static int getBestNumber(int a, int b) {
        int bestNumber = -1;
        int maxSqr = 0;
        for (int i = a; i <= b; i++) {
            if (isPrime(i)) {
                int sqr = findSumOfSqr(i);
                if (maxSqr < sqr) {
                    maxSqr = sqr;
                    bestNumber = i;
                }
            }
        }
        return bestNumber;
    }

    private static int findSumOfSqr(int i) {
        int sum = 0;
        while (i > 0) {
            sum += (i % 10) * (i % 10);
            i /= 10;
        }
        return sum;
    }

    private static boolean isPrime(int n) {
        int i = 2;
        while (i * i <= n) {
            if (n % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }

}
