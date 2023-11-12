package yym.svydovets.algorithm.task.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class StringPermutationTest {

  @Test
  void testPermutation_v1() {
    String first = "ab";
    String second = "eidbaooo";

    boolean isPermutationIncluded = StringPermutation.checkInclusion(first, second);

    assertTrue(isPermutationIncluded);
  }

  @Test
  void testPermutation_v2() {
    String first = "ab";
    String second = "eidboaoo";

    boolean isPermutationIncluded = StringPermutation.checkInclusion(first, second);

    assertFalse(isPermutationIncluded);
  }

}