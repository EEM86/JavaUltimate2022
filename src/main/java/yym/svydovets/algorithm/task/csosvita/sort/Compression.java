package yym.svydovets.algorithm.task.csosvita.sort;

import java.util.Random;
import java.util.Scanner;

public class Compression {

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        String s = sc.next();

        final String result = compress(s);
        System.out.println(result);
    }

    /*
     * You are given a string consisting of uppercase letters A-Z.
     * Your task is to write a function that performs Run-length encoding (RLE)
     * on the input string and returns a compressed version of the string.
     * Input Format
     * A single line containing the string, which may include uppercase letters (A-Z)
     * 1 <= s.length <= 10000
     * Sample Input 0
     * AABBBCCCC
     * Sample Output 0
     * A2B3C4
     */
    public static String compress(String s) {
        var sb = new StringBuilder();
        int l = 0, r = 0;
        while (r < s.length()) {
            if (s.charAt(r) != s.charAt(l)) {
                sb.append(s.charAt(l)).append(r-l);
                l = r;
            }
            r++;
        }
        sb.append(s.charAt(l)).append(r-l);

        return sb.toString();
    }

    public static String compressNotPass(String s) {
        int[] letters = new int[26];
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            letters[curChar - 'A']++;
        }

        var sb = new StringBuilder();
        for (int i = 0; i < letters.length; i++) {
            if (letters[i] != 0) {
                int curChar = i + 'A';
                char ch = (char) curChar;
                sb.append(ch).append(letters[i]);
            }
        }
        return sb.toString();
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
        int rSize = random.nextInt(10) + 1; // size up to 10


        // Create and fill array with random chars
        var sb = new StringBuilder();
        for (int i = 0; i < rSize; i++) {
            char first = 'A';
            int n = random.nextInt(first,first + 26);  // A-Z
            char ch = (char) n;
            sb.append(ch);
        }


        if (!compress(sb.toString()).equals(compressNotPass(sb.toString()))) {
            System.out.println("String: " + sb);
            System.out.println("First result: " + compress(sb.toString()));
            System.out.println("Second result: " + compressNotPass(sb.toString()));
            throw new RuntimeException("Found a bug!");
        }
    }

}
