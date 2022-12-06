package yym.svydovets.dataStructure.task;

import yym.svydovets.utils.ArrGen;

import java.util.Arrays;

public class SortTask {

  public static void main(String[] args) {
    final int[] array = ArrGen.generate(10, 100);
    System.out.print(Arrays.toString(array));
//    insertionSort(array);
//    bubbleSort(array);
    mergeSort(array);
    System.out.println();
    System.out.print(Arrays.toString(array));
  }

  private static void mergeSort(int[] array) {
    final int n = array.length;

    if (n <= 1) {
      return;
    }

    var mid = n / 2;
    int[] left = Arrays.copyOfRange(array, 0, mid);
    int[] right = Arrays.copyOfRange(array, mid, n);

    mergeSort(left);
    mergeSort(right);

    merge(array, left, right);
  }

  private static void merge(int[] array, int[] left, int[] right) {
    int leftIdx = 0, rightIdx = 0;

    while (leftIdx < left.length && rightIdx < right.length) {
      if (left[leftIdx] < right[rightIdx]) {
        array[leftIdx + rightIdx] = left[leftIdx++];
      } else {
        array[leftIdx + rightIdx] = right[rightIdx++];
      }
    }

    System.arraycopy(left, leftIdx, array, leftIdx + rightIdx, left.length - leftIdx);
    System.arraycopy(right, rightIdx, array, leftIdx + rightIdx, right.length - rightIdx);
  }

  private static void bubbleSort(int[] array) {
    for (int i = 0; i < array.length - 1; i++) {
      for (int j = i + 1; j < array.length; j++) {
        if (array[j] < array[i]) {
          var current = array[j];
          array[j] = array[i];
          array[i] = current;
        }
      }
    }
  }

  private static int[] insertionSort(int[] arr) {
    for (int i = 1; i < arr.length; i++) {
      var current = arr[i];
      var idx = i - 1;
      while (idx >= 0 && (current < arr[idx])) {
        arr[idx + 1] = arr[idx];
        idx--;
      }
      arr[idx + 1] = current;
    }
    return arr;
  }

}
