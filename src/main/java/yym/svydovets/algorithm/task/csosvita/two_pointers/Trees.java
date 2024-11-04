package yym.svydovets.algorithm.task.csosvita.two_pointers;

import java.util.Scanner;

public class Trees {

    /* There are trees that are going to be cut down. Save the subarray of trees with
     * at least 1 different kinds of a tree.
     * There are two numbers N and K in the first row.
     * There are N space separated integers with sorts of the tree in the second row.
     * It is guaranteed that there is at least one unique sorts of a tree in the row.
     * You have to print two integers - indexes of left and right borders of a minimum sequence of such trees.
     * If there are several solutions, print the subarray with the smallest left index.
     *
     * Input 0:
     * 5 3
     * 1 2 1 3 2
     * Output 0:
     * 2 4
     */
    public static int[] trees(int[] arr, int k) {
        int sum = 0;
        int[] els = new int[k + 1];
        int l = 0;

        int minLen = arr.length + 1;
        int[] res = new int[2];

        for (int r = 0; r < arr.length; r++) {
            if (els[arr[r]] == 0) {
                sum++;
            }
            els[arr[r]]++;

            while (sum == k) {
                if (minLen > r - l + 1) {
                    minLen = r - l + 1;
                    res[0] = l + 1;
                    res[1] = r + 1;
                }

                els[arr[l]]--;
                if (els[arr[l]] == 0) {
                    sum--;
                }
                l++;
            }
        }

        return res;
    }

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int target = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        final int[] result = trees(arr, target);
        System.out.println(result[0] + " " + result[1]);
    }

}
