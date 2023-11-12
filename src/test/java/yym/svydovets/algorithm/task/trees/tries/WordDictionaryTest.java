package yym.svydovets.algorithm.task.trees.tries;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordDictionaryTest {

  @Test
  void testWordDictionary_v1() {
    var dict = new WordDictionary();
    dict.addWord("bad");
    dict.addWord("dad");
    dict.addWord("mad");

    assertFalse(dict.search("pad"));
    assertTrue(dict.search("bad"));
    assertTrue(dict.search(".ad"));
    assertTrue(dict.search("b.."));
  }

  @Test
  void testWordDictionary_v2() {
    var dict = new WordDictionary();
    dict.addWord("at");
    dict.addWord("and");
    dict.addWord("an");
    dict.addWord("add");

    assertFalse(dict.search("a"));
    assertFalse(dict.search(".at"));

    dict.addWord("bat");

    assertTrue(dict.search(".at"));
    assertTrue(dict.search("an."));
    assertFalse(dict.search("a.d."));
    assertFalse(dict.search("b."));
    assertTrue(dict.search("a.d"));
    assertFalse(dict.search("."));
  }
}