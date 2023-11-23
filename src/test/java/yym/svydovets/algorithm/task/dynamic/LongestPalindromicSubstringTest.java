package yym.svydovets.algorithm.task.dynamic;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class LongestPalindromicSubstringTest {

  @Test
  void longestPalindrome_v1() {
    var service = new LongestPalindromicSubstring();
    String input = "babad";
    String expected_one = "bab";
    String expected_two = "aba";

    String actual = service.longestPalindrome(input);

    assertTrue(Set.of(expected_one, expected_two).contains(actual));
  }

  @Test
  void longestPalindrome_v2() {
    var service = new LongestPalindromicSubstring();
    String input = "cbbd";
    String expected = "bb";

    String actual = service.longestPalindrome(input);

    assertEquals(expected, actual);
  }
}