package yym.svydovets.algorythm.task.trees.tries;

import yym.svydovets.utils.TrieNode;

import java.util.ArrayList;
import java.util.List;

/* Hard
 *
 * Given an m x n board of characters and a list of strings words, return all words on the board.
 * Each word must be constructed from letters of sequentially adjacent cells,
 * where adjacent cells are horizontally or vertically neighboring.
 * The same letter cell may not be used more than once in a word.
 *
 * Input: board = [["o","a","a","n"],["e","t","a","e"],["i","h","k","r"],["i","f","l","v"]],
 * words = ["oath","pea","eat","rain"]
 * Output: ["eat","oath"]
 *
 * https://leetcode.com/problems/word-search-ii/
 */
public class WordSearch2 {

  public static List<String> findWords(char[][] board, String[] words) {
    var root = buildTrie(words);
    var res = new ArrayList<String>();

    for (int i = 0; i < board.length; i++) {
      for (int j = 0; j < board[0].length; j++) {
        dfs(board, i, j, root, res);
      }
    }
    return res;
  }

  private static void dfs(char[][] board, int col, int row, TrieNode node, List<String> res) {
    var curChar = board[col][row];
    if (curChar == '#' || !node.containsKey(curChar)) {
      return;
    }
    node = node.get(curChar);
    if (node.getWord() != null) {
      res.add(node.getWord());
      node.setWord(null); // check this
    }

    board[col][row] = '#';
    if (col > 0) dfs(board, col - 1, row, node, res);
    if (row > 0) dfs(board, col, row - 1, node, res);
    if (col < board.length - 1) dfs(board, col + 1, row, node, res);
    if (row < board[0].length - 1) dfs(board, col, row + 1, node, res);
    board[col][row] = curChar;
  }

  private static TrieNode buildTrie(String[] words) {
    var root = new TrieNode();
    for (var str : words) {
      var node = root;
      for (int i = 0; i < str.length(); i++) {
        var curChar = str.charAt(i);
        if (!node.containsKey(curChar)) {
          node.put(curChar, new TrieNode());
        }
        node = node.get(curChar);
      }
      node.setEnd();
      node.setWord(str);
    }
    return root;
  }

}
