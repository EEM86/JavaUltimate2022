package yym.svydovets.dataStructure.task.numbers;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class TwoSumTest {

  @Test
  @Order(1)
  void testTwoSum_v1() {
    int[] initial = new int[]{2,7,11,15};
    int target = 9;
    var expected = new int[]{0,1};

    var actual = TwoSum.twoSum(initial, target);
    Arrays.sort(actual);

    assertArrayEquals(expected, actual);
  }

  @Test
  @Order(2)
  void testTwoSum_v2() {
    int[] initial = new int[]{3,2,4};
    int target = 6;
    var expected = new int[]{1,2};

    var actual = TwoSum.twoSum(initial, target);
    Arrays.sort(actual);

    assertArrayEquals(expected, actual);
  }

  @Test
  @Order(3)
  void testTwoSum_v3() {
    int[] initial = new int[]{3,3};
    int target = 6;
    var expected = new int[]{0,1};

    var actual = TwoSum.twoSum(initial, target);
    Arrays.sort(actual);

    assertArrayEquals(expected, actual);
  }

  @Test
  @Order(4)
  void testTwoSumV2_v1() {
    int[] initial = new int[]{2,7,11,15};
    int target = 9;
    var expected = new int[]{1,2};

    var actual = TwoSum.twoSumV2(initial, target);
    Arrays.sort(actual);

    assertArrayEquals(expected, actual);
  }

  @Test
  @Order(5)
  void testTwoSumV2_v2() {
    int[] initial = new int[]{2,3,4};
    int target = 6;
    var expected = new int[]{1,3};

    var actual = TwoSum.twoSumV2(initial, target);
    Arrays.sort(actual);

    assertArrayEquals(expected, actual);
  }

  @Test
  @Order(6)
  void testTwoSumV2_v3() {
    int[] initial = new int[]{-1, 0};
    int target = -1;
    var expected = new int[]{1,2};

    var actual = TwoSum.twoSumV2(initial, target);
    Arrays.sort(actual);

    assertArrayEquals(expected, actual);
  }

  @Test
  @Order(7)
  void testThreeSum_v1() {
    int[] initial = new int[]{-1,0,1,2,-1,-4};
    var expected = List.of(List.of(-1, -1, 2), List.of(-1, 0, 1));

    var actual = TwoSum.threeSum(initial);

    actual.forEach(System.out::print);
    System.out.println();

    assertEquals(expected.size(), actual.size());
    assertTrue(actual.containsAll(expected));
  }

  @Test
  @Order(8)
  void testThreeSum_v2() {
    int[] initial = new int[]{0,1,1};
    var actual = TwoSum.threeSum(initial);
    assertTrue(actual.isEmpty());
  }

  @Test
  @Order(9)
  void testThreeSum_v3() {
    int[] initial = new int[]{0,0,0};
    var expected = List.of(List.of(0, 0, 0));
    var actual = TwoSum.threeSum(initial);

    System.out.println();
    actual.forEach(System.out::print);

    assertEquals(expected.size(), actual.size());
    assertTrue(actual.containsAll(expected));
  }

}