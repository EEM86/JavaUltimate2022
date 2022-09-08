package yym.svydovets.dataStructure.task.strings;

import org.apache.commons.lang3.NotImplementedException;

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
        throw new NotImplementedException();
    }

}
