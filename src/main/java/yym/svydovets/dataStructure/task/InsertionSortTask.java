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

  }

  private static void insertionSort(int[] array) {

  }

}
