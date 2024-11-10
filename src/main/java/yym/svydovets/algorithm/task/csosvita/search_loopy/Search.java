package yym.svydovets.algorithm.task.csosvita.search_loopy;

import java.util.Scanner;

class Search {

    /*
     * Given a sorted array in non-decreasing order with repeating integers.
     * Find the first occurrence, last occurrence and count of a given key in the array.
     *
     * Your algorithm should run in O(log N) time. If element is not present print -1 -1 0
     * N <= 1000_000
     * First line contains N, then N integers, then key
     *
     * Sample Input 0:
     * 6
     * 1 2 2 2 3 4
     * 2
     *
     * Sample Output 0:
     * 1 3 3
     */
    public static String search(int[] arr, int key) {
        int firstOccurrence = findFirstKey(arr, key);
        int lastOccurrence = findLastKey(arr, key);
        int totalKeys = firstOccurrence == -1 ? 0 : lastOccurrence - firstOccurrence + 1;
        return String.format("%d %d %d", firstOccurrence, lastOccurrence, totalKeys);
    }

    private static int findFirstKey(int[] arr, int key) {
        int bad = -1;
        int good = arr.length;

        while (good - bad > 1) {
            int m = (bad + good) / 2;
            if (arr[m] >= key) {
                good = m;
            } else {
                bad = m;
            }
        }
        if (good == arr.length || arr[good] != key) {
            good = -1;
        }
        return good;
    }

    private static int findLastKey(int[] arr, int key) {
        int bad = -1;
        int good = arr.length;

        while (good - bad > 1) {
            int m = (bad + good) / 2;
            if (arr[m] > key) {
                good = m;
            } else {
                bad = m;
            }
        }
        if (bad == arr.length - 1 || arr[bad] != key) {
            bad = -1;
        }
        return bad;
    }

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int key = sc.nextInt();
        final String result = search(arr, key);
        System.out.println(result);
    }

}
