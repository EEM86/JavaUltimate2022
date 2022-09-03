package yym.svydovets.dataStructure.task.strings;

import org.apache.commons.lang3.NotImplementedException;

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
    throw new NotImplementedException();
  }

  static List<String> decode(String str) {
    throw new NotImplementedException();
  }

}
