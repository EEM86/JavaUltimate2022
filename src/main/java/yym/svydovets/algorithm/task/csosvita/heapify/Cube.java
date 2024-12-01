package yym.svydovets.algorithm.task.csosvita.heapify;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Cube {

    /*
     * The cube, 41063625 (345^3), can be permuted to produce two other cubes: 56623104 (384^3) and 66430125 (405^3).
     * In fact, 41063625 is the smallest cube which has exactly three permutations of its digits which are also cube.
     * Find the smallest cube for which exactly five permutations of its digits are cube.
     *
     * Print smallest cube for which exactly five permutations of its digits are cube.
     */
    public static String findCube(int k) {
        Map<String, CubeHelper> cubes = new HashMap<>();

        for (int i = 100; i < 10000; i++) {
            String key = sortDigits((long) i * i * i);
            final CubeHelper cubeHelper = cubes.get(key);
            if (cubeHelper == null) {
                cubes.put(key, new CubeHelper(i, 1));
            } else {
                cubeHelper.count++;
            }
        }

        int smallest = Integer.MAX_VALUE;
        for (var cube : cubes.values()) {
            if (cube.count == k) {
                smallest = Math.min(smallest, cube.smallest);
            }
        }
        final long result = (long) smallest * smallest * smallest;
        return String.valueOf(result);
    }

    public static String sortDigits(long n) {
        String s = String.valueOf(n);
        final char[] charArray = s.toCharArray();
        Arrays.sort(charArray);
        final StringBuilder reversed = new StringBuilder(String.valueOf(charArray)).reverse();
        return reversed.toString();
    }

    static class CubeHelper {
        int smallest;
        int count;

        public CubeHelper(int smallest, int count) {
            this.smallest = smallest;
            this.count = count;
        }
    }

    public static void main(String[] args) {
        System.out.print(findCube(5));
    }

    public static String sortDigitsOld(long n) {
        int[] arr = new int[10];
        long result = 0;
        while (n > 0) {
            int l = (int) n % 10;
            arr[l]++;
            n /= 10;
        }

        for (int i = 9; i >= 0; i--) {
            result = (long) (Math.pow(10, arr[i]) * (i + 9 * result) - i) / 9;
        }
        return String.valueOf(result);
    }

}
