package yym.svydovets.algorythm.task.b_search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static yym.svydovets.algorythm.task.b_search.MinInRotatedArray.findMin;

class MinInRotatedArrayTest {

  @Test
  void testMinInRotatedArray_v1() {
    var input = new int[]{3,4,5,1,2};
    var expected = 1;

    var actual = findMin(input);

    assertEquals(actual, expected);
  }

  @Test
  void testMinInRotatedArray_v2() {
    var input = new int[]{4,5,6,7,0,1,2};
    var expected = 0;

    var actual = findMin(input);

    assertEquals(actual, expected);
  }

  @Test
  void testMinInRotatedArray_v3() {
    var input = new int[]{11,13,15,17};
    var expected = 11;

    var actual = findMin(input);

    assertEquals(actual, expected);
  }

  @Test
  void testMinInRotatedArray_v4() {
    var input = new int[]{2,3,4,5,1};
    var expected = 1;

    var actual = findMin(input);

    assertEquals(actual, expected);
  }

}