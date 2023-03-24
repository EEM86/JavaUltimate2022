package yym.svydovets.dataStructure.task;

import org.junit.jupiter.api.Test;
import yym.svydovets.algorythm.task.SortTask;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;

class SortTaskTest {

  @Test
  public void testMergeSort() {
    int[] unsortedArray = {4, 2, 8, 1, 3, 7};
    int[] sortedArray = {1, 2, 3, 4, 7, 8};

    SortTask.mergeSort(unsortedArray);

    assertArrayEquals(sortedArray, unsortedArray);
  }

  @Test
  public void testBubbleSort() {
    int[] unsortedArray = {4, 2, 8, 1, 3, 7};
    int[] sortedArray = {1, 2, 3, 4, 7, 8};

    SortTask.bubbleSort(unsortedArray);

    assertArrayEquals(sortedArray, unsortedArray);
  }

  @Test
  public void testInsertionSort() {
    int[] unsortedArray = {4, 2, 8, 1, 3, 7};
    int[] sortedArray = {1, 2, 3, 4, 7, 8};

    SortTask.insertionSort(unsortedArray);

    assertArrayEquals(sortedArray, unsortedArray);
  }

  @Test
  public void testMergeListSort() {
    // create an ArrayList of unsorted integers
    ArrayList<Integer> unsortedList = new ArrayList<>(Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5));

    // sort the ArrayList in ascending order
    SortTask.mergeSort(unsortedList, Comparator.naturalOrder());

    // create an ArrayList of the expected sorted integers
    ArrayList<Integer> expectedList = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9));

    // assert that the sorted ArrayList matches the expected sorted ArrayList
    assertEquals(expectedList, unsortedList);
  }

}