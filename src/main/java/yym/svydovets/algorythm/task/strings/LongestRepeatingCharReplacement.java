package yym.svydovets.algorythm.task.strings;

public class LongestRepeatingCharReplacement {

  public static void main(String[] args) {
    var first = new int[]{1,1,0,0};
    var second = new int[]{1,1,0,0};
    System.out.println(first == second);


  }

  /*
  You are given a string s and an integer k. You can choose any character of the string and change it to any other uppercase English character.
  You can perform this operation at most k times.
  Return the length of the longest substring containing the same letter you can get after performing the above operations.
  Example 1:
  Input: s = "ABAB", k = 2
  Output: 4
  Explanation: Replace the two 'A's with two 'B's or vice versa.
  https://leetcode.com/problems/longest-repeating-character-replacement/
   */
  static int characterReplacement(String s, int k) {
    int[] arr = new int[26];
    int ans = 0;
    int max = 0;
    int i = 0;
    for (int j = 0; j < s.length(); j++) {
      arr[s.charAt(j) - 'A']++;
      max = Math.max(max, arr[s.charAt(j) - 'A']);
      if (j - i + 1 - max > k) {
        arr[s.charAt(i) - 'A']--;
        i++;
      }
      ans = Math.max(ans, j - i + 1);
    }
    return ans;
  }

  static int characterReplacementOptimal(String s, int k) {

    int start = 0;
    int[] count = new int[26];
    int len = s.length();
    int maxCount = 0;
    int maxLen = 0;

    for (int end = 0; end < len; end++) {
      maxCount = Math.max(maxCount, ++count[s.charAt(end) - 'A']);

      while ((end - start + 1) - maxCount > k) {
        count[s.charAt(start) - 'A']--;
        start++;
      }

      maxLen = Math.max(maxLen, (end - start) + 1);
    }

    return maxLen;
  }

}
