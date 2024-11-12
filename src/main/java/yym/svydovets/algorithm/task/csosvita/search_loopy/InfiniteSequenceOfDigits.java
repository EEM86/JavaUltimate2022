package yym.svydovets.algorithm.task.csosvita.search_loopy;

import java.util.Scanner;

public class InfiniteSequenceOfDigits {

    public static String findNumbers(int[] arr) {
        var res = new StringBuilder();
        var sb = new StringBuilder();
        int idx = 1;
        sb.append(idx);
        for (int el : arr) {
            while (sb.length() < el) {
                idx *= 10;
                sb.append(idx);
            }
            res.append(sb.charAt(el - 1)).append(" ");
        }
        if (!res.isEmpty()) {
            res.deleteCharAt(res.length() - 1);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        final String result = findNumbers(arr);
        System.out.println(result);
    }

}
