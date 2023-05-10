package yym.svydovets.algorythm.task.trees.tries;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class WordDictionaryTest {

  @Test
  void testWordDictionary() {
    var dict = new WordDictionary();
    dict.addWord("bad");
    dict.addWord("dad");
    dict.addWord("mad");

    assertFalse(dict.search("pad"));
    assertTrue(dict.search("bad"));
    assertTrue(dict.search(".ad"));
    assertTrue(dict.search("b.."));
  }

}