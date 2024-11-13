package yym.svydovets.algorithm.task.csosvita.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
import org.apache.commons.lang3.NotImplementedException;

public class Peretyn {


    /*
     * There are two arrays A and B, intersect them.
     * First num - the length of array A, next line - the array itself
     *
     * 1<= |A|, |B| <= 1000
     * -5000000 <= A[i], B[i] <= 5000000
     *
     * Example
     * Input 0:
     * 4
     * 1 2 2 1
     * 2
     * 2 2
     * Output 0: 2 2
     * Input 1:
     * 3
     * 4 9 5
     * 5
     * 9 4 9 8 4
     * Output 1: 4 9
     */
    public static String peretyn(int n, int[] a, int m, int[] b) {
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
        final String result = peretyn(n, a, m, b);
        System.out.println(result);
    }

}
