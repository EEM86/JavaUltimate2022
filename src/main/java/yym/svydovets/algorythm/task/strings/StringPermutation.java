package yym.svydovets.algorythm.task.strings;

import java.util.Arrays;

public class StringPermutation {

  public static void main(String[] args) {
    String s1 = "ab", s2 = "eidbaooo";
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
    if (s1.length() > s2.length()) return false;

    var arr = new int[26];

    // fill the array for the s1: [1, 1, 0, 0, 0, ... , 0]
    for (int i = 0; i < s1.length(); i++) {
      arr[s1.charAt(i) - 'a']++;
    }

    int i = 0;
    int j = 0;
    //point j to it's position
    for (; j < s1.length(); j++) {
      arr[s2.charAt(j) - 'a']--;
    }
    j--;
    if (isEmpty(arr)) return true;
    while (j < s2.length()) {
      arr[s2.charAt(i) - 'a']++;
      i++;
      j++;
      if (j < s2.length()) arr[s2.charAt(j) - 'a']--;
      if (isEmpty(arr)) return true;
    }
    return isEmpty(arr);
  }

  private static boolean isEmpty(int[] arr) {
    return Arrays.stream(arr).noneMatch(i -> i != 0);
  }

  static boolean checkInclusionOptimal(String s1, String s2) {
    if (s1.length() > s2.length()) return false;

    int[] s1map = new int[26];
    int[] s2map = new int[26];

    for (int i = 0; i < s1.length(); i++) {
      s1map[s1.charAt(i) - 'a']++;
      s2map[s2.charAt(i) - 'a']++;
    }

    for (int i = 0; i < s2.length() - s1.length(); i++) {
      if (matches(s1map, s2map)) return true;
      s2map[s2.charAt(i + s1.length()) - 'a']++;
      s2map[s2.charAt(i) - 'a']--;
    }
    return matches(s1map, s2map);
  }

  static boolean matches(int[] s1map, int[] s2map) {
    for (int i = 0; i < 26; i++) {
      if (s1map[i] != s2map[i])
        return false;
    }
    return true;
  }

}
