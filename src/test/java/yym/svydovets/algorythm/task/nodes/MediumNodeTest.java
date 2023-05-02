package yym.svydovets.algorythm.task.nodes;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import yym.svydovets.utils.Node;

import java.util.ArrayList;

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

  @Test
  @Order(5)
  void testMergeK_v1() {
    var list = new ArrayList<Node<Integer>>();
    var first = new Node<>(1);
    first.next = new Node<>(4);
    first.next.next = new Node<>(5);

    var second = new Node<>(1);
    second.next = new Node<>(3);
    second.next.next = new Node<>(4);

    var third = new Node<>(2);
    third.next = new Node<>(6);

    list.add(first);
    list.add(second);
    list.add(third);

    final Node<Integer> root = MediumNode.mergeKLists(list);

    assertEquals(1, root.value);
    assertEquals(1, root.next.value);
    assertEquals(2, root.next.next.value);
    assertEquals(3, root.next.next.next.value);
    assertEquals(4, root.next.next.next.next.value);
    assertEquals(4, root.next.next.next.next.next.value);
    assertEquals(5, root.next.next.next.next.next.next.value);
    assertEquals(6, root.next.next.next.next.next.next.next.value);
  }

}