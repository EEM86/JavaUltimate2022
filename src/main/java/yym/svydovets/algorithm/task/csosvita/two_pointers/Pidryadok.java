package yym.svydovets.algorithm.task.csosvita.two_pointers;

import java.util.Scanner;
import org.apache.commons.lang3.NotImplementedException;

public class Pidryadok {

    /*
     * You have a row, choose the sub row that contains not more than k equal symbols.
     * Input has n symbols in the row and k in first line.
     * The second line is a string with low english letters.
     * Print the maximum length of sub row and the first symbol (first index is 1).
     * If there are several solutions, print the most left symbol.
     * 1 <= n <= 100_000
     * 1 <= k <= n
     *
     * Sample Input 0:
     * 3 1
     * abb
     * Sample Output 0:
     * 2 1
     */
    public static String pidryadok(String s, int k) {
        throw new NotImplementedException();
    }

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        String s = sc.next();

        final String result = pidryadok(s, k);
        System.out.println(result);
    }

}
