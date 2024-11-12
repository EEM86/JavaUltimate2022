package yym.svydovets.algorithm.task.csosvita.two_pointers;

import java.util.Scanner;

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
        int i = 0, j = 0;
        int minDiff = Integer.MAX_VALUE;
        int bestI = 0, bestJ = 0;

        while (i < n && j < m) {
            int currDiff = Math.abs(arrN[i] - arrM[j]);
            if (minDiff > currDiff) {
                minDiff = currDiff;
                bestI = i;
                bestJ = j;
            }
            if (arrN[i] < arrM[j]) {
                i++;
            } else {
                j++;
            }
        }
        return arrN[bestI] + " " + arrM[bestJ];
    }
    public static String zir2(int n, int[] arrN, int m, int[] arrM) {
        int i = 0, j = 0;
        int minSub = Integer.MAX_VALUE;
        int nPair = n+1;
        int mPair = m+1;

        while (i < n && j < m) {
            if (arrN[i] <= arrM[j]) {
                if (minSub > arrM[j] - arrN[i]) {
                    minSub = arrM[j] - arrN[i];
                    nPair = i;
                    mPair = j;
                }
                i++;
            } else {
                if (minSub > arrN[i] - arrM[j]) {
                    minSub = arrN[i] - arrM[j];
                    nPair = i;
                    mPair = j;
                }
                j++;
            }
        }
        return arrN[nPair] + " " + arrM[mPair];
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
