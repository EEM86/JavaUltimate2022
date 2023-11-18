package yym.svydovets.algorithm.task.dynamic;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ClimbingStairsTest {

  private ClimbingStairs service;

  @BeforeEach
  void setUp() {
    service = new ClimbingStairs();
  }

  @Test
  void climbStairs_v1() {
    int n = 2;
    int expected = 2;

    int actual = service.climbStairs(n);

    assertEquals(expected, actual);
  }

  @Test
  void climbStairs_v2() {
    int n = 3;
    int expected = 3;

    int actual = service.climbStairs(n);

    assertEquals(expected, actual);
  }

  @Test
  void climbStairs_v3() {
    int n = 5;
    int expected = 8;

    int actual = service.climbStairs(n);

    assertEquals(expected, actual);
  }
}