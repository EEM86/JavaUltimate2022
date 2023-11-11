package yym.svydovets.algorithm.task.trees.tries;

import yym.svydovets.utils.TrieNode;

public class Trie {

  private TrieNode root;

  /**
   * Trie() Initializes the trie object.
   */
  public Trie() {
    root = new TrieNode();
  }

  /**
   * Inserts the string word into the trie.
   * @param word String
   */
  public void insert(String word) {
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
   * @param word String
   * @return true if the string word is in the trie (i.e., was inserted before), and false otherwise.
   */
  public boolean search(String word) {
    TrieNode node = searchPrefix(word);
    return node != null && node.isEnd();
  }

  private TrieNode searchPrefix(String word) {
    TrieNode node = root;
    for (int i = 0; i < word.length(); i++) {
      var curChar = word.charAt(i);
      if (node.containsKey(curChar)) {
        node = node.get(curChar);
      } else {
        return null;
      }
    }
    return node;
  }

  /**
   * Search for the prefix
   * @param prefix
   * @return Returns true if there is a previously inserted string word that has the
   * prefix, and false otherwise.
   */
  public boolean startsWith(String prefix) {
    TrieNode node = searchPrefix(prefix);
    return node != null;
  }
}
