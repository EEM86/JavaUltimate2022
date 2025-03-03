package yym.svydovets.algorithm.task.csosvita.sort;

import java.util.HashSet;
import java.util.Scanner;
import org.apache.commons.lang3.NotImplementedException;

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
        throw new NotImplementedException();
    }

    /*
     * The same impl using data structure
     */
    public static int longestSubstringWithDataStructure(String s) {
        throw new NotImplementedException();
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
            throw new NotImplementedException();
        }

        void add(char ch) {
            throw new NotImplementedException();
        }

        void remove(char ch) {
            throw new NotImplementedException();
        }
    }

}
