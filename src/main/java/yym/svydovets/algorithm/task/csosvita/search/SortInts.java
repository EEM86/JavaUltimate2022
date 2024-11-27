package yym.svydovets.algorithm.task.csosvita.search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class SortInts {

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        List<Integer> ints = new ArrayList<>();
        while (sc.hasNext()) {
            ints.add(sc.nextInt());
        }
        sortInts(ints.stream().mapToInt(x -> (int) x).toArray());
    }

    public static void sortInts(int[] arr) {
//        final int[] res = sort(arr);
//        final int[] res = insertionSort(arr);
        final int[] res = auxSort(arr, 0, arr.length);
        final String result = Arrays.stream(res).mapToObj(String::valueOf).collect(Collectors.joining(" "));
        System.out.println(result);
    }

    public static int[] auxSort(int[] a, int l, int r) {
        if (r - l < 2) return a;

        int m = (r+l) / 2;
        auxSort(a, l, m);
        auxSort(a, m, r);

        return auxMerge(a, l, m, r);
    }

    private static int[] auxMerge(int[] a, int l, int m, int r) {
        int[] aux = new int[m-l];
        int idx = 0;
        for (int i = l; i < m; i++) {
            aux[idx++] = a[i];
        }
        int i = 0, j = m, k = l;
        while (i < aux.length || j < r) {
            if (j == r || (i < aux.length && aux[i] < a[j])) {
                a[k++] = aux[i++];
            } else {
                a[k++] = a[j++];
            }
        }
        return a;
    }


    public static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int j = i;
            int key = arr[j];
            while (j > 0 && arr[j-1] > key) {
                arr[j] = arr[j-1];
                j--;
            }
            arr[j] = key;
        }
        return arr;
    }

    public static int[] sort(int[] a) {
        int n = a.length;
        if (n < 2) return a;

        int m = n / 2;
        int[] left = sort(Arrays.copyOfRange(a, 0, m));
        int[] right = sort(Arrays.copyOfRange(a, m, n));

        return merge(left, right);
    }

    private static int[] merge(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        int[] res = new int[n+m];
        int l = 0, r = 0;

        while (l < n || r < m) {
            if (r == m || (l < n) && (a[l] < b[r])) {
                res[l+r] = a[l++];
            } else {
                res[l+r] = b[r++];
            }
        }
        return res;
    }

}
