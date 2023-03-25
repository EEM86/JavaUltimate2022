package yym.svydovets.algorythm.task.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static yym.svydovets.algorythm.task.strings.MinimumWindowSubstring.minWindow;

class MinimumWindowSubstringTest {

  @Test
  void testMinWindow_v1() {
    var input = "ADOBECODEBANC";
    var substr = "ABC";

    var expected = "BANC";

    var actual = minWindow(input, substr);

    assertEquals(expected, actual);
  }

  @Test
  void testMinWindow_v2() {
    var input = "a";
    var substr = "a";

    var expected = "a";

    var actual = minWindow(input, substr);

    assertEquals(expected, actual);
  }

  @Test
  void testMinWindow_v3() {
    var input = "a";
    var substr = "aa";

    var actual = minWindow(input, substr);

    assertTrue(actual.isEmpty());
  }

}