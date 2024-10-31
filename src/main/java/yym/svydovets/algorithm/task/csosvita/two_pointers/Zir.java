package yym.svydovets.algorithm.task.csosvita.two_pointers;

import java.util.Scanner;

public class Zir {

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

    public static String zir(int n, int[] arrN, int m, int[] arrM) {
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

}
