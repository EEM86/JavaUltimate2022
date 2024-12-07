package yym.svydovets.algorithm.task.strings;

import java.util.Arrays;

public class StringPermutation {

  public static void main(String[] args) {
    String s1 = "abc", s2 = "bbbca";
    System.out.println(checkInclusion(s1, s2));
  }

  /*
  Given two strings s1 and s2, return true if s2 contains a permutation of s1, or false otherwise.
  In other words, return true if one of s1's permutations is the substring of s2.

  Example 1:
  Input: s1 = "ab", s2 = "eidbaooo"
  Output: true
  Explanation: s2 contains one permutation of s1 ("ba").
  https://leetcode.com/problems/permutation-in-string/
   */
  static boolean checkInclusion(String s1, String s2) {
    if (s2.length() < s1.length()) return false;
    int[] s2Count = new int[26];
    int[] s1Count = new int[26];
    int windowSize = s1.length();

    for (int i = 0; i < windowSize; i++) {
      s1Count[s1.charAt(i) - 'a']++;
      s2Count[s2.charAt(i) - 'a']++;
    }

    int matches = 0;
    for (int i = 0; i < 26; i++) {
      if (s2Count[i] == s1Count[i]) {
        matches++;
      }
    }

    int l = 0, r = windowSize;

    while (r < s2.length()) {
      if (matches == 26) return true;
      var leftChar = s2.charAt(l);
      var rightChar = s2.charAt(r);
      var index = rightChar - 'a';
      s2Count[index]++;
      if (s1Count[index] == s2Count[index]) {
        matches++;
      } else if (s1Count[index] + 1 == s2Count[index]) {
        matches--;
      }

      index = leftChar - 'a';
      s2Count[index]--;
      if (s1Count[index] == s2Count[index]) {
        matches++;
      } else if (s1Count[index]-1 == s2Count[index]){
        matches--;
      }
      l++;
      r++;
    }
    return matches == 26;
  }

}
