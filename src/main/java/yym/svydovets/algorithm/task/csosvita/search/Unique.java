package yym.svydovets.algorithm.task.csosvita.search;

import java.util.HashSet;
import java.util.Scanner;

public class Unique {

    /*
     * Given a string s, find the length of the longest substring without repeating characters.
     * A substring is a contiguous non-empty sequence of characters within a string.
     *
     * 0 <= s.length <= 5 * 10^4
     * s consists of English letters, digits, symbols and spaces.
     *
     * Sample Input 0:
     * abcabcbb
     * Sample Output 0:
     * 3
     */
    public static int unique(String s) {
        int max = 0;
        var set = new HashSet<Character>();

        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            while (!set.add(s.charAt(r))) {
                set.remove(s.charAt(l++));
            }
            max = Math.max(max, set.size());
        }

        return max;
    }

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        final String s = sc.next();
        final int result = unique(s);
        System.out.println(result);
    }

}
