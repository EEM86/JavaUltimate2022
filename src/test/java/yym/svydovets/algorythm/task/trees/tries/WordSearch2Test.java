package yym.svydovets.algorythm.task.trees.tries;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class WordSearch2Test {

  @Test
  void findWords() {
    char[][] board = new char[][]{
        {'o','a','b','n'},
        {'o','t','a','e'},
        {'a','h','k','r'},
        {'a','f','l','v'}
    };

    var words = new String[] {"oa", "", "oaa"};

    var expected = List.of("oa", "oaa");

    var actual = WordSearch2.findWords(board, words);

    assertEquals(2, actual.size());
    assertEquals(expected, actual);
  }
}