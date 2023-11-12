package yym.svydovets.algorithm.task.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class MinimumWindowSubstringTest {

  @Test
  void testMinWindow_v1() {
    var input = "ADOBECODEBANC";
    var substr = "ABC";

    var expected = "BANC";

    var actual = MinimumWindowSubstring.minWindow(input, substr);

    assertEquals(expected, actual);
  }

  @Test
  void testMinWindow_v2() {
    var input = "a";
    var substr = "a";

    var expected = "a";

    var actual = MinimumWindowSubstring.minWindow(input, substr);

    assertEquals(expected, actual);
  }

  @Test
  void testMinWindow_v3() {
    var input = "a";
    var substr = "aa";

    var actual = MinimumWindowSubstring.minWindow(input, substr);

    assertTrue(actual.isEmpty());
  }

  @Test
  void testMinWindow_v4() {
    var input = "aa";
    var substr = "aa";

    var expected = "aa";

    var actual = MinimumWindowSubstring.minWindow(input, substr);

    assertEquals(expected, actual);
  }

}