package yym.svydovets.algorithm.task.numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LongestConsecutiveSequenceTest {

  @Test
  void testLongestConsecutiveSequence_v1() {
    int[] initial = new int[]{100,4,200,1,3,2};
    int expected = 4;

    int actual = LongestConsecutiveSequence.longestConsecutive(initial);

    assertEquals(expected, actual);
  }

  @Test
  void testLongestConsecutiveSequence_v2() {
    int[] initial = new int[]{0,3,7,2,5,8,4,6,0,1};
    int expected = 9;

    int actual = LongestConsecutiveSequence.longestConsecutive(initial);

    assertEquals(expected, actual);
  }

}