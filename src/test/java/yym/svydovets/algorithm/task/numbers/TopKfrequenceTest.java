package yym.svydovets.algorithm.task.numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TopKfrequenceTest {

  @Test
  void testTopFrequency_v1() {
    int[] input = new int[]{1,1,1,2,2,3};
    int k = 2;

    int[] expected = new int[]{1,2};

    int[] actual = TopKfrequence.topKFrequent(input, k);

    assertArrayEquals(expected, actual);
  }

  @Test
  void testTopFrequency_v2() {
    int[] input = new int[]{1};
    int k = 1;

    int[] expected = new int[]{1};

    int[] actual = TopKfrequence.topKFrequent(input, k);

    assertArrayEquals(expected, actual);
  }

  @Test
  void testTopFrequency_v3() {
    int[] input = new int[]{1, 2};
    int k = 2;

    int[] expected = new int[]{1, 2};

    int[] actual = TopKfrequence.topKFrequent(input, k);

    assertArrayEquals(expected, actual);
  }

  @Test
  void testTopFrequency_v4() {
    int[] input = new int[]{3, 0, 1, 0};
    int k = 1;

    int[] expected = new int[]{0};

    int[] actual = TopKfrequence.topKFrequent(input, k);

    assertArrayEquals(expected, actual);
  }

}