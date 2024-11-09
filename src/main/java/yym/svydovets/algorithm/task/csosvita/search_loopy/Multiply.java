package yym.svydovets.algorithm.task.csosvita.search_loopy;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Multiply {

    /*
     * You have an array of numbers. Find the two elements that multiply to the max number.
     * Print these two numbers with the maximum of them in the end.
     * The complexity must be O(n)
     *
     * n <= 100_000
     * -2^30 <= a[i] <= 2^30
     *
     * Sample Input 0: 4 3 5 2 5
     * Sample Output 0: 5 5
     */
    public static int[] findMaxMultiply(List<Integer> arr) {
        int firstMax = Integer.MIN_VALUE;
        int secondMax = Integer.MIN_VALUE;

        int firstMinusMax = Integer.MAX_VALUE;
        int secondMinusMax = Integer.MAX_VALUE;

        for (int el : arr) {
            if (el < 0) {
                if (el < firstMinusMax) {
                    secondMinusMax = firstMinusMax;
                    firstMinusMax = el;
                } else if (el < secondMinusMax) {
                    secondMinusMax = el;
                }
            } else {
                if (el > firstMax) {
                    secondMax = firstMax;
                    firstMax = el;
                } else if (el > secondMax) {
                    secondMax = el;
                }
            }
        }
        long positiveMultiply = (firstMax != Integer.MIN_VALUE && secondMax != Integer.MIN_VALUE) ?
            (long) firstMax * secondMax : Long.MIN_VALUE;
        long negativeMultiply = (firstMinusMax != Integer.MAX_VALUE && secondMinusMax != Integer.MAX_VALUE) ?
            (long) firstMinusMax * secondMinusMax : Long.MIN_VALUE;

        if (positiveMultiply > negativeMultiply) {
            return new int[]{secondMax, firstMax};
        } else {
            return new int[]{firstMinusMax, secondMinusMax};
        }
    }

    public static void main(String[] args) {
        var list = new ArrayList<Integer>();

        var sc = new Scanner(System.in);
        while (sc.hasNext()) {
            list.add(sc.nextInt());
        }

        final int[] result = findMaxMultiply(list);
        System.out.printf("%d %d", result[0], result[1]);
    }

}
