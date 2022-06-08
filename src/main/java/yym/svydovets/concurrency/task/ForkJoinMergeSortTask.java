package yym.svydovets.concurrency.task;

import yym.svydovets.utils.ArrGen;

import java.util.Arrays;
import java.util.concurrent.RecursiveAction;

  /**
   * Implement merge sort with Fork Join
   */
public class ForkJoinMergeSortTask extends RecursiveAction {

  int[] array;

  public ForkJoinMergeSortTask(int[] array) {
    this.array = array;
  }

  @Override
  protected void compute() {
    System.out.println("Thread: " + Thread.currentThread().getName());
    var n = array.length;
    if (n <= 1) return;

    var mid = n / 2;
    var l = new ForkJoinMergeSortTask(Arrays.copyOfRange(array, 0, mid));
    var r = new ForkJoinMergeSortTask(Arrays.copyOfRange(array, mid, array.length));

    l.fork();
    r.compute();
    l.join();

    merge(array, l.array, r.array);
  }

  private void merge(int[] array, int[] l, int[] r) {
    int leftIdx = 0, rightIdx = 0;

    while (leftIdx < l.length && rightIdx < r.length) {
      if (l[leftIdx] < r[rightIdx]) {
        array[leftIdx + rightIdx] = l[leftIdx++];
      } else {
        array[leftIdx + rightIdx] = r[rightIdx++];
      }
    }

    System.arraycopy(l, leftIdx, array, leftIdx+rightIdx, l.length - leftIdx);
    System.arraycopy(r, rightIdx, array, leftIdx+rightIdx, r.length - rightIdx);
  }

  public static void main(String[] args) {
    int[] arr = ArrGen.generate(100, 1000);
    var task = new ForkJoinMergeSortTask(arr);
    System.out.println("Before: " + Arrays.toString(task.array));
    task.compute();
    System.out.println("After: " + Arrays.toString(task.array));
  }

}
