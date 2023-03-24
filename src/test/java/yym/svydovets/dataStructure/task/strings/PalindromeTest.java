package yym.svydovets.dataStructure.task.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PalindromeTest {

  @Test
  void testIsPalindrome_v1() {
    var input = "A man, a plan, a canal: Panama";

    var isPalindrome = Palindrome.isPalindrome(input);

    assertTrue(isPalindrome);
  }

  @Test
  void testIsPalindrome_v2() {
    var input = "0P";

    var isPalindrome = Palindrome.isPalindrome(input);

    assertFalse(isPalindrome);
  }

  @Test
  void testIsPalindrome_v3() {
    var input = "race a car";

    var isPalindrome = Palindrome.isPalindrome(input);

    assertFalse(isPalindrome);
  }

  @Test
  void testIsPalindrome_v4() {
    var input = " ";

    var isPalindrome = Palindrome.isPalindrome(input);

    assertTrue(isPalindrome);
  }


}