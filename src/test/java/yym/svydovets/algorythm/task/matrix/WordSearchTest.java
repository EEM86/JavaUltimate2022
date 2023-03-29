package yym.svydovets.algorythm.task.matrix;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static yym.svydovets.algorythm.task.matrix.WordSearch.exist;

class WordSearchTest {

  @Test
  void testExist_v1() {
    var board = new char[][]{
        {'A','B','C','E'},
        {'S','F','C','S'},
        {'A','D','E','E'}
    };
    var word = "ABCCED";

    assertTrue(exist(board, word));
  }

  @Test
  void testExist_v2() {
    var board = new char[][]{
        {'A','B','C','E'},
        {'S','F','C','S'},
        {'A','D','E','E'}
    };
    var word = "SEE";

    assertTrue(exist(board, word));
  }

  @Test
  void testExist_v3() {
    var board = new char[][]{
        {'A','B','C','E'},
        {'S','F','C','S'},
        {'A','D','E','E'}
    };
    var word = "ABCB";

    assertFalse(exist(board, word));
  }

}