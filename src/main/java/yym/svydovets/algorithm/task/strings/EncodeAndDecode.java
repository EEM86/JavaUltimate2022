package yym.svydovets.algorithm.task.strings;

import java.util.ArrayList;
import java.util.List;

public class EncodeAndDecode {

  /*
  Only subscription needed
  https://leetcode.com/problems/encode-and-decode-strings/
   */
  public static void main(String[] args) {
    var encoded = encode(List.of("hello", "f3"));
    var decoded = decode("5#hello");

    System.out.println(encoded);
    decoded.forEach(System.out::println);
  }

  static String encode(List<String> strs) {
    StringBuilder encodedString = new StringBuilder();
    for (String str : strs) {
      encodedString.append(str.length()).append("#").append(str);
    }
    return encodedString.toString();
  }

  static List<String> decode(String str) {
    List<String> list = new ArrayList<>();
    int i = 0;
    while (i < str.length()) {
      int j = i;
      while (str.charAt(j) != '#') j++;

      int length = Integer.valueOf(str.substring(i, j));
      i = j + 1 + length;
      list.add(str.substring(j + 1, i));
    }
    return list;
  }

}
