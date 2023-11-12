package yym.svydovets.algorithm.task.graphs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class NumberOfConnectedTest {

  private NumberOfConnected service;

  @BeforeEach
  void setUp() {
    service = new NumberOfConnected();
  }

  @Test
  void countComponents_v1() {
    int input = 5;
    int[][] edges = {{0,1}, {1,2}, {3,4}};

    var res = service.countComponents(input, edges);

    assertEquals(2, res);
  }

  @Test
  void countComponents_v2() {
    int input = 5;
    int[][] edges = {{1,0}, {1,2}, {2,3}, {3,4}};

    var res = service.countComponents(input, edges);

    assertEquals(1, res);
  }

  @Test
  void countComponents_v3() {
    int input = 3;
    int[][] edges = {{2,1}, {2,0}};

    var res = service.countComponents(input, edges);

    assertEquals(1, res);
  }
}