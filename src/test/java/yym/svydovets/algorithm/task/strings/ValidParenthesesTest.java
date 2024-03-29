package yym.svydovets.algorithm.task.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class ValidParenthesesTest {

  @Test
  void testIsValid_v1() {
    String input = "()";

    var isValid = ValidParentheses.isValid(input);

    assertTrue(isValid);
  }

  @Test
  void testIsValid_v2() {
    String input = "()[]{}";

    var isValid = ValidParentheses.isValid(input);

    assertTrue(isValid);
  }

  @Test
  void testIsValid_v3() {
    String input = "(]";

    var isValid = ValidParentheses.isValid(input);

    assertFalse(isValid);
  }

  @Test
  void testIsValid_v4() {
    String input = "{[]}";

    var isValid = ValidParentheses.isValid(input);

    assertTrue(isValid);
  }

  @Test
  void testIsValid_v5() {
    String input = "({[)";

    var isValid = ValidParentheses.isValid(input);

    assertFalse(isValid);
  }

}