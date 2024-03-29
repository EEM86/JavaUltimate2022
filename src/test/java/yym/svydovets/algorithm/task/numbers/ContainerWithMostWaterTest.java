package yym.svydovets.algorithm.task.numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ContainerWithMostWaterTest {

  @Test
  void testContainerWithMostWater_v1() {
    int[] initial = new int[]{1,8,6,2,5,4,8,3,7};
    int expected = 49;

    int actual = ContainerWithMostWater.maxArea(initial);

    assertEquals(expected, actual);
  }

  @Test
  void testContainerWithMostWater_v2() {
    int[] initial = new int[]{1,1};
    int expected = 1;

    int actual = ContainerWithMostWater.maxArea(initial);

    assertEquals(expected, actual);
  }

  @Test
  void testContainerWithMostWater_v3() {
    int[] initial = new int[]{2,3,4,5,18,17,6};
    int expected = 17;

    int actual = ContainerWithMostWater.maxArea(initial);

    assertEquals(expected, actual);
  }

}