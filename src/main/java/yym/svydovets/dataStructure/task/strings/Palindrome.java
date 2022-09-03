package yym.svydovets.dataStructure.task.strings;

import org.apache.commons.lang3.NotImplementedException;

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
    throw new NotImplementedException();
  }

}
