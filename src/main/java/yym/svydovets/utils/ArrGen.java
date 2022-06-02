package yym.svydovets.utils;

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

}
