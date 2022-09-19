package yym.svydovets.dataStructure.task.strings;

import java.util.HashMap;
import java.util.Stack;

public class ValidParentheses {

  public static void main(String[] args) {
    var s = "((";
    System.out.println(isValid(s));
  }

  static boolean isValid(String s) {
    if (s.length() % 2 != 0) return false;
    var stack = new Stack<Character>();
    for (int i = 0; i < s.length(); i++) {
      if (stack.isEmpty() && (s.charAt(i) == ')' || s.charAt(i) == '}' || s.charAt(i) == ']')) {
        return false;
      } else {
        if (!stack.isEmpty()) {
          if (stack.peek() == '(' && s.charAt(i) == ')') {
            stack.pop();
          } else if (stack.peek() == '{' && s.charAt(i) == '}') {
            stack.pop();
          } else if (stack.peek() == '[' && s.charAt(i) == ']') {
            stack.pop();
          } else {
            stack.add(s.charAt(i));
          }
        } else {
          stack.add(s.charAt(i));
        }
      }
    }
    return stack.isEmpty();
  }

}
