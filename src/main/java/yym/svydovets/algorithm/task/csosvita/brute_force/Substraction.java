package yym.svydovets.algorithm.task.csosvita.brute_force;

import java.util.HashSet;
import java.util.Scanner;

public class Substraction {

    /*
     * Write a program that finds and prints all pairs of 5-digit numbers that use all digits
     * from 0 to 9 once, so that the first number divided by the second equals the integer N.
     * It is assumed that the first digit of one of the numbers is zero.
     * Print in the format: xxxxx / xxxxx = Nin a sorted format or
     * print "There are no solutions for {n}."
     *
     * 2 <= N <= 79
     *
     * Sample Input 0: 3
     * Sample Output 0:
     * 17469 / 05823 = 3
     * 17496 / 05832 = 3
     * 50382 / 16794 = 3
     * 53082 / 17694 = 3
     * 61749 / 20583 = 3
     * 69174 / 23058 = 3
     * 91746 / 30582 = 3
     * 96174 / 32058 = 3
     */
    public static String findSequences(int n) {
        for (int fghij = 1234; fghij <= 98765 / n; fghij++) {
            int abcde = fghij * n; // abcde and fghij are both at most 5 digits
            int used = (fghij < 10000) ? 1 : 0; // if f=0, we flag it by setting the lowest bit of 'used' to 1

            // Mark digits used in abcde
            long tmp = abcde;
            while (tmp > 0) {
                used |= 1 << (tmp % 10); // Set the bit for the current digit
                tmp /= 10;
            }

            // Mark digits used in fghij
            tmp = fghij;
            while (tmp > 0) {
                used |= 1 << (tmp % 10); // Set the bit for the current digit
                tmp /= 10;
            }

            // Check if used has all 10 bits set, meaning we have digits 0 through 9
            if (used == (1 << 10) - 1) {
                return String.format("%05d / %05d = %d%n", abcde, fghij, n);
            }
        }
        return "There are no solutions for " + n;
    }


    public static String substraction(int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 1000; i < 100000; i++) {
            if (hasDublicates(i)) continue;
            int res = i * n;
            if (!hasDublicates(res)) {
                if (from0ToHero(res, i)) {
                    if (!is5N(res)) {
                        sb.append('0');
                    }
                    sb.append(res).append(" / ");

                    if (!is5N(i)) {
                        sb.append('0');
                    }
                    sb.append(i);
                    sb.append(String.format(" = %d", n)).append("\n");
                }
            }
        }
        if (sb.isEmpty()) {
            return "There are no solutions for " + n;
        }
        return sb.toString();
    }

    private static boolean from0ToHero(int first, int second) {
        StringBuilder sb = new StringBuilder();
        if (!is5N(first)) {
            sb.append('0');
        }
        sb.append(first);

        if (!is5N(second)) {
            sb.append('0');
        }
        sb.append(second);
        String s = sb.toString();

        int[] digits = new int[10];

        for (char ch : s.toCharArray()) {
            int idx = Integer.parseInt(String.valueOf(ch));
            digits[idx]++;
            if (digits[idx] > 1) return false;
        }
        return true;
    }

    private static boolean is5N(int n) {
        String res = String.valueOf(n);
        return res.length() == 5;
    }

    private static boolean hasDublicates(int n) {
        var set = new HashSet<Integer>();
        while (n > 0) {
            int mod = n % 10;
            if (!set.add(mod)) {
                return true;
            }
            n = n / 10;
        }
        return false;
    }

}
