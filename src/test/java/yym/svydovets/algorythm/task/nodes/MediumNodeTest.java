package yym.svydovets.algorythm.task.nodes;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import yym.svydovets.utils.Node;

import static org.junit.jupiter.api.Assertions.*;
import static yym.svydovets.algorythm.task.nodes.MediumNode.removeNthFromEnd;
import static yym.svydovets.algorythm.task.nodes.MediumNode.reorderList;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MediumNodeTest {

  @Test
  @Order(1)
  void testReorderList_v1() {
    var first = new Node<>(1);
    var second = new Node<>(2);
    var third = new Node<>(3);
    var fourth = new Node<>(4);

    first.next = second;
    second.next = third;
    third.next = fourth;

    reorderList(first);

    assertEquals(fourth, first.next);
    assertEquals(second, first.next.next);
    assertEquals(third, first.next.next.next);
  }

  @Test
  @Order(2)
  void testReorderList_v2() {
    var first = new Node<>(1);
    var second = new Node<>(2);
    var third = new Node<>(3);
    var fourth = new Node<>(4);
    var fifth = new Node<>(5);

    first.next = second;
    second.next = third;
    third.next = fourth;
    fourth.next = fifth;

    reorderList(first);

    assertEquals(fifth, first.next);
    assertEquals(second, first.next.next);
    assertEquals(fourth, first.next.next.next);
    assertEquals(third, first.next.next.next.next);
  }

  @Test
  @Order(3)
  void testRemoveNthFromEnd_v1() {
    var first = new Node<>(1);
    var second = new Node<>(2);
    var third = new Node<>(3);
    var fourth = new Node<>(4);
    var fifth = new Node<>(5);

    first.next = second;
    second.next = third;
    third.next = fourth;
    fourth.next = fifth;

    removeNthFromEnd(first, 2);

    assertEquals(second, first.next);
    assertEquals(third, first.next.next);
    assertEquals(fifth, first.next.next.next);
  }

  @Test
  @Order(4)
  void testRemoveNthFromEnd_v2() {
    var first = new Node<>(1);
    first.next = new Node<>(2);

    removeNthFromEnd(first, 1);

    assertEquals(1, first.value);
    assertNull(first.next);
  }

}