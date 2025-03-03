package yym.svydovets.algorithm.task.csosvita.search;

import java.util.Scanner;

public class InPlaceSort {

    public static void sort2dArray(int[][] arr) {
        for (int row = 0; row < arr.length; row++) {
            for (int col = 0; col < arr[0].length; col++) {
                swapElements(arr, row, col, row + 1);
            }
        }
    }

    private static void swapElements(int[][] arr, int row, int col, int rowIdx) {
        var minVal = arr[row][col];
        int minRow = row;

        for (int i = rowIdx; i < arr.length; i++) {
            if (minVal > arr[i][0]) {
                minVal = arr[i][0];
                minRow = i;
            }
        }

        if (row != minRow) {
            int tmp = arr[row][col];
            arr[row][col] = arr[minRow][0];
            arr[minRow][0] = tmp;


            reorder(arr, minRow);
        }
    }

    private static void reorder(int[][] arr, int row) {
        for (int col = 0; col < arr[row].length - 1; col++) {
            if (arr[row][col] > arr[row][col+1]) {
                //swap
                int tmp = arr[row][col];
                arr[row][col] = arr[row][col+1];
                arr[row][col+1] = tmp;
            } else {
                break;
            }
        }
    }

    public static String printArray(int[][] arr) {
        var sb = new StringBuilder();
        for (int[] ints : arr) {
            for (int n : ints) {
                sb.append(n).append(" ");
            }
            sb.append("\n");
        }
        if (!sb.isEmpty()) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int rows = sc.nextInt();
        int cols = sc.nextInt();
        int[][] arr = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                arr[row][col] = sc.nextInt();
            }
        }
        sort2dArray(arr);
        System.out.println(printArray(arr));
    }

/*
* Sorting steps:
*
* 4 7 9     [4] 7 9      [1] 7 9     1 7 9           1 [7] 9     1 2 9     1 2 [9]
* 1 2 8  -> [1] 2 8  ->  [4] 2 8 -> [2] 4 8    ->    [2] 4 8 ->  7 4 8 -> [4] 7 8 ->
* 5 8 9     [5] 8 9        5 8 9     5 8 9  find min [5] 8 9     5 8 9    [5] 8 9
*
*
* 1 2 4      1 2 4       1 2 4    1 2 4      1 2 4     1 2 4
* 9 7 8 -> [7] 8 9 ->  5 [8] 9 -> 5 7 [9] -> 5 7 8 ->  5 7 8
* 5 8 9    [5] 8 9     [7] 8 9    [8] 8 9    9 8 9     8 8 9
*/

}
