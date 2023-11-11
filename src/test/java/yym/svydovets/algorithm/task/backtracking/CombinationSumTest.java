package yym.svydovets.algorithm.task.backtracking;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class CombinationSumTest {

  CombinationSum service;

  @BeforeEach
  void setUp() {
    service = new CombinationSum();
  }

  @Test
  void combinationSum_v1() {
    var input = new int[]{2, 4, 6, 8};
    int target = 8;

    List<List<Integer>> res = service.combinationSum(input, target);

    assertEquals(5, res.size());
    assertTrue(res.contains(List.of(2, 2, 2, 2)));
    assertTrue(res.contains(List.of(2, 2, 4)));
    assertTrue(res.contains(List.of(2, 6)));
    assertTrue(res.contains(List.of(4, 4)));
    assertTrue(res.contains(List.of(8)));
  }

  @Test
  void combinationSum_v2() {
    var input = new int[]{2, 3, 6, 7};
    int target = 7;

    List<List<Integer>> res = service.combinationSum(input, target);

    assertEquals(2, res.size());
    assertTrue(res.contains(List.of(2, 2, 3)));
    assertTrue(res.contains(List.of(7)));
  }

  @Test
  void combinationSum_v3() {
    var input = new int[]{2, 3, 5};
    int target = 8;

    List<List<Integer>> res = service.combinationSum(input, target);

    assertEquals(3, res.size());
    assertTrue(res.contains(List.of(2, 2, 2, 2)));
    assertTrue(res.contains(List.of(2, 3, 3)));
    assertTrue(res.contains(List.of(3, 5)));
  }

  @Test
  void combinationSum_v4() {
    var input = new int[]{2};
    int target = 1;

    List<List<Integer>> res = service.combinationSum(input, target);

    assertEquals(0, res.size());
  }
}