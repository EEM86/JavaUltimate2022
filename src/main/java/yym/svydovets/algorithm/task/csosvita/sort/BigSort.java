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
import org.apache.commons.lang3.NotImplementedException;

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
            throw new NotImplementedException();
        }
    }

}
