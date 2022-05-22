package yym.svydovets.oop;

import java.util.ArrayList;
import java.util.List;

public class DemoMergeSortList {

  public static void main(String[] args) {

    final List<Integer> list = new ArrayList<>();
    list.add(2);
    list.add(4);
    list.add(5);
    list.add(1);

    System.out.println(mergeList(list));
  }

  private static <T extends Comparable<T>> List<T> mergeList(List<T> list) {
    var n = list == null ? 0 : list.size();
    if (n <= 1) {
      return list;
    }

    var middle = n / 2;

    final List<T> left = new ArrayList<>(list.subList(0, middle));
    final List<T> right = new ArrayList<>(list.subList(middle, n));

    mergeList(left);
    mergeList(right);

    return merge(list, left, right);
  }

  private static <T extends Comparable<T>> List<T> merge(List<T> list, List<T> left, List<T> right) {
    int leftIdx = 0, rightIdx = 0, currentIdx = 0;

    while (leftIdx < left.size() && rightIdx < right.size()) {
      if (left.get(leftIdx).compareTo(right.get(rightIdx)) < 1) {
        list.set(currentIdx++, left.get(leftIdx++));
      } else {
        list.set(currentIdx++, right.get(rightIdx++));
      }
    }

    fillList(leftIdx, left, list, currentIdx);
    fillList(rightIdx, right, list, currentIdx);

    return list;
  }

  private static <T extends Comparable<T>> void fillList(int subIdx, List<T> subList, List<T> dest, int destIdx) {
    while (subIdx < subList.size()) {
      dest.set(destIdx++, subList.get(subIdx++));
    }
  }
}
