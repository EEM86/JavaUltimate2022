package yym.svydovets.dataStructure.task.strings;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

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

}