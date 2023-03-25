package yym.svydovets.algorythm.task.numbers;

import java.util.stream.IntStream;

public class SumPrimeTask {

  // Using one Stream API statement find a sum of all prime numbers from 501st to 520th inclusively.
  // result should be 73052
  public static void main(String[] args) {
    int res = IntStream.iterate(2, n -> ++n)
        .filter(x -> IntStream.rangeClosed(2, (int) Math.sqrt(x)).noneMatch(d -> x % d == 0))
        .skip(500)
        .limit(20)
        .sum();
    System.out.println(res);
  }

}
