package yym.svydovets.algorithm.task.csosvita.sort;

import java.util.Arrays;

/*
 * Sorting task.
 * 1. Quadratic sort. Implement Insertion sort
 * 2. Auxiliary array sort with merge sort
 * 3. Non-recursive methods for sorting
 */
public class SortInts {

    /*
     * Quadratic sort.
     */
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

    /*
     * Merge Sort Implementation
     */
    public static int[] mergeSort(int[] a) {
        int n = a.length;
        if (n < 2) return a;

        int m = n / 2;
        int[] left = mergeSort(Arrays.copyOfRange(a, 0, m));
        int[] right = mergeSort(Arrays.copyOfRange(a, m, n));

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

    /*
     * Merge Sort with auxiliary array
     */
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

    /*
     * Non-recursive Merge Sort
     */
    public static void nonRecursiveSort(int[] a) {
        int n = a.length;
        int[] aux = new int[n/2];
        for (int len = 1; len < n; len *= 2) {
            for (int lo = 0; lo < n - len; lo += len + len) {
                int mid = lo + len;
                int hi = Math.min(mid + len, n);
                mergeNonRecursive(a, aux, lo, mid, hi);
            }
        }
    }

    private static void mergeNonRecursive(int[] a, int[] aux, int l, int mid, int r) {
        int x = 0;
        for (int i = l; i < mid; i++) {
            aux[x++] = a[i];
        }

        int i = 0, j = mid;
        int k = l, n = mid - l;

        while (i < n || j < r) {
            if (j == r || (i < n && aux[i] < a[j])) {
                a[k++] = aux[i++];
            } else {
                a[k++] = a[j++];
            }
        }
    }

    public static String[] sortPeople(String[] names, int[] heights) {
        int n = heights.length;
        String[] auxNames = new String[n / 2];
        int[] auxHeights = new int[n / 2];
        auxMergeSort(names, heights, 0, n, auxNames, auxHeights);
        return names;
    }

    private static void auxMergeSort(String[] names, int[] heights, int l, int r, String[] auxNames, int[] auxHeights) {
        if (r - l < 2) {
            return;
        }

        int mid = (r + l) / 2;
        auxMergeSort(names, heights, l, mid, auxNames, auxHeights);
        auxMergeSort(names, heights, mid, r, auxNames, auxHeights);


        auxMerge(names, heights, l, mid, r, auxNames, auxHeights);
    }

    private static void auxMerge(String[] names, int[] heights, int l, int mid, int r, String[] auxNames, int[] auxHeights) {
        int idx = 0;
        for (int i = l; i < mid; i++, idx++) {
            auxNames[idx] = names[i];
            auxHeights[idx] = heights[i];
        }

        int curLeft = 0;
        int curRight = mid;
        int outIdx = l;
        int leftLength = mid - l;

        while (curLeft < leftLength || curRight < r) {
            if (curRight == r || (curLeft < leftLength && auxHeights[curLeft] > heights[curRight])) {
                heights[outIdx] = auxHeights[curLeft];
                names[outIdx] = auxNames[curLeft];
                curLeft++;
            } else {
                heights[outIdx] = heights[curRight];
                names[outIdx] = names[curRight];
                curRight++;
            }
            outIdx++;
        }
    }
}
