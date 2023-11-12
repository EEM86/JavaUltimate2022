package yym.svydovets.algorithm.task.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestStringWithoutRepeatingCharsTest {

  @Test
  void testLengthOfLongestSubstring_v1() {
    String input = "abcabcbb";
    int expected = 3;

    int actual = LongestStringWithoutRepeatingChars.lengthOfLongestSubstring(input);

    assertEquals(expected, actual);
  }

  @Test
  void testLengthOfLongestSubstring_v2() {
    String input = "pwwkepw";
    int expected = 4;

    int actual = LongestStringWithoutRepeatingChars.lengthOfLongestSubstring(input);

    assertEquals(expected, actual);
  }

  @Test
  void testLengthOfLongestSubstring_v3() {
    String input = "pwwkew";
    int expected = 3;

    int actual = LongestStringWithoutRepeatingChars.lengthOfLongestSubstring(input);

    assertEquals(expected, actual);
  }

  @Test
  void testLengthOfLongestSubstring_v4() {
    String input = "bbbbb";
    int expected = 1;

    int actual = LongestStringWithoutRepeatingChars.lengthOfLongestSubstring(input);

    assertEquals(expected, actual);
  }

}