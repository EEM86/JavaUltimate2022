package yym.svydovets.dataStructure.task.strings;

import org.apache.commons.lang3.NotImplementedException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Anagram {

  public static void main(String[] args) {
    var s = "anagram";
    var t = "nagaram";
//    System.out.println(isAnagramSiteOptimal(s, t));


    var list = new String[]{"bdddddddddd","bbbbbbbbbbc"};
    final List<List<String>> res = groupAnagrams(list);
    Stream.of(res).flatMap(List::stream).forEach(System.out::println);
  }

  /*
  Given two strings s and t, return true if t is an anagram of s, and false otherwise.
  An Anagram is a word or phrase formed by rearranging the letters of a different word or phrase,
  typically using all the original letters exactly once.

  Input: s = "anagram", t = "nagaram"  ; "aacc" : "ccac"
  Output: true
  https://leetcode.com/problems/valid-anagram/
   */
  static boolean isAnagram(String s, String t) {
    throw new NotImplementedException();
  }

  /*
  Given an array of strings strs, group the anagrams together. You can return the answer in any order.
  Example:
  Input: strs = ["eat","tea","tan","ate","nat","bat"]    ; ["a"]
  Output: [["bat"],["nat","tan"],["ate","eat","tea"]]    ; [["a"]]
  https://leetcode.com/problems/group-anagrams/
  */
  static List<List<String>> groupAnagrams(String[] strs) {
    throw new NotImplementedException();
  }

}
