package yym.svydovets.algorithm.task.matrix;

import java.util.HashSet;
import java.util.Set;

public class ValidSudoku {

  public static void main(String[] args) {
    var board = new char[][]
        {
            {'5','3','.','.','7','.','.','.','.'},
            {'6','.','.','1','9','5','.','.','.'},
            {'.','9','8','.','.','.','.','6','.'},
            {'8','.','.','.','6','.','.','.','3'},
            {'4','.','.','8','.','3','.','.','1'},
            {'7','.','.','.','2','.','.','.','6'},
            {'.','6','.','.','.','.','2','8','.'},
            {'.','.','.','4','1','9','.','.','5'},
            {'.','.','.','.','8','.','.','7','9'}
        };
    System.out.println(isValidSudokuSite(board));
  }

  /*
  Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated
  according to the following rules:

  Each row must contain the digits 1-9 without repetition.
  Each column must contain the digits 1-9 without repetition.
  Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.

  Note:

  A Sudoku board (partially filled) could be valid but is not necessarily solvable.
  Only the filled cells need to be validated according to the mentioned rules.

  https://leetcode.com/problems/valid-sudoku/
   */
  static boolean isValidSudoku(char[][] board) {
    int n = board.length;
    //checking for first condition
    for(int i = 0 ; i < n; i ++){
      Set<Character> hs = new HashSet<>();
      for(int j = 0 ; j < n ; j ++){
        if(board[i][j] == '.'){
          continue;
        }
        if(hs.contains(board[i][j])){
          return false;
        }else{
          hs.add(board[i][j]);
        }
      }
    }
    //checking for second condition
    for(int i = 0 ; i < n; i ++){
      HashSet<Character> hs = new HashSet<Character>();
      for(int j = 0 ; j < n ; j ++){
        if(board[j][i] == '.'){
          continue;
        }
        if(hs.contains(board[j][i])){
          return false;
        }else{
          hs.add(board[j][i]);
        }
      }
    }
    //checking for third condition
    for(int i = 0 ; i < n ; i +=3){
      for(int l = 0; l < n ; l +=3){
        HashSet<Character> hs = new HashSet<Character>();
        for(int j = i,count = 0 ; count < 3; count ++,j++){
          for(int k = l,cnt = 0; cnt < 3; cnt ++,k++){
            if(board[j][k] == '.'){
              continue;
            }
            if(hs.contains(board[j][k])){
              return false;
            }else{
              hs.add(board[j][k]);
            }
          }
        }
      }
    }
    return true;
  }

  static boolean isValidSudokuSite(char[][] board) {
    var numbers = new HashSet<String>();
    for (int i = 0; i < 9; i++) {
      for (int j = 0; j < 9; j++) {
        var currentChar = board[i][j];
        if (currentChar != '.') {
          if (!numbers.add(currentChar + " row " + i) ||
              !numbers.add(currentChar + " column " + j) ||
              !numbers.add(currentChar + " block " + i/3 + "-" + j/3)) {
            return false;
          }
        }
      }
    }
    return true;
  }

}