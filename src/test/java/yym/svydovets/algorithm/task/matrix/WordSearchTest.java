package yym.svydovets.algorithm.task.matrix;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class WordSearchTest {

  @Test
  void testExist_v1() {
    var board = new char[][]{
        {'A','B','C','E'},
        {'S','F','C','S'},
        {'A','D','E','E'}
    };
    var word = "ABCCED";

    Assertions.assertTrue(WordSearch.exist(board, word));
  }

  @Test
  void testExist_v2() {
    var board = new char[][]{
        {'A','B','C','E'},
        {'S','F','C','S'},
        {'A','D','E','E'}
    };
    var word = "SEE";

    Assertions.assertTrue(WordSearch.exist(board, word));
  }

  @Test
  void testExist_v3() {
    var board = new char[][]{
        {'A','B','C','E'},
        {'S','F','C','S'},
        {'A','D','E','E'}
    };
    var word = "ABCB";

    Assertions.assertFalse(WordSearch.exist(board, word));
  }

}