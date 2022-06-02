package yym.svydovets.dataStructure.task;

import yym.svydovets.utils.ArrGen;

import java.util.Arrays;

public class InsertionSortTask {

  public static void main(String[] args) {
    final int[] array = ArrGen.generate(10, 100);
    System.out.print(Arrays.toString(array));
//    insertionSort(array);
    bubbleSort(array);
    System.out.println();
    System.out.print(Arrays.toString(array));
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

  private static void insertionSort(int[] array) {
    for (int i = 1; i < array.length; i++) {
      var current = array[i];
      while (i > 0 && current < array[i - 1]) {
        array[i] = array[i - 1];
        array[i - 1] = current;
        i--;
      }
    }
  }

}
