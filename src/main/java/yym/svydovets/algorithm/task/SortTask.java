package yym.svydovets.algorithm.task;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class SortTask {

  // ToDo implement mergeSort
  public static void mergeSort(int[] array) {
    sort(array, 0, array.length);
  }

  private static void sort(int[] array, int l, int r) {
    if (r - l < 2) {
      return;
    }
    int m = (l + r) / 2;
    sort(array, l, m);
    sort(array, m, r);

    merge(array, l, m, r);
  }

  private static void merge(int[] a, int l, int m, int r) {
    int[] aux = new int[m - l];
    int idx = 0;
    for (int i = l; i < m; i++) {
      aux[idx++] = a[i];
    }
    int i = 0, j = m, k = l;
    while (i < aux.length || j < r) {
      if (j == r || (i < aux.length && aux[i] < a[j])) {
        a[k] = aux[i++];
      } else {
        a[k] = a[j++];
      }
      k++;
    }
  }

  // ToDo implement bubbleSort
  public static void bubbleSort(int[] array) {
    for (int i = 0; i < array.length; i++) {
      for (int j = 0; j < array.length - 1; j++) {
        if (array[j] > array[j+1]) {
          int tmp = array[j+1];
          array[j+1] = array[j];
          array[j] = tmp;
        }
      }
    }
  }

  // ToDo implement insertionSort
  public static void insertionSort(int[] array) {
    for (int i = 1; i < array.length; i++) {
      int j = i;
      int key = array[j];
      while (j > 0 && array[j-1] > key) {
        array[j] = array[j-1];
        j--;
      }
      array[j] = key;
    }
  }

  //ToDo implement mergeSort with generics List
  public static <T extends Comparable<? super T>> void mergeSort(List<T> list, Comparator<? super T> comparator) {

  }

}
