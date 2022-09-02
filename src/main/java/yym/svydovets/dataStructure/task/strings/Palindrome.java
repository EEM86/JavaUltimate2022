package yym.svydovets.dataStructure.task.strings;

public class Palindrome {

  public static void main(String[] args) {
    var s = "ab_a";
    System.out.println(isPalindrome(s));
  }

  /*
  A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all
  non-alphanumeric characters, it reads the same forward and backward. Alphanumeric characters include letters and numbers.

  Given a string s, return true if it is a palindrome, or false otherwise.
  Example 1:
  Input: s = "A man, a plan, a canal: Panama" ; ab_a
  Output: true
  Explanation: "amanaplanacanalpanama" is a palindrome
  https://leetcode.com/problems/valid-palindrome/
   */
  static boolean isPalindrome(String s) {
    var replaced = s.replaceAll("[^A-Za-z0-9]", "").toLowerCase();
    var n = replaced.length();
    for (int i = 0; i < replaced.length() / 2; i++) {
      if (replaced.charAt(i) != replaced.charAt(n - i - 1)) return false;
    }
    return true;
  }

  static boolean isPalindromeSite(String s) {
    int i = 0;
    int j = s.length() - 1;
    while (i < j) {
      var start = s.charAt(i);
      var end = s.charAt(j);
      if (!Character.isLetterOrDigit(start)) {
        i++;
        continue;
      }
      if (!Character.isLetterOrDigit(end)) {
        j--;
        continue;
      }
      if (Character.toLowerCase(start) != Character.toLowerCase(end)) {
        return false;
      }
      i++;
      j--;
    }
    return true;
  }

}
