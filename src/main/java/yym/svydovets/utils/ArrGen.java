package yym.svydovets.utils;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public final class ArrGen {

  private ArrGen() {}

  public static int[] generate(int size, int bound) {
    int[] array = new int[size];
    for (int i = 0; i < size; i++) {
      array[i] = ThreadLocalRandom.current().nextInt(bound);
    }
    return array;
  }

  public static List<Integer> generateList(int size, int bound) {
    var list = new ArrayList<Integer>(size);
    for (int i = 0; i < size; i++) {
      list.add(ThreadLocalRandom.current().nextInt(bound));
    }
    return list;
  }

}
