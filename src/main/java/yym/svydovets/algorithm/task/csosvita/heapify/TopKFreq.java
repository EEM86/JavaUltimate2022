package yym.svydovets.algorithm.task.csosvita.heapify;

import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.Scanner;
import java.util.Set;

public class TopKFreq {

    /*
     * You are given a string of length N. The string consists of lowercase english alphabets only i.e. a to z.
     * You are also given an integer K.
     * You need to find the Kth most frequent alphabet in the string.
     * If more than one alphabet share the Kth frequency, you need to find
     * the lexicographically smallest alphabet among them.
     * In case no Kth most popular alphabet exists, you need to print NONE.
     *
     * Input Format:
     * The first line - number of test cases in the input
     * Each test case contains 2 lines
     * The first line N and K for the test case, the second line is a string
     *
     * 1 <= T <= 100
     * 1 <= N <= 100000
     * 1 <= K <= N
     *
     * Sample Input 0:
     * 4
     * 6 3
     * aaabbc
     * 5 1
     * aaabb
     * 8 3
     * aaabbbcc
     * 5 2
     * aabcd
     *
     * Sample Output 0:
     * c        - the frequencies are a-3, b-2, c-1. The 3rd mose frequent is 'c'
     * a        - the frequencies are a-3, b-2, the first more frequent is 'a'
     * NONE     - both 'a' and 'b' have the highest frequency of 3, and 'c' has the second highest freq, not 3rd.
     * b        - 'b', 'c' and 'd' have the second highest frequency of 1. The lexicographically smallest is 'b'
     *
     *
     */
    public static String topKFreq(TopKHelper[] tasks) {
        var sb = new StringBuilder();
        for (int i = 0; i < tasks.length; i++) {
            sb.append(findTopK(tasks[i].s, tasks[i].k)).append("\n");
        }
        if (!sb.isEmpty()) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static String findTopK(String s, int k) {
        Map<Character, Integer> freqMap = new HashMap<>();
        for (var n : s.toCharArray()) {
            freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
        }

        PriorityQueue<Character> maxHeap = new PriorityQueue<>(Comparator.comparingInt(freqMap::get).reversed());
        Set<Integer> uniqueFreq = new HashSet<>();
        for (var el : freqMap.entrySet()) {
            if (!uniqueFreq.contains(el.getValue())) {
                uniqueFreq.add(el.getValue());
                maxHeap.add(el.getKey());
            }
        }
        for (int j = k - 1; j > 0 && !maxHeap.isEmpty(); j--) {
            maxHeap.poll();
        }
        if (maxHeap.isEmpty()) {
            return "NONE";
        } else {
            return String.valueOf(maxHeap.poll());
        }
    }

    public static class TopKHelper {
        String s;
        int k;
        int len;

        public TopKHelper(String s, int k, int len) {
            this.s = s;
            this.k = k;
            this.len = len;
        }

        public TopKHelper() {}
    }

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int lines = sc.nextInt();
        TopKHelper[] tasks = new TopKHelper[lines];
        for (int i = 0; i < lines; i++) {
            int stringLen = sc.nextInt();
            int k = sc.nextInt();
            String s = sc.next();
            tasks[i] = new TopKHelper(s, k, stringLen);
        }

        System.out.println(topKFreq(tasks));
    }

}
