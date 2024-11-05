package yym.svydovets.algorithm.task.csosvita.brute_force;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import org.apache.commons.lang3.NotImplementedException;
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
        throw new NotImplementedException();
    }

    static int presentsDp(int[] arr) {
        throw new NotImplementedException();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        int b = sc.nextInt();
        int c = sc.nextInt();
        int d = sc.nextInt();

        System.out.println(presentsDp(new int[]{a,b,c,d}));
    }
}
