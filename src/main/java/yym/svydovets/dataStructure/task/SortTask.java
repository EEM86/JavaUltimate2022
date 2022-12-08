package yym.svydovets.dataStructure.task;

import yym.svydovets.utils.ArrGen;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

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

  }

  // ToDo implement bubbleSort
  private static void bubbleSort(int[] array) {

  }

  // ToDo implement insertionSort
  private static void insertionSort(int[] array) {

  }

  //ToDo implement mergeSort with generics List
  private static <T extends Comparable<? super T>> void mergeSort(List<T> list, Comparator<? super T> comparator) {

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
