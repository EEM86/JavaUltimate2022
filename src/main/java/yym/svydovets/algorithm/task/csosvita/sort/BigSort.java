package yym.svydovets.algorithm.task.csosvita.sort;

import static java.util.stream.Collectors.joining;
import static java.util.stream.Collectors.toList;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class BigSort {

    public static class Result {
        /* Consider an array of numeric strings where each string is a positive number
         * with anywhere from to digits. Sort the array's elements in non-decreasing,
         * or ascending order of their integer values and return the sorted array.
         *
         * 1 <= n <= 2 * 10^5
         * Each string is guaranteed to represent a positive integer.
         * There will be no leading zeros.
         * The total number of digits across all strings in unsorted is between 1 and 10^6 (inclusive).
         *
         * Sample Input: ["1", "200", "150", "3"]
         * Sample Output: ["1", "3", "150", "200"]
         */
        public static List<String> bigSorting(List<String> unsorted) {
            String[] aux = new String[unsorted.size() / 2];
            mergeSortWithAux(unsorted, aux, 0, unsorted.size());
            return unsorted;
        }

        private static void mergeSortWithAux(List<String> unsorted, String[] aux, int l, int r) {
            if (r - l <= 1) {
                return;
            }
            int mid = (l + r) / 2;
            mergeSortWithAux(unsorted, aux, l, mid);
            mergeSortWithAux(unsorted, aux, mid, r);

            merge(unsorted, aux, l, mid, r);
        }

        private static void merge(List<String> unsorted, String[] aux, int l, int m, int r) {
            int x = 0;
            for (int i = l; i < m; i++) {
                aux[x++] = unsorted.get(i);
            }

            int i = 0, n = m - l;
            int k = l, j = m;

            while (i < n || j < r) {
                if (j == r || (i < n && less(aux[i], unsorted.get(j)))) {
                    unsorted.set(k++, aux[i++]);
                } else {
                    unsorted.set(k++, unsorted.get(j++));
                }
            }
        }

        private static boolean less(String left, String right) {
            if (left.length() < right.length()) {
                return true;
            } else if (left.length() > right.length()) {
                return false;
            }
            for (int i = 0; i < left.length(); i++) {
                if (left.charAt(i) != right.charAt(i)) {
                    return left.charAt(i) < right.charAt(i);
                }
            }
            return false;
        }

        private static void mergeSort(List<String> elements) {
            var n = elements.size();

            if (n <= 1) {
                return;
            }

            var left = new ArrayList<>(elements.subList(0, n/2));
            var right = new ArrayList<>(elements.subList(n/2, n));

            mergeSort(left);
            mergeSort(right);

            merge(elements, left, right);
        }

        private static void merge(List<String> elements, List<String> left, List<String> right) {
            int leftIdx = 0, rightIdx = 0;

            while (leftIdx < left.size() && rightIdx < right.size()) {
                if (isLeftSmaller(left.get(leftIdx), right.get(rightIdx))) {
                    elements.set(leftIdx + rightIdx, left.get(leftIdx++));
                } else {
                    elements.set(leftIdx + rightIdx, right.get(rightIdx++));
                }
            }

            while (leftIdx < left.size()) {
                elements.set(leftIdx + rightIdx, left.get(leftIdx++));
            }

            while (rightIdx < right.size()) {
                elements.set(leftIdx + rightIdx, right.get(rightIdx++));
            }
        }

        private static boolean isLeftSmaller(String l, String r) {
            if (r.length() > l.length()) {
                return true;
            }
            if (r.length() < l.length()) {
                return false;
            }
            for (int i = 0; i < r.length(); i++) {
                if (l.charAt(i) != r.charAt(i)) {
                    return l.charAt(i) < r.charAt(i);
                }
            }
            return false;
        }
    }

}
