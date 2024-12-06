package yym.svydovets.algorithm.task.csosvita.search_loopy;

import java.util.Scanner;

public class MineSweeper {

    /*
     * Create a MineSweeper game's field. You have 2d array and have to print the generated
     * mines field based on the input.
     * First row has 3 integers n, m, k - height, weight of a field and mines amount.
     * Other rows have coordinates for mines
     * 1 <= n, m, k <= 100
     *
     * Sample Input 0:
     * 4 4 4
     * 1 3
     * 2 1
     * 4 2
     * 4 4
     * Sample Output 0:
     * 1 2 * 1
     * * 2 1 1
     * 2 2 2 1
     * 1 * 2 *
     */
    public static String[][] generateBoard(String[][] board) {
        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                if (!board[row][col].equals("*")) {
                    int count = countMines(board, row, col);
                    board[row][col] = String.valueOf(count);
                }
            }
        }
        return board;
    }

    public static String boardToString(String[][] board) {
        var sb = new StringBuilder();
        for (String[] strings : board) {
            for (int j = 0; j < board[0].length; j++) {
                sb.append(strings[j]).append(" ");
            }
            if (!sb.isEmpty()) {
                sb.deleteCharAt(sb.length() - 1);
            }
            sb.append("\n");
        }
        if (!sb.isEmpty()) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    private static int countMines(String[][] board, int row, int col) {
        int[] dx = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int[] dy = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
        int count = 0;

        for (int i = 0; i < dx.length; i++) {
            int newRow = row + dx[i];
            int newCol = col + dy[i];

            if (inBoard(newRow, board, newCol) && hasMine(newRow, board, newCol)) {
                count++;
            }
        }

        return count;
    }

    private static boolean inBoard(int row, String[][] board, int col) {
        int rows = board.length;
        int cols = board[0].length;

        return ((row >= 0) && (row < rows)) &&  ((col >= 0) && (col < cols));
    }

    private static boolean hasMine(int row, String[][] board, int col) {
        return board[row][col].equals("*");
    }

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m  = sc.nextInt();
        int k = sc.nextInt();
        // Initialize the board
        String[][] board = new String[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] = "0";
            }
        }
        // Read mine locations and place them on the board
        for (int i = 0; i < k; i++) {
            int row = sc.nextInt() - 1;
            int col = sc.nextInt() - 1;
            board[row][col] = "*";
        }
        final String[][] formattedBoard = generateBoard(board);
        final String result = boardToString(formattedBoard);
        System.out.println(result);
    }



}
