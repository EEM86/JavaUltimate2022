package yym.svydovets.algorithm.task.csosvita.two_pointers;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Nulls {

    /*
     * You have a sequence of integers with length N and request amount M.
     * Each request has two integers L and R. Find the amount of zeros on the half-intervals [L,R)
     * Input format: first row - N integers. Second row - array of integers space separated.
     * Third row - M requests. Next M rows - two integers L and R space separated.
     * Print all zeros for each request [L,R) from the new line
     * 1 <= N, M <= 10^5
     * -10^9 <= Each integer in an array <= 10^9
     * 0 <= L < R <= N
     *
     * Sample input 0:
     * 8
     * 0 1 2 0 3 0 4 0
     * 3
     * 0 8
     * 2 6
     * 4 8
     * Sample Output:
     * 4
     * 2
     * 2
     */
    public static String nulls(int[] arr, List<int[]> requests) {
        int n = arr.length;

        int[] prefix = new int[n+1];
        for (int i = 1; i < n + 1; i++) {
            prefix[i] = prefix[i - 1] + (arr[i - 1] == 0 ? 1 : 0);
        }
        var sb = new StringBuilder();

        for (var el : requests) {
            int nulls = prefix[el[1]] - prefix[el[0]];
            sb.append(nulls).append("\n");
        }

        if (!sb.isEmpty()) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int reqNo = sc.nextInt();
        List<int[]> requests = new ArrayList<>();
        for (int i = 0; i < reqNo; i++) {
            requests.add(new int[]{sc.nextInt(), sc.nextInt()});
        }
        final String result = nulls(arr, requests);
        System.out.println(result);
    }

}
