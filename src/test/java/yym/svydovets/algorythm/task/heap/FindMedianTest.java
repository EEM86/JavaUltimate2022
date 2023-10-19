package yym.svydovets.algorythm.task.heap;

import org.junit.jupiter.api.Test;
import yym.svydovets.algorythm.task.heap.FindMedian.MedianFinder;

import static org.junit.jupiter.api.Assertions.assertEquals;

class FindMedianTest {

  @Test
  void testFindMedian() {
    var medianFinder = new MedianFinder();
    medianFinder.addNum(1);
    medianFinder.addNum(2);
    double evenRes = medianFinder.findMedian();

    assertEquals(1.5, evenRes);

    medianFinder.addNum(3);
    double oddRes = medianFinder.findMedian();

    assertEquals(2.0, oddRes);
  }

}