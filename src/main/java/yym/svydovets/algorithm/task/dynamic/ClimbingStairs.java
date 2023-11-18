package yym.svydovets.algorithm.task.dynamic;

public class ClimbingStairs {
  public int climbStairs(int n) {
    if (n == 0 || n == 1) return 1;

    int one = 1, two = 1;

    for (int i = 2; i <= n; i++) {
      one = one + two;
      two = one - two;
    }
    return one;
  }
}
