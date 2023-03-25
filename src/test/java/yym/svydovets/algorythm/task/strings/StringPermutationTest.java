package yym.svydovets.algorythm.task.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static yym.svydovets.algorythm.task.strings.StringPermutation.checkInclusion;

class StringPermutationTest {

  @Test
  void testPermutation_v1() {
    String first = "ab";
    String second = "eidbaooo";

    boolean isPermutationIncluded = checkInclusion(first, second);

    assertTrue(isPermutationIncluded);
  }

  @Test
  void testPermutation_v2() {
    String first = "ab";
    String second = "eidboaoo";

    boolean isPermutationIncluded = checkInclusion(first, second);

    assertFalse(isPermutationIncluded);
  }

}