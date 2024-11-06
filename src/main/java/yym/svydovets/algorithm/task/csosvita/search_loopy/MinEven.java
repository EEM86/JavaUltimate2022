package yym.svydovets.algorithm.task.csosvita.search_loopy;

import java.util.Scanner;

public class MinEven {

    /*
     * Return a min even number from the array.
     * If the array doesn't contain such even number, return -1.
     * The first row is the length of array, the second - array's elements.
     * 1 < n < 1000_000
     * -1000 < n[i] < 1000
     *
     * Sample Input 0:
     * 4
     * 3 7 4 6
     * Sample Output 0:
     * 4
     */
    public static int minEven(int[] arr) {
        int minEven = Integer.MAX_VALUE;
        for (int el : arr) {
            if (el % 2 == 0) {
                minEven = Math.min(minEven, el);
            }
        }
        return minEven == Integer.MAX_VALUE ? -1 : minEven;
    }

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        final int result = minEven(arr);
        System.out.println(result);
    }

}
