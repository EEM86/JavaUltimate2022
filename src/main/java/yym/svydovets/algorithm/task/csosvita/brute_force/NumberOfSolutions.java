package yym.svydovets.algorithm.task.csosvita.brute_force;

import java.util.Scanner;
import org.apache.commons.lang3.NotImplementedException;

public class NumberOfSolutions {

    /*
     * Find all solutions for the function (ax^3 + bx^2 + cx + d) / (x - e) = 0
     * on the interval [0,1000] and print their number
     * -2^30 <= a, b, c, d, e <= 2^30
     * Sample Input 0:
     * 2
     * 4
     * 9
     * 1
     * 5
     * Sample Output 0: 0
     */
    public static int getSolutions(int e, int a, int b, int c, int d) {
        throw new NotImplementedException();
    }

    private static int cubicFunc(int a, int b, int c, int d, int x) {
        return a * (x * x * x) + b * (x * x) + c * x + d;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int a = scanner.nextInt();
        int b = scanner.nextInt();
        int c = scanner.nextInt();
        int d = scanner.nextInt();
        int e = scanner.nextInt();

        final int solutions = getSolutions(e, a, b, c, d);
        System.out.println(solutions);
    }

}
