package yym.svydovets.algorythm.task.strings;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class GenerateAllBinary {

  public static void main(String[] args) {
    var s = "1??0";
    print(s.toCharArray(), 0);
  }

  /*
  Given a string containing of ‘0’, ‘1’ and ‘?’ wildcard characters,
  generate all binary strings that can be formed
  by replacing each wildcard character by ‘0’ or ‘1’.

  Input: s = "1??0?101"
  Output: 10000101, 10001101, 10100101, 10101101, 11000101, 11001101,
  11100101, 11101101
  https://www.geeksforgeeks.org/generate-all-binary-strings-from-given-pattern/
   */
  static void print(char[] str, int idx) {
    if (idx == str.length) {
      System.out.println(str);
      return;
    }
    if (str[idx] == '?') {
      str[idx] = '0';
      print(str, idx + 1);

      str[idx] = '1';
      print(str, idx + 1);

      str[idx] = '?';
    } else {
      print(str, idx + 1);
    }
  }

}
