package yym.svydovets.algorithm.task.trees.tries;

import yym.svydovets.utils.TrieNode;

/*
 * Medium
 * Design a data structure that supports adding new words
 * and finding if a string matches any previously added string.
 *
 * https://leetcode.com/problems/design-add-and-search-words-data-structure/description/
 */
public class WordDictionary {

  TrieNode root;

  /**
   * WordDictionary() initializes the object.
   */
  public WordDictionary() {
    this.root = new TrieNode();
  }

  /**
   * Adds word to the data structure, it can be matched later.
   */
  public void addWord(String word) {
    TrieNode node = root;
    for (int i = 0; i < word.length(); i++) {
      var curChar = word.charAt(i);
      if (!node.containsKey(curChar)) {
        node.put(curChar, new TrieNode());
      }
      node = node.get(curChar);
    }
    node.setEnd();
  }

  /**
   * Search for the word in the trie.
   * Word may contain dots '.' where dots can be matched with any letter.
   * @param word String
   * @return true if there is any string in the data structure
   * that matches word or false otherwise.
   */
  public boolean search(String word) {
    return deepSearch(root, word, 0);
  }

  private boolean deepSearch(TrieNode node, String word, int idx) {
    if (idx == word.length()) {
      return node.isEnd();
    }
    var curChar = word.charAt(idx);
    if (curChar == '.') {
      for (var child : node.getLinks()) {
        if (child != null && deepSearch(child, word, idx + 1)) {
          return true;
        }
      }
      return false;
    } else {
      var child = node.get(curChar);
      return child != null && deepSearch(child, word, idx + 1);
    }
  }
}
