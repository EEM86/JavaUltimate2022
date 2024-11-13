package yym.svydovets.algorithm.task.csosvita.brute_force;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import org.checkerframework.checker.units.qual.A;

public class Presents {

    /*
     * You have presents: Javelin with X weight, Patriot with Y weight and F16 with - Z kg
     * How many presents of the weight of W you can receive.
     *
     * 1 <= X, Y, Z <= 100
     * 1 <= W <= 1000
     *
     * Sample Input 0: 10 25 15 40
     * Sample Output 0: 3
     */
    public static int presentsOsvita(int[] arr) {
        int x = arr[0];
        int y = arr[1];
        int z = arr[2];
        int w = arr[3];
        int cnt = 0;
        for (int i = 0; i * x <= w; i++) {
            for (int j = 0; j * y <= w ; j++) {
                int diff = w - j * y - i * x;
                if (diff >= 0 && diff % z == 0) {
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static int presents(int[] arr) {
        int a = arr[0];
        int b = arr[1];
        int c = arr[2];
        int target = arr[3];
        var resSet = new HashSet<List<Integer>>();

        int sol = 0;

        int[] presents = new int[]{a,b,c};
        int[] dp = new int[target+1];
        dp[0] = 1;

        for (int present : presents) {
            for (int j = present; j <= target; j++) {
                dp[j] += dp[j - present];
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        System.out.println(presents(new int[]{a,b,c,d}));
    }
}
