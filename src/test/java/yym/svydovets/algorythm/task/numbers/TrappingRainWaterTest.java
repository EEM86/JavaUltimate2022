package yym.svydovets.algorythm.task.numbers;

import org.junit.jupiter.api.Test;
import yym.svydovets.algorythm.task.numbers.TrappingRainWater;

import static org.junit.jupiter.api.Assertions.*;

class TrappingRainWaterTest {

  @Test
  void testTrappingRainWater_v1() {
    int[] input = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
    int expected = 6;

    int actual = TrappingRainWater.trap(input);

    assertEquals(expected, actual);
  }

  @Test
  void testTrappingRainWater_v2() {
    int[] input = new int[]{5,5,1,7,1,1,5,2,7,6};
    int expected = 23;

    int actual = TrappingRainWater.trap(input);

    assertEquals(expected, actual);
  }

  @Test
  void testTrappingRainWater_v3() {
    int[] input = new int[]{0,1,0,0};
    int expected = 0;

    int actual = TrappingRainWater.trap(input);

    assertEquals(expected, actual);
  }

}