package yym.svydovets.algorithm.task.csosvita.two_pointers;

import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import org.apache.commons.lang3.NotImplementedException;

public class Requests {

    /*
     * Analyze the logs that contain a sequence of 0 and 1 as a result of request's calculation.
     * You must identify and return the length of the longest subarray of 1.
     * 1 <= n <= 1000000
     * Input 0: 6, 110111
     * Output 0: 3
     * Input 1: 6, 101101
     * Output 1: 2
     */

    static int longestSeq(int[] nums) {
        throw new NotImplementedException();
    }
    public static void main(String[] args) {
//        stressTest();
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];

        int i = 0;
        while (sc.hasNext()) {
            arr[i] = sc.nextInt();
            i++;
        }

        final int res = longestSeq(arr);
        System.out.println(res);
    }

    public static void stressTest() {
        int test = 0;
        while (true) {
            test++;
            if (test % 10 == 0) {
                System.out.println(test);
            }
            runTest();
        }
    }

    public static void runTest() {
//        Random random = new Random();
//
//        // Generate random array size
//        int n = random.nextInt(10) + 1;  // 1 to 10
//
//        // Create and fill array with random numbers
//        int[] a = new int[n];
//        for (int i = 0; i < n; i++) {
//            a[i] = random.nextInt(2);  // 0 to 1
//        }
//
//        // Compare results from both solutions
//        if (longestSeq(a) != longestSeqMyVersion(a)) {
//            System.out.println("Array: " + Arrays.toString(a));
//            System.out.println("Brute Force result: " + longestSeqMyVersion(a));
//            System.out.println("Optimal result: " + longestSeq(a));
//            throw new RuntimeException("Found a bug!");
//        }
    }

}
