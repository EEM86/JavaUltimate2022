package yym.svydovets.algorithm.task.csosvita.two_pointers;

import java.util.Scanner;
import org.apache.commons.lang3.NotImplementedException;

public class Zir {

    /*
     * You have two arrays with colors. The task is to find a pair using two arrays
     * with a minimum difference in colors. The colors are unique, the arrays filled in
     * with positive numbers in growing order.
     * 1 <= N <= 100000
     * 1 <= M <= 100000
     *
     * Example:
     * Input (length arr1 \n arr1 \n length arr2 \n arr2):
     * 2
     * 3 4
     * 3
     * 1 2 3
     * Output: 3 3 (arr1[0], arr2[2])
     */
    public static String zir(int n, int[] arrN, int m, int[] arrM) {
        throw new NotImplementedException();
    }

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }
        int m = sc.nextInt();
        int[] b = new int[m];
        for (int i = 0; i < m; i++) {
            b[i] = sc.nextInt();
        }
        final String result = zir(n, a, m, b);
        System.out.println(result);
    }

}
