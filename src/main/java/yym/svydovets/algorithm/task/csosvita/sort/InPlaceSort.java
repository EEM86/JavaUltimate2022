package yym.svydovets.algorithm.task.csosvita.sort;

import org.apache.commons.lang3.NotImplementedException;

public class InPlaceSort {

    /*
     * Sort 2d array in place
     */
    public static void sort2dArray(int[][] arr) {
        throw new NotImplementedException();
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
}
