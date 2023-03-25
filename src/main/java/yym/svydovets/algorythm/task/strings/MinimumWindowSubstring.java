package yym.svydovets.algorythm.task.strings;

import java.util.HashMap;
import java.util.Map;

public class MinimumWindowSubstring {

  public static void main(String[] args) {
    var s = "ADOBECODEBANC";
    var t = "ABC";

    System.out.println(minWindow(s, t));
  }

  /*
   * Hard
   * Given two strings s and t of lengths m and n respectively,
   * return the minimum window substring of s such
   * that every character in t (including duplicates)
   * is included in the window.
   * If there is no such substring, return the empty string "".
   *
   * Input: s = "ADOBECODEBANC", t = "ABC"
   * Output: "BANC"
   * Explanation: The minimum window substring "BANC" includes 'A', 'B', and 'C' from string t.
   */
  static String minWindow(String s, String t) {
    Map<Character, Integer> charToFreqMap = new HashMap<>();

    for (char ch : t.toCharArray()) {
      charToFreqMap.put(ch, charToFreqMap.getOrDefault(ch, 0) + 1);
    }

    int matched = 0;
    int leftPointer = 0, rightPointer = 0;
    int minWindowLength = Integer.MAX_VALUE;
    int beginMinWindowIndex = 0;

    while (rightPointer < s.length()) {
      char curChar = s.charAt(rightPointer);
      if (charToFreqMap.containsKey(curChar)) {
        int requiredCharAmount = charToFreqMap.get(curChar) - 1;
        charToFreqMap.put(curChar, requiredCharAmount);
        if (requiredCharAmount == 0) {
          matched++;
        }
      }

      while (matched == charToFreqMap.size()) {
        int curWindowSize = rightPointer - leftPointer + 1;
        if (curWindowSize < minWindowLength) {
          minWindowLength = curWindowSize;
          beginMinWindowIndex = leftPointer;
        }
        char charToSlide = s.charAt(leftPointer);
        if (charToFreqMap.containsKey(charToSlide)) {
          if (charToFreqMap.get(charToSlide) == 0) {
            matched--;
          }
          charToFreqMap.put(charToSlide, charToFreqMap.get(charToSlide) + 1);
        }
        leftPointer++;
      }

      rightPointer++;
    }
    return minWindowLength > s.length() ? "" : s.substring(beginMinWindowIndex, beginMinWindowIndex + minWindowLength);
  }

}
