package yym.svydovets.dataStructure.task;

import yym.svydovets.utils.ArrGen;

import java.util.Arrays;

public class SortTask {

  public static void main(String[] args) {
    final int[] array = ArrGen.generate(10, 100);
    System.out.print(Arrays.toString(array));
//    insertionSort(array);
//    bubbleSort(array);
//    mergeSort(array);
    System.out.println();
    System.out.print(Arrays.toString(array));
  }

  private static void mergeSort(int[] array) {
  }

  private static void merge(int[] array, int[] left, int[] right) {
  }

  private static void bubbleSort(int[] array) {

  }

  private static void insertionSort(int[] array) {

  }

}
