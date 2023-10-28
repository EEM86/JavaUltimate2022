package yym.svydovets.algorythm.task.graphs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PacificAtlanticWaterTest {

  PacificAtlanticWater service;

  @BeforeEach
  void setUp() {
    service = new PacificAtlanticWater();
  }

  @Test
  void pacificAtlantic_v1() {
    int[][] heights = {
        {1, 2, 2, 3, 5},
        {3, 2, 3, 4, 4},
        {2, 4, 5, 3, 1},
        {6, 7, 1, 4, 5},
        {5, 1, 1, 2, 4}
    };

    List<List<Integer>> result = service.pacificAtlantic(heights);

    List<List<Integer>> expected = List.of(
        List.of(0, 4),
        List.of(1, 3),
        List.of(1, 4),
        List.of(2, 2),
        List.of(3, 0),
        List.of(3, 1),
        List.of(4, 0)
    );

    assertEquals(expected, result);
  }

  @Test
  void pacificAtlantic_v2() {
    int[][] heights = {{1}};

    List<List<Integer>> result = service.pacificAtlantic(heights);

    List<List<Integer>> expected = List.of(List.of(0, 0));

    assertEquals(expected, result);
  }
}