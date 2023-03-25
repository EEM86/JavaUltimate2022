package yym.svydovets.algorythm.task;

import yym.svydovets.utils.ArrGen;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;

public class SortTask {

  public static void main(String[] args) {
    final int[] array = ArrGen.generate(10, 100);
    System.out.print(Arrays.toString(array));
//    insertionSort(array);
//    bubbleSort(array);
//    mergeSort(array);
    System.out.println();
    System.out.print(Arrays.toString(array));

//    checkMergeList();
  }

  // ToDo implement mergeSort
  private static void mergeSort(int[] array) {
    var n = array.length;

    if (n <= 1) {
      return;
    }

    var mid = n / 2;
    var left = Arrays.copyOfRange(array, 0, mid);
    var right = Arrays.copyOfRange(array, mid, n);

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

  // ToDo implement bubbleSort
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

  // ToDo implement insertionSort
  private static void insertionSort(int[] array) {
    for (int i = 1; i < array.length; i++) {
      var current = array[i];
      var idx = i;

      while (idx > 0 && current < array[idx - 1]) {
        array[idx] = array[idx - 1];
        idx--;
      }
      array[idx] = current;
    }
  }

  private static <T extends Comparable<? super T>> void mergeSort(List<T> elements, Comparator<? super T> comparator) {
    var n = elements.size();

    if (n <= 1) {
      return;
    }

    var left = new ArrayList<>(elements.subList(0, n/2));
    var right = new ArrayList<>(elements.subList(n/2, n));

    mergeSort(left, comparator);
    mergeSort(right, comparator);

    merge(elements, left, right, comparator);
  }

  private static <T extends Comparable<? super T>> void merge(List<T> elements, List<T> left, List<T> right, Comparator<? super T> comparator) {
    int leftIdx = 0, rightIdx = 0;
    var nullsLast = Comparator.nullsLast(Objects.requireNonNull(comparator));

    while (leftIdx < left.size() && rightIdx < right.size()) {
      if (nullsLast.compare(left.get(leftIdx), right.get(rightIdx)) < 0) {
        elements.set(leftIdx + rightIdx, left.get(leftIdx++));
      } else {
        elements.set(leftIdx + rightIdx, right.get(rightIdx++));
      }
    }

    while (leftIdx < left.size()) {
      elements.set(leftIdx + rightIdx, left.get(leftIdx++));
    }

    while (rightIdx < right.size()) {
      elements.set(leftIdx + rightIdx, right.get(rightIdx++));
    }
  }

  private static void checkMergeList() {
    var list = ArrGen.generateList(10, 40);

    System.out.println();
    list.forEach(o -> System.out.print(o + " "));
    System.out.println();

    mergeSort(list, Comparator.naturalOrder());

    list.forEach(o -> System.out.print(o + " "));
  }

}
