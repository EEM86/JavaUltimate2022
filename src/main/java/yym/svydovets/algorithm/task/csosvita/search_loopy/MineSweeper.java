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
    public static String printMineField(int[][] arr) {
        var sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                int cur = arr[i][j];
                if (cur != -10) {
                    changeCell(arr, i, j);
                }
                if (arr[i][j] == -10) {
                    sb.append("*");
                } else {
                    sb.append(arr[i][j]);
                }
                if (j < arr[0].length - 1) {
                    sb.append(" ");
                }
                if ((j == arr[0].length - 1) && (i != arr.length - 1)) {
                    sb.append("\n");
                }
            }
        }
        return sb.toString();

    }

    private static void changeCell(int[][] arr, int row, int col) {
        int cur = arr[row][col];
        if (col > 0 && arr[row][col-1] == -10) {
            cur++;
        }
        if (col > 0 && row > 0 && arr[row-1][col-1] == -10) {
            cur++;
        }
        if (row > 0 && arr[row-1][col] == -10) {
            cur++;
        }
        if (row > 0 && col < arr[0].length - 1 && arr[row-1][col+1] == -10) {
            cur++;
        }
        if (col < arr[0].length - 1 && arr[row][col+1] == -10) {
            cur++;
        }
        if (row < arr.length - 1 && col < arr[0].length - 1 && arr[row+1][col+1] == -10) {
            cur++;
        }
        if (row < arr.length - 1 && arr[row+1][col] == -10) {
            cur++;
        }
        if (row < arr.length - 1 && col > 0 && arr[row+1][col-1] == -10) {
            cur++;
        }
        arr[row][col] = cur;
    }

    public static String printMineFieldChar(char[][] arr) {
        var sb = new StringBuilder();

        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                char cur = arr[i][j];
                if (cur != '*') {
                    dfsChar(arr, i, j);
                }
                sb.append(arr[i][j]);
                if (j < arr[0].length - 1) {
                    sb.append(" ");
                }
                if ((j == arr[0].length - 1) && (i != arr.length - 1)) {
                    sb.append("\n");
                }
            }
        }
        if (!sb.isEmpty()) {
            sb.deleteCharAt(sb.length() -1);
        }
        return sb.toString();

    }

    private static void dfsChar(char[][] arr, int row, int col) {
        char cur = arr[row][col];
        if (col > 0 && arr[row][col-1] == '*') {
            cur++;
        }
        if (col > 0 && row > 0 && arr[row-1][col-1] == '*') {
            cur++;
        }
        if (row > 0 && arr[row-1][col] == '*') {
            cur++;
        }
        if (row > 0 && col < arr[0].length - 1 && arr[row-1][col+1] == '*') {
            cur++;
        }
        if (col < arr[0].length - 1 && arr[row][col+1] == '*') {
            cur++;
        }
        if (row < arr.length - 1 && col < arr[0].length - 1 && arr[row+1][col+1] == '*') {
            cur++;
        }
        if (row < arr.length - 1 && arr[row+1][col] == '*') {
            cur++;
        }
        if (row < arr.length - 1 && col > 0 && arr[row+1][col-1] == '*') {
            cur++;
        }
        arr[row][col] = cur;
    }

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int h = sc.nextInt();
        int m  = sc.nextInt();
        int k = sc.nextInt();
        int[][] arr = new int[h][m];
        for (int i = 0; i < k; i++) {
            int row = sc.nextInt() - 1;
            int col = sc.nextInt() - 1;
            arr[row][col] = -10;
        }
        final String result = printMineField(arr);
        System.out.println(result);
    }



}
