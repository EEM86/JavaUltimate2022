package yym.svydovets.algorithm.task.graphs;

import yym.svydovets.utils.Tuple;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class AlienDictionary {

  /* Hard
   * You are given a list of strings 'words' sorted lexicographically
   * by the rules of alien's language.
   * Return a sorted string of unique letters,
   * if there is no solution, return "", if multiple - any of them.
   *
   * Example:
   * Input: words = ["wrt", "wrf", "er", "ett", "rftt"]
   * Output: "wertf"
   */
  public String alienOrder(String[] words) {
    if (words == null || words.length == 0) return "";

    int[] captured = new int[26];
    var adjList = new HashMap<Character, List<Character>>();
    for (var word : words) {
      for (var ch : word.toCharArray()) {
        adjList.put(ch, new ArrayList<>());
      }
    }

    for (int i = 1; i < words.length; i++) {
      Tuple<Character, Character> difference = getDifference(words[i-1], words[i]);
      if (difference != null) {
        adjList.get(difference.getKey()).add(difference.getValue());
        captured[difference.getValue() - 'a']++;
      } else if (words[i - 1].length() > words[i].length()) {
        return "";
      }
    }

    var queue = new LinkedList<Character>();
    for (var ch : adjList.keySet()) {
      if (captured[ch - 'a'] == 0) {
        queue.add(ch);
      }
    }

    var sb = new StringBuilder(adjList.size());
    int counter = 0; // to check if there is cycle

    while (!queue.isEmpty()) {
      var ch = queue.poll();
      counter++;
      sb.append(ch);
      if (adjList.containsKey(ch)) {
        for (var neighbor : adjList.get(ch)) {
          if (--captured[neighbor - 'a'] == 0) {
            queue.add(neighbor);
          }
        }
      }
    }

    return counter == adjList.size() ? sb.toString() : "";
  }

  private Tuple<Character, Character> getDifference(String first, String second) {
    int n = Math.min(first.length(), second.length());
    for (int i = 0; i < n; i++) {
      if (first.charAt(i) != second.charAt(i)) {
        return new Tuple<>(first.charAt(i), second.charAt(i));
      }
    }
    return null;
  }

}
