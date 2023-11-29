package yym.svydovets.algorithm.task.dynamic;

import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(OrderAnnotation.class)
class HouseRobberTest {

  @Test
  @Order(1)
  void robMemo() {
    var service = new HouseRobber();
    int[] nums = {1, 2, 3, 1};
    int expected = 4;

    int actual = service.robMemo(nums);
    assertEquals(expected, actual);
  }

  @Test
  @Order(2)
  void robMemo_v2() {
    var service = new HouseRobber();
    int[] nums = {2,7,9,3,1};
    int expected = 12;

    int actual = service.robMemo(nums);
    assertEquals(expected, actual);
  }

  @Test
  @Order(3)
  void robRecurs() {
    var service = new HouseRobber();
    int[] nums = {1, 2, 3, 1};
    int expected = 4;

    int actual = service.robRecurs(nums);
    assertEquals(expected, actual);
  }

  @Test
  @Order(4)
  void robRecurs_v2() {
    var service = new HouseRobber();
    int[] nums = {2,7,9,3,1};
    int expected = 12;

    int actual = service.robRecurs(nums);
    assertEquals(expected, actual);
  }

  @Test
  @Order(5)
  void robTopDown() {
    var service = new HouseRobber();
    int[] nums = {1, 2, 3, 1};
    int expected = 4;

    int actual = service.robTopDown(nums);
    assertEquals(expected, actual);
  }

  @Test
  @Order(6)
  void robTopDown_v2() {
    var service = new HouseRobber();
    int[] nums = {2,7,9,3,1};
    int expected = 12;

    int actual = service.robTopDown(nums);
    assertEquals(expected, actual);
  }

  @Test
  @Order(7)
  void robOptimal() {
    var service = new HouseRobber();
    int[] nums = {1, 2, 3, 1};
    int expected = 4;

    int actual = service.robOptimal(nums);
    assertEquals(expected, actual);
  }

  @Test
  @Order(8)
  void robOptimal_v2() {
    var service = new HouseRobber();
    int[] nums = {2,7,9,3,1};
    int expected = 12;

    int actual = service.robOptimal(nums);
    assertEquals(expected, actual);
  }

  @Test
  @Order(9)
  void robV2_1() {
    var service = new HouseRobber();
    int[] nums = {2, 3, 2};
    int expected = 3;

    int actual = service.robV2(nums);
    assertEquals(expected, actual);
  }

  @Test
  @Order(10)
  void robV2_2() {
    var service = new HouseRobber();
    int[] nums = {1, 2, 3, 1};
    int expected = 4;

    int actual = service.robV2(nums);
    assertEquals(expected, actual);
  }

  @Test
  @Order(11)
  void robV2_3() {
    var service = new HouseRobber();
    int[] nums = {1, 2, 3};
    int expected = 3;

    int actual = service.robV2(nums);
    assertEquals(expected, actual);
  }

  @Test
  @Order(12)
  void robV2_4() {
    var service = new HouseRobber();
    int[] nums = {1};
    int expected = 1;

    int actual = service.robV2(nums);
    assertEquals(expected, actual);
  }
}