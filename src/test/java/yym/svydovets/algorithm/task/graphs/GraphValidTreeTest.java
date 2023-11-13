package yym.svydovets.algorithm.task.graphs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class GraphValidTreeTest {

  GraphValidTree service;

  @BeforeEach
  void setUp() {
    service = new GraphValidTree();
  }

  @Test
  void isValidTree_v1() {
    int n = 5;
    int[][] edges = {{0,1}, {0,2}, {0,3}, {1,4}};

    boolean isValid = service.isValidTree(n, edges);

    assertTrue(isValid);
  }

  @Test
  void isValidTree_v2() {
    int n = 6;
    int[][] edges = {{0,1}, {0,2}, {1,4}, {3,5}};

    boolean isValid = service.isValidTree(n, edges);

    assertFalse(isValid);
  }

  @Test
  void isValidTree_v3() {
    int n = 5;
    int[][] edges = {{0,1}, {0,2}, {0,3}, {1,3}};

    boolean isValid = service.isValidTree(n, edges);

    assertFalse(isValid);
  }
}