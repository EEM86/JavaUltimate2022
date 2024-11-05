package yym.svydovets.algorithm.task.csosvita.brute_force;

import java.util.Scanner;

public class BlackSea {

    /*
     * There is a map with war ships in the Black Sea.
     * The first and the second numbers in the row - amount of rows and cols on the map.
     * Next rows - map where symbol shows the cell. 1 is for a ship, 0 - empty cell.
     * Show the possibility of a warship's shot with the precision up to 6 signs.
     *
     * 1 <= r, c <= 100
     * 0 <= map[r,c] <= 1
     *
     * Sample Input 0:
     * 2 3
     * 0 0 1
     * 1 0 1
     * Sample Output 0: 0.500000
     */
    public static String blackSea(int row, int col, int[] arr) {
        int ships = 0;
        int r = 0;
        while (r < arr.length) {
            final int next = arr[r];
            if (next == 1) {
                ships++;
            }
            r++;
        }

        int sum = row * col;
        final float prob_ships = (float) ships / sum;
        return String.format("%,.6f", prob_ships);
    }

}
