package yym.svydovets.algorythm.task.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static yym.svydovets.algorythm.task.strings.LongestStringWithoutRepeatingChars.lengthOfLongestSubstring;

class LongestStringWithoutRepeatingCharsTest {

  @Test
  void testLengthOfLongestSubstring_v1() {
    String input = "abcabcbb";
    int expected = 3;

    int actual = lengthOfLongestSubstring(input);

    assertEquals(expected, actual);
  }

  @Test
  void testLengthOfLongestSubstring_v2() {
    String input = "pwwkepw";
    int expected = 4;

    int actual = lengthOfLongestSubstring(input);

    assertEquals(expected, actual);
  }

  @Test
  void testLengthOfLongestSubstring_v3() {
    String input = "pwwkew";
    int expected = 3;

    int actual = lengthOfLongestSubstring(input);

    assertEquals(expected, actual);
  }

  @Test
  void testLengthOfLongestSubstring_v4() {
    String input = "bbbbb";
    int expected = 1;

    int actual = lengthOfLongestSubstring(input);

    assertEquals(expected, actual);
  }

}