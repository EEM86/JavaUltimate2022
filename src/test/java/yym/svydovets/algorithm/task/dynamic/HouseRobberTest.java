package yym.svydovets.algorithm.task.dynamic;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HouseRobberTest {

  @Test
  void robMemo() {
    var service = new HouseRobber();
    int[] nums = {1, 2, 3, 1};
    int expected = 4;

    int actual = service.robMemo(nums);
    assertEquals(expected, actual);
  }

  @Test
  void robRecurs() {
    var service = new HouseRobber();
    int[] nums = {1, 2, 3, 1};
    int expected = 4;

    int actual = service.robRecurs(nums);
    assertEquals(expected, actual);
  }

  @Test
  void robTopDown() {
    var service = new HouseRobber();
    int[] nums = {1, 2, 3, 1};
    int expected = 4;

    int actual = service.robTopDown(nums);
    assertEquals(expected, actual);
  }

  @Test
  void robOptimal() {
    var service = new HouseRobber();
    int[] nums = {1, 2, 3, 1};
    int expected = 4;

    int actual = service.robOptimal(nums);
    assertEquals(expected, actual);
  }

  @Test
  void robV2_1() {
    var service = new HouseRobber();
    int[] nums = {2, 3, 2};
    int expected = 3;

    int actual = service.robV2(nums);
    assertEquals(expected, actual);
  }

  @Test
  void robV2_2() {
    var service = new HouseRobber();
    int[] nums = {1, 2, 3, 1};
    int expected = 4;

    int actual = service.robV2(nums);
    assertEquals(expected, actual);
  }

  @Test
  void robV2_3() {
    var service = new HouseRobber();
    int[] nums = {1, 2, 3};
    int expected = 3;

    int actual = service.robV2(nums);
    assertEquals(expected, actual);
  }

  @Test
  void robV2_4() {
    var service = new HouseRobber();
    int[] nums = {1};
    int expected = 1;

    int actual = service.robV2(nums);
    assertEquals(expected, actual);
  }
}