package yym.svydovets.algorithm.task.csosvita.two_pointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
 * There are two arrays A and B, intersect them.
 * First num - the length of array A, next line - the array itselft
 *
 * 1<= |A|, |B| <= 1000
 * -5000000 <= A[i], B[i] <= 5000000
 *
 * Example
 * Input:
 * 4
 * 1 2 2 1
 * 2
 * 2 2
 * Output:
 * 2 2
 */
public class Peretyn {

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

    public static String peretyn(int n, int[] a, int m, int[] b) {
        Arrays.sort(a);
        Arrays.sort(b);
        List<Integer> res = new ArrayList<>();

        int i = 0, j = 0;

        while (i < n || j < m) {
            if (((i < n && j < m) && (a[i] == b[j]))) {
                res.add(a[i]);
                i++;
                j++;
            } else if ((i < n) && ((j >= m) || (a[i] < b[j]))) {
                i++;
            } else {
                j++;
            }
        }
        return res.isEmpty()
            ? "-1"
            : res.stream().map(String::valueOf).collect(Collectors.joining(" "));
    }

}
