package yym.svydovets.algorythm.task.trees.tries;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TrieTest {

  @Test
  void testTrie() {
    var trie = new Trie();
    trie.insert("apple");

    assertTrue(trie.search("apple"));
    assertFalse(trie.search("app"));
    assertTrue(trie.startsWith("app"));

    trie.insert("app");

    assertTrue(trie.search("app"));
  }

}