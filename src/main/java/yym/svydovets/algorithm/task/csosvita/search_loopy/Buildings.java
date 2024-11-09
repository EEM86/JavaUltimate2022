package yym.svydovets.algorithm.task.csosvita.search_loopy;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

public class Buildings {

    public static int buildings(int n) {
        int k = (int) ((Math.sqrt(1 + 8L * n) - 1) / 2);
        if ((long) k * (k + 1) / 2 > n) {
            k--;
        }
        return k;
    }

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();

        final long result = buildings(n);
        System.out.println(result);
    }

}
