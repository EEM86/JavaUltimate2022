package yym.svydovets.algorythm.task.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static yym.svydovets.algorythm.task.strings.LongestRepeatingCharReplacement.characterReplacement;

class LongestRepeatingCharReplacementTest {

  @Test
  void testCharacterReplacement_v1() {
    String input = "ABAB";
    int changesAmount = 2;

    int expected = 4;

    int actual = characterReplacement(input, changesAmount);

    assertEquals(expected, actual);
  }

  @Test
  void testCharacterReplacement_v2() {
    String input = "AABABBA";
    int changesAmount = 1;

    int expected = 4;

    int actual = characterReplacement(input, changesAmount);

    assertEquals(expected, actual);
  }

}