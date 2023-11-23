package yym.svydovets.algorithm.task.dynamic;

public class LongestPalindromicSubstring {

  /* Medium
   * Given a string s, return the longest palindromic substring in s.
   *
   * Example 1:
   * Input: s = "babad"
   * Output: "bab"
   * Explanation: "aba" is also a valid answer.
   *
   * Example 2:
   * Input: s = "cbbd"
   * Output: "bb"
   *
   * Time complexity O(n^2)
   * Manacher's algorithm will solve this task with O(n)
   */
  public String longestPalindrome(String s) {
    if (s == null || s.isEmpty()) return "";

    int start = 0, end = 0;

    for (int i = 0; i < s.length(); i++) {
      int len = Math.max(expandFromCenter(i, s, i), expandFromCenter(i, s, i+1));
      if (len > end - start) {
        start = i - ((len - 1) / 2);
        end = i + (len / 2);
      }
    }
    return s.substring(start, end + 1);
  }

  private int expandFromCenter(int left, String s, int right) {
    if (s == null || left > right) return 0;

    while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
      left--;
      right++;
    }
    return right - left - 1;
  }

}
