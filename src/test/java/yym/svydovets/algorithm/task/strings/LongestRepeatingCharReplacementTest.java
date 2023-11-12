package yym.svydovets.algorithm.task.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class LongestRepeatingCharReplacementTest {

  @Test
  void testCharacterReplacement_v1() {
    String input = "ABAB";
    int changesAmount = 2;

    int expected = 4;

    int actual = LongestRepeatingCharReplacement.characterReplacement(input, changesAmount);

    assertEquals(expected, actual);
  }

  @Test
  void testCharacterReplacement_v2() {
    String input = "AABABBA";
    int changesAmount = 1;

    int expected = 4;

    int actual = LongestRepeatingCharReplacement.characterReplacement(input, changesAmount);

    assertEquals(expected, actual);
  }

}