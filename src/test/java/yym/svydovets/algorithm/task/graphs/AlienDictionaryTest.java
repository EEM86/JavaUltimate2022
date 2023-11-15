package yym.svydovets.algorithm.task.graphs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class AlienDictionaryTest {

  AlienDictionary service;

  @BeforeEach
  void setUp() {
    service = new AlienDictionary();
  }

  @Test
  void alienOrder_v1() {
    String[] words = {"wrt", "wrf", "er", "ett", "rftt"};
    String expected = "wertf";

    String actual = service.alienOrder(words);
    assertEquals(expected, actual);
  }

  @Test
  void alienOrder_v2() {
    String[] words = {"z", "x"};
    String expected = "zx";

    String actual = service.alienOrder(words);
    assertEquals(expected, actual);
  }

  @Test
  void alienOrder_v3() {
    String[] words = {"z", "x", "z"};

    String actual = service.alienOrder(words);
    assertTrue(actual.isEmpty());
  }

  @Test
  void alienOrder_v4() {
    String[] words = {"we", "w"};

    String actual = service.alienOrder(words);
    assertTrue(actual.isEmpty());
  }
}