package yym.svydovets.algorithm.task.b_search;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SearchInRotatedArrayTest {

  @Test
  void testSearchInRotatedArr_v1() {
    var input = new int[]{4,5,6,7,0,1,2};
    var target = 0;
    var expected = 4;

    var actual = SearchInRotatedArray.search(input, target);

    assertEquals(actual, expected);
  }

  @Test
  void testSearchInRotatedArr_v2() {
    var input = new int[]{4,5,6,7,0,1,2};
    var target = 3;
    var expected = -1;

    var actual = SearchInRotatedArray.search(input, target);

    assertEquals(actual, expected);
  }

  @Test
  void testSearchInRotatedArr_v3() {
    var input = new int[]{1};
    var target = 0;
    var expected = -1;

    var actual = SearchInRotatedArray.search(input, target);

    assertEquals(actual, expected);
  }

  @Test
  void testSearchInRotatedArr_v4() {
    var input = new int[]{3,1};
    var target = 0;
    var expected = -1;

    var actual = SearchInRotatedArray.search(input, target);

    assertEquals(actual, expected);
  }

  @Test
  void testSearchInRotatedArr_v5() {
    var input = new int[]{1,3};
    var target = 3;
    var expected = 1;

    var actual = SearchInRotatedArray.search(input, target);

    assertEquals(actual, expected);
  }

}