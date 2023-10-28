package yym.svydovets.algorythm.task.graphs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import yym.svydovets.utils.GraphNode;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

class DeepCloneTest {

  DeepClone service;

  @BeforeEach
  void setUp() {
    service = new DeepClone();
  }

  @Test
  void cloneGraph() {
    var first = new GraphNode(1);
    var second = new GraphNode(2);
    var third = new GraphNode(3);
    var fourth = new GraphNode(4);

    first.neighbors.add(second);
    first.neighbors.add(third);

    second.neighbors.add(first);
    second.neighbors.add(fourth);

    third.neighbors.add(first);
    third.neighbors.add(fourth);

    fourth.neighbors.add(second);
    fourth.neighbors.add(third);

    var copyFirst = service.cloneGraph(first);

    assertNotSame(copyFirst, first);
    assertEquals(first.val, copyFirst.val);
    assertEquals(first.neighbors.size(), copyFirst.neighbors.size());
    assertNotSame(first.neighbors.get(0), copyFirst.neighbors.get(0));
    assertNotSame(first.neighbors.get(1), copyFirst.neighbors.get(1));

    var copySecond = copyFirst.neighbors.get(0);
    assertNotSame(copySecond, second);
    assertEquals(second.val, copySecond.val);
    assertEquals(second.neighbors.size(), copySecond.neighbors.size());
    assertNotSame(second.neighbors.get(0), copySecond.neighbors.get(0));
    assertNotSame(second.neighbors.get(1), copySecond.neighbors.get(1));

    var copyThird = copyFirst.neighbors.get(1);
    assertNotSame(copyThird, third);
    assertEquals(third.val, copyThird.val);
    assertEquals(third.neighbors.size(), copyThird.neighbors.size());
    assertNotSame(third.neighbors.get(0), copyThird.neighbors.get(0));
    assertNotSame(third.neighbors.get(1), copyThird.neighbors.get(1));

    var copyFourth = copyThird.neighbors.get(1);
    assertNotSame(copyFourth, fourth);
    assertEquals(fourth.val, copyFourth.val);
    assertEquals(fourth.neighbors.size(), copyFourth.neighbors.size());
    assertNotSame(fourth.neighbors.get(0), copyFourth.neighbors.get(0));
    assertNotSame(fourth.neighbors.get(1), copyFourth.neighbors.get(1));
  }

}