package yym.svydovets.algorithm.task.csosvita.two_pointers;

import java.util.Scanner;

public class Row01 {

    /*
     * You have the binary sequence with length N.
     * It contains only 0 and 1.
     * Find subsequence "01" Print the index of 0.
     * Your solution should work faster then O(N).
     * 2 <= N <= 10^9
     *
     * Sample Input 0:
     * 5
     * 00011
     * Sample Output 0:
     * 2
     */
    public static int find01(String s) {
        int b = -1;
        int g = s.length();

        while (g - b > 1) {
            int m = (g + b) / 2;
            if (s.charAt(m) == '1') {
                g = m;
            } else {
                b = m;
            }
        }
        return b;
    }

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        String s = sc.next();
        final int result = find01(s);
        System.out.println(result);
    }

}
