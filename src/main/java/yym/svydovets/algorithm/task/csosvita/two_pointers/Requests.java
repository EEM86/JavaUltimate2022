package yym.svydovets.algorithm.task.csosvita.two_pointers;

import java.util.Scanner;

public class Requests {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        int i = 0;
        while (sc.hasNext()) {
            arr[i] = sc.nextInt();
            i++;
        }

        final int res = longestSeq(arr, n);
        System.out.println(res);
    }

    static int longestSeq(int[] arr, int n) {
        int l = 0, r = 0;
        int max = 0;

        while (r < n) {
            if (arr[r] == 1) {
                max = Math.max(max, r - l + 1);
            } else {
                l = r+1;
            }
            r++;
        }
        return max;
    }

}
