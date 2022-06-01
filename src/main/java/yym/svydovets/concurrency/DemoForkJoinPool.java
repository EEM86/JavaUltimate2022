package yym.svydovets.concurrency;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class DemoForkJoinPool {

  public static void main(String[] args) {
    final ArrayList<Integer> list = new ArrayList<>();
    list.add(5);
    list.add(3);
    list.add(1);
    list.add(4);
    ParallelMergeSort<Integer> task = new ParallelMergeSort<>(list);
    final List<Integer> result = task.compute();
    System.out.println(result);
  }

  private static class ParallelMergeSort<T extends Comparable<? super T>> extends RecursiveTask<List<T>> {

    private List<T> initialValues;


    public ParallelMergeSort(List<T> initialValues) {
      this.initialValues = initialValues;
    }

    @Override
    protected List<T> compute() {
      int n = initialValues.size();
      if (n < 2) {
        return initialValues;
      }

      ParallelMergeSort<T> left = new ParallelMergeSort<>(
          new ArrayList<>(initialValues.subList(0, n / 2)));
      ParallelMergeSort<T> right = new ParallelMergeSort<>(
          new ArrayList<>(initialValues.subList(n / 2, n)));
      left.fork();
      List<T> sortRightPart = right.compute();
      List<T> sortLeftPart = left.join();
      return merge(sortLeftPart, sortRightPart);
    }

    private List<T> merge(List<T> left, List<T> right) {
      int leftIdx = 0, rightIdx = 0;
      while (leftIdx < left.size() && rightIdx < right.size()) {
        if (left.get(leftIdx).compareTo(right.get(rightIdx)) < 0) {
          initialValues.set(rightIdx + leftIdx, left.get(leftIdx++));
        } else {
          initialValues.set(rightIdx + leftIdx, right.get(rightIdx++));
        }
      }
      while (leftIdx < left.size()) {
        initialValues.set(rightIdx + leftIdx, left.get(leftIdx++));
      }
      while (rightIdx < right.size()) {
        initialValues.set(rightIdx + leftIdx, right.get(rightIdx++));
      }
      return initialValues;
    }
  }

}
