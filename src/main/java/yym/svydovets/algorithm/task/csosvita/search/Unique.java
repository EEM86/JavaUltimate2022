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

    public static int longestSubstringWithDataStructure(String s) {
        var cnt = new ItemCnt();
        int res = 0;
        int l = 0;
        for (int r = 0; r < s.length(); r++) {
            cnt.add(s.charAt(r));
            while (!cnt.isGood()) {
                cnt.remove(s.charAt(l++));
            }
            res = Math.max(res, r - l + 1);
        }
        return res;
    }

    private static class ItemCnt {
        int[] dict = new int[128];
        int uniqueCnt;
        int totalCnt;

        public ItemCnt() {};

        public ItemCnt(int[] d, int u, int t) {
            this.dict = d;
            this.uniqueCnt = u;
            this.totalCnt = t;
        }

        boolean isGood() {
            return uniqueCnt == totalCnt;
        }

        void add(char ch) {
            dict[ch]++;
            totalCnt++;
            if (dict[ch] == 1) {
                uniqueCnt++;
            }
        }

        void remove(char ch) {
            dict[ch]--;
            totalCnt--;
            if (dict[ch] == 0) {
                uniqueCnt--;
            }
        }
    }

}
