package yym.svydovets.algorythm.task.strings;

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
    final List<List<String>> res = groupAnagramsSiteOptimal(list);
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
    if (s.length() == 0 || t.length() == 0) return false;
    if (s.length() != t.length()) return false;
    for (int i = 0; i < s.length(); i++) {
      if (!t.contains(String.valueOf(s.charAt(i)))) {
        return false;
      }
    }
    return true;
  }

  static boolean isAnagramWithoutStringMethod(String s, String t) {
    if (s.length() == 0 || t.length() == 0) return false;
    if (s.length() != t.length()) return false;

    int[] letters = new int[26];
    for (var ch : s.toCharArray()) {
      letters[ch - 'a']++;
    }
    for (var ch : t.toCharArray()) {
      letters[ch - 'a']--;
    }

    for (var el : letters) {
      if (el != 0) {
        return false;
      }
    }
    return true;
  }

  /*
  Given an array of strings strs, group the anagrams together. You can return the answer in any order.
  Example:
  Input: strs = ["eat","tea","tan","ate","nat","bat"]    ; ["a"]
  Output: [["bat"],["nat","tan"],["ate","eat","tea"]]    ; [["a"]]
  https://leetcode.com/problems/group-anagrams/
  */
  static List<List<String>> groupAnagrams(String[] strs) {
    var charSize = 26;
    var result = new HashMap<String, List<String>>();
    for (int i = 0; i < strs.length; i++) {
      var count = new int[charSize];
      for (char ch : strs[i].toCharArray()) {
        count[ch - 'a']++;
      }
      var sb = new StringBuilder();
      for (int j = 0; j < charSize; j++) {
        sb.append("#");
        sb.append(count[j]);
      }
      final String key = sb.toString();
      if (!result.containsKey(key)) {
        result.put(key, new ArrayList<>());
      }
      result.get(key).add(strs[i]);
    }
    return new ArrayList<>(result.values());
  }

  static List<List<String>> groupAnagramsSiteOptimal(String[] strs) {
    if (strs == null || strs.length == 0) return new ArrayList<>();
    Map<String, List<String>> map = new HashMap<>();
    for (String s : strs) {
      char[] ca = new char[26]; //array of characters
      for (char c : s.toCharArray()) ca[c - 'a']++;
      // char array with letter-index with count of apperance
      String keyStr = String.valueOf(ca);
      // key's order of letter won't matter
      if (!map.containsKey(keyStr)) map.put(keyStr, new ArrayList<>());
      map.get(keyStr).add(s);
      // get the key and add string to its value (list)
    }
    return new ArrayList<>(map.values());
    // return map's collection view of VALUES(Lists) in arraylist
  }   // List cannot be instantiated

  private boolean equalsSorted(String str, String str1) {
    final String sortedFirst = str.chars()
        .boxed()
        .map(Character::toString)
        .sorted()
        .collect(Collectors.joining());
    final String sortedSecond = str1.chars()
        .boxed()
        .map(Character::toString)
        .sorted()
        .collect(Collectors.joining());
    return sortedFirst.equals(sortedSecond);
  }

  static boolean isAnagramMap(String s, String t) {
    if (s.length() == 0 || t.length() == 0) return false;
    final Map<Character, Long> sMap = s.chars()
        .mapToObj(c -> (char) c)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));
    final Map<Character, Long> tMap = t.chars()
        .mapToObj(c -> (char) c)
        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

    return sMap.equals(tMap);
  }

  static boolean isAnagramSiteOptimal(String s, String t) {
    if (s.length() != t.length()) return false;

    int[] count = new int[26]; //english alphabet?

    for (char c : s.toCharArray()) {
      count[c - 'a']++;
    }

    for (char c : t.toCharArray()) {
      count[c - 'a']--;
    }

    for (int i = 0; i < count.length; i++) {
      if (count[i] != 0){
        return false;
      }
    }

    return true;
  }

}
