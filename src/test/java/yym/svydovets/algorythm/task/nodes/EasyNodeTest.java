package yym.svydovets.algorythm.task.nodes;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import yym.svydovets.utils.Node;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class EasyNodeTest {

  @Test
  @Order(1)
  void testHasCycle_v1() {
    var first = new Node<>(3);
    var second = new Node<>(2);
    var third = new Node<>(1);
    var fourth = new Node<>(4);

    first.next = second;
    second.next = third;
    third.next = fourth;
    fourth.next = second;

    var isCycled = EasyNode.hasCycle(first);

    assertTrue(isCycled);
  }

  @Test
  @Order(2)
  void testHasCycle_v2() {
    var first = new Node<>(1);
    var second = new Node<>(2);

    first.next = second;
    second.next = first;

    var isCycled = EasyNode.hasCycle(first);

    assertTrue(isCycled);
  }

  @Test
  @Order(3)
  void testHasCycle_v3() {
    var first = new Node<>(1);

    var isCycled = EasyNode.hasCycle(first);

    assertFalse(isCycled);
  }

  @Test
  @Order(4)
  void testReverseList_v1() {
    var first = new Node<>(1);
    var second = new Node<>(2);
    var third = new Node<>(3);
    var fourth = new Node<>(4);
    var fifth = new Node<>(5);

    first.next = second;
    second.next = third;
    third.next = fourth;
    fourth.next = fifth;

    var actual = EasyNode.reverseList(first);

    assertEquals(fifth, actual);
    assertEquals(fourth, actual.next);
    assertEquals(third, actual.next.next);
    assertEquals(second, actual.next.next.next);
    assertEquals(first, actual.next.next.next.next);
  }

  @Test
  @Order(5)
  void testReverseList_v2() {
    var first = new Node<>(1);
    var second = new Node<>(2);

    first.next = second;

    var actual = EasyNode.reverseList(first);

    assertEquals(second, actual);
    assertEquals(first, actual.next);
  }

  @Test
  @Order(6)
  void testMergeTwo_v1() {
    var first = new Node<>(1);
    var second = new Node<>(2);
    var third = new Node<>(4);

    first.next = second;
    second.next = third;

    var fourth = new Node<>(1);
    var fifth = new Node<>(3);
    var sixth = new Node<>(4);

    fourth.next = fifth;
    fifth.next = sixth;

    var actual = EasyNode.mergeTwoLists(first, fourth);

    assertEquals(first, actual);
    assertEquals(fourth, actual.next);
    assertEquals(second, actual.next.next);
    assertEquals(fifth, actual.next.next.next);
    assertEquals(third, actual.next.next.next.next);
    assertEquals(sixth, actual.next.next.next.next.next);
  }

}