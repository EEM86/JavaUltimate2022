package yym.svydovets.algorithm.task.heap;

import java.util.Collections;
import java.util.PriorityQueue;

/* Hard
 * The median is the middle value in an ordered integer list.
 * If the size of the list is even, there is no middle value,
 * and the median is the mean of the two middle values.
 * For example, for arr = [2,3,4], the median is 3.
 * For example, for arr = [2,3], the median is (2 + 3) / 2 = 2.5.
 */
public class FindMedian {

  public static void main(String[] args) {
    MedianFinder obj = new MedianFinder();
    obj.addNum(1);
    obj.addNum(2);
    System.out.println(obj.findMedian());
    obj.addNum(3);
    System.out.println(obj.findMedian());
  }


  public static class MedianFinder {

    private PriorityQueue<Integer> small;
    private PriorityQueue<Integer> large;
    private boolean even;

    /*
     * MedianFinder() initializes the MedianFinder object.
     */
    public MedianFinder() {
      small = new PriorityQueue<>(Collections.reverseOrder());
      large = new PriorityQueue<>();
      even = true;
    }

    /*
     * adds the integer num from the data stream to the data structure.
     */
    public void addNum(int num) {
      if (even) {
        large.add(num);
        small.add(large.poll());
      } else {
        small.add(num);
        large.add(small.poll());
      }
      even = !even;
    }

    /*
     * returns the median of all elements so far.
     * Answers within 10^-5 of the actual answer will be accepted.
     */
    public double findMedian() {
      if (even) {
        return (small.peek() + large.peek()) / 2.0;
      }  else {
        return small.peek();
      }
    }
  }
}
