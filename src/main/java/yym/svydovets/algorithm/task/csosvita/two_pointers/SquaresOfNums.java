package yym.svydovets.algorithm.task.csosvita.two_pointers;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;


public class SquaresOfNums {

    /*
     * Lagrange's theorem states that every positive integer can be expressed as the sum of 4 squares.
     * Given the number N, print from 1 to 4 positive integers that have the sum of their squares equal to N.
     * These numbers must be sorted and the result must contain the smallest amount of terms. If there are
     * several solutions, print the smallest one in lexicographic order.
     * 1 <= n <= 10_000
     * Example:
     * Input 0: 3
     * Output 0: 0 // 1 1 1
     * Input 1: 4
     * Output 1: 4 // 2
     *
     */
    static List<Integer> findSquares(int n) {
        for (int a = 1; a < 100; a++) {
            for (int b = 1; b < 100; b++) {
                for (int c = 1; c < 100; c++) {
                    for (int d = 1; d < 100; d++) {
                        if (a*a + b*b + c*c + d*d == n) {
                            return List.of(a,b,c,d);
                        }
                    }
                }
            }
        }
        return List.of();
    }

    static List<Integer> findSquaresDp(int n) {
        int[] dp = new int[n + 1];
        int[] squares = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            dp[i] = Integer.MAX_VALUE;
        }
        dp[0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j * j <= i; j++) {
                int square = j * j;
                if (dp[i] > dp[i - square] + 1) {
                    dp[i] = dp[i - square] + 1;
                    squares[i] = j;
                }
            }
        }
        List<Integer> result = new ArrayList<>();
        while (n > 0) {
            result.add(squares[n]);
            n -= squares[n] * squares[n];
        }

//        Collections.sort(result);
        return result;
    }
    public static List<Integer> findSquaresOneLoop(int n) {
        List<Integer> result = new ArrayList<>();

        // Single loop iterates over potential values for the largest square root (max possible for sqrt(n))
        for (int i = 1; i * i <= n; i++) {
            int singleNum = (int) Math.sqrt(n);
            if (singleNum * singleNum == n) {
                result.add(singleNum);
                return result;
            }

            int remainder1 = n - i * i;
            if (remainder1 == 0) {
                result.add(i);
                return result; // One square solution found
            }

            int j = (int) Math.sqrt(remainder1); // Calculate the square root directly for potential j
            int remainder2 = remainder1 - j * j;
            if (remainder2 == 0) {
                result.add(i);
                result.add(j);
                Collections.sort(result);
                return result; // Two square solution found
            }

            int k = (int) Math.sqrt(remainder2); // Calculate the square root directly for potential k
            int remainder3 = remainder2 - k * k;
            if (remainder3 == 0) {
                result.add(i);
                result.add(j);
                result.add(k);
                Collections.sort(result);
                return result; // Three square solution found
            }

            // Calculate the last square directly for four-square solution
            int l = (int) Math.sqrt(remainder3);
            if (l * l == remainder3) {
                result.add(i);
                result.add(j);
                result.add(k);
                result.add(l);
                Collections.sort(result);
                return result; // Four square solution found
            }
        }

        return result; // This should theoretically not happen for n >= 1
    }

    public static List<Integer> findSquaresIterative(int n) {
        List<Integer> result = null;

        // Check combinations from 1 to 4 terms
        for (int numTerms = 1; numTerms <= 4; numTerms++) {
            List<Integer> combination = new ArrayList<>();
            if (findSquaresWithLoops(n, numTerms, combination)) {
                result = new ArrayList<>(combination);
                break;
            }
        }

        return result != null ? result : Collections.emptyList();
    }

    private static boolean findSquaresWithLoops(int n, int numTerms, List<Integer> combination) {
        for (int i = 1; i * i <= n && numTerms >= 1; i++) {
            int sum1 = i * i;
            if (sum1 == n && numTerms == 1) {
                combination.add(i);
                return true;
            }
            if (numTerms == 1) continue;

            for (int j = i; j * j + sum1 <= n && numTerms >= 2; j++) {
                int sum2 = sum1 + j * j;
                if (sum2 == n && numTerms == 2) {
                    combination.add(i);
                    combination.add(j);
                    return true;
                }
                if (numTerms == 2) continue;

                for (int k = j; k * k + sum2 <= n && numTerms >= 3; k++) {
                    int sum3 = sum2 + k * k;
                    if (sum3 == n && numTerms == 3) {
                        combination.add(i);
                        combination.add(j);
                        combination.add(k);
                        return true;
                    }
                    if (numTerms == 3) continue;

                    for (int m = k; m * m + sum3 <= n && numTerms == 4; m++) {
                        int sum4 = sum3 + m * m;
                        if (sum4 == n) {
                            combination.add(i);
                            combination.add(j);
                            combination.add(k);
                            combination.add(m);
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}
