package yym.svydovets.algorithm.task.csosvita.two_pointers;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Random;
import java.util.Scanner;

public class Sensors {

    /*
     * Sensors cannot capture out of the distance. Find an amount of unique sensors that can work together
     * without intersections.
     * A first row in the input N - amount of sensors, R - max distance that must not be intersected by sensors
     * A second row - N positive integers d1, ... , dn that show the distance from the i-th sensor to the capture zone.
     * All sensors are in different distances and are sorted in not decreasing mode.
     *
     * 1 <= d1, d2, ..., dn <= 10^9
     * 2 <= n <= 300_000
     * 1 <= R <= 10^9
     *
     * Input 0:
     * 4 4
     * 1 3 5 8
     * Output 0: 2 // we can choose sensors 1 and 4 and sensors 2 and 4 because the distance between them > 4
     */
    public static long countSensorsBruteForce(int[] arr, long n) {
        long count = 0;
        for (int left = 0; left < arr.length - 1; left++) {
            int right = left + 1;
            // Use while loop for the inner iteration
            while (right < arr.length) {
                if (arr[right] - arr[left] > n) {
                    count++;
                }
                right++;
            }
        }
        return count;
    }

    public static long countSensorsOptimal(int[] arr, long n) {
        long count = 0;
        int l = 0;
        for (int r = 1; r < arr.length; r++) {
            while (arr[r] - arr[l] > n) {
                count += arr.length - r;
                l++;
            }
        }
        return count;
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
        Random random = new Random();

        // Generate random array size
        int n = random.nextInt(10) + 1;  // 1 to 10

        // Create and fill array with random numbers
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
            a[i] = random.nextInt(11);  // 0 to 10
        }

        // Generate random target sum
        long s = random.nextLong(10_000_000_000L);  // 0 to 50

        // Compare results from both solutions

        Arrays.sort(a);
        if (countSensorsBruteForce(a, s) != countSensorsOptimal(a, s)) {
            System.out.println("Array: " + Arrays.toString(a));
            System.out.println("Target sum: " + s);
            System.out.println("Brute Force result: " + countSensorsBruteForce(a, s));
            System.out.println("Optimal result: " + countSensorsOptimal(a, s));
            throw new RuntimeException("Found a bug!");
        }
    }

//    public static void main(String[] args) {
//        stressTest();
//    }

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        int target = sc.nextInt();
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        final long result = countSensorsOptimal(arr, target);
        System.out.println(result);
    }

}
