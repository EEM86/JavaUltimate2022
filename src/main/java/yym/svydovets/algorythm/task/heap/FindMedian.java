package yym.svydovets.algorythm.task.heap;

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

    /*
     * MedianFinder() initializes the MedianFinder object.
     */
    public MedianFinder() {
    }

    /*
     * adds the integer num from the data stream to the data structure.
     */
    public void addNum(int num) {
    }

    /*
     * returns the median of all elements so far.
     * Answers within 10^-5 of the actual answer will be accepted.
     */
    public double findMedian() {
      return 0.0;
    }
  }
}
