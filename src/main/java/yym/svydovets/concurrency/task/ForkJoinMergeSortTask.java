package yym.svydovets.concurrency.task;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.concurrent.RecursiveAction;

/**
 * Implement merge sort with Fork Join
 * https://www.youtube.com/watch?v=whHaNMmIOgI&t=3143s
 */
@Getter
@Setter
public class ForkJoinMergeSortTask extends RecursiveAction {

  List<Integer> list;

  public ForkJoinMergeSortTask(List<Integer> list) {
    this.list = list;
  }

  @Override
  protected void compute() {

  }
}
