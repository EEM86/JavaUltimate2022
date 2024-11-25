package yym.svydovets.algorithm.task.csosvita.search;

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

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = Integer.parseInt(bufferedReader.readLine().trim());

        List<String> unsorted = IntStream.range(0, n).mapToObj(i -> {
                try {
                    return bufferedReader.readLine();
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            })
            .collect(toList());

        List<String> result = Result.bigSorting(unsorted);

        bufferedWriter.write(
            result.stream()
                .collect(joining("\n"))
                + "\n"
        );

        bufferedReader.close();
        bufferedWriter.close();
    }

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
            mergeSort(unsorted);
            return unsorted;
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
            } else if (r.length() == l.length()) {
                for (int i = 0; i < r.length(); i++) {
                    if (l.charAt(i) != r.charAt(i)) {
                        if (l.charAt(i) < r.charAt(i)) {
                            return true;
                        } else {
                            return false;
                        }
                    }
                }
                return false;
            } else {
                return false;
            }
        }
    }

}
