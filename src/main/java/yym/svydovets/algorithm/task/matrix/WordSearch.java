package yym.svydovets.algorithm.task.matrix;

public class WordSearch {

    public static void main(String[] args) {
        char[][] board = new char[][]{
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'}
        };
        var word = "ABCCED";
        System.out.println(exist(board, word));
    }

    /*
    Given an m x n grid of characters board and a string word, return true if word exists in the grid.

    The word can be constructed from letters of sequentially adjacent cells,
    where adjacent cells are horizontally or vertically neighboring.
    The same letter cell may not be used more than once.
    Example:
    Input: board = {{'A','B','C','E'},{'S','F','C','S'},{'A','D','E','E'}}, word = "ABCCED"
    Output: true
    https://leetcode.com/problems/word-search/
     */
    static boolean exist(char[][] board, String word) {
        int row = board.length;
        int col = board[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (check(board, word, i, j, row, col, 0)) {
                    return true;
                }
            }
        }
        return false;
    }

    static boolean check(char[][] board, String word, int i, int j, int row, int col, int cur) {
        if (cur >= word.length()) return true;
        if (i < 0 || j < 0 || i >= row || j >= col || board[i][j] != word.charAt(cur)) return false;
        boolean exist = false;
        if (board[i][j] == word.charAt(cur)) {
            board[i][j] += 100;
            exist =
                check(board, word, i + 1, j, row, col, cur + 1) ||
                    check(board, word, i, j + 1, row, col, cur + 1) ||
                    check(board, word, i - 1, j, row, col, cur + 1) ||
                    check(board, word, i, j - 1, row, col, cur + 1);
            board[i][j] -= 100;
        }
        return exist;
    }

}
