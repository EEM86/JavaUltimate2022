package yym.svydovets.concurrency.task;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;

class ForkJoinMergeSortTaskTest {

  @Test
  public void testForkJoinPoolSortTask() {
    // create an array of integers to be summed
    var unsortedList = new ArrayList<>(Arrays.asList(3, 1, 4, 1, 5, 9, 2, 6, 5, 3, 5));
    var expectedList = new ArrayList<>(Arrays.asList(1, 1, 2, 3, 3, 4, 5, 5, 5, 6, 9));

    // create a ForkJoinTask to sort the array
    ForkJoinMergeSortTask task = new ForkJoinMergeSortTask(unsortedList);
    task.invoke();

    // assert that the result is the expected
    assertEquals(expectedList, unsortedList);
  }

}