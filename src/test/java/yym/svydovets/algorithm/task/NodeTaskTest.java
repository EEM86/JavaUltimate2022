package yym.svydovets.algorithm.task;

import lombok.SneakyThrows;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import yym.svydovets.utils.Node;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class NodeTaskTest {

  @Test
  @Order(1)
  void create() {
    int element = 5;

    Node<Integer> node = NodeTask.create(element);

    assertThat(getNodeElement(node)).isEqualTo(element);
    assertThat(getNodeNext(node)).isNull();
  }

  @Test
  @Order(2)
  void link() {
    Node<Integer> firstNode = createNodeOf(5);
    Node<Integer> secondNode = createNodeOf(9);
    Node<Integer> thirdNode = createNodeOf(100);
    setNodeNext(secondNode, thirdNode);

    NodeTask.link(firstNode, secondNode);

    assertThat(getNodeNext(firstNode)).isEqualTo(secondNode);
    assertThat(getNodeNext(secondNode)).isEqualTo(thirdNode);
  }

  @Test
  @Order(3)
  void pair() {
    int firstElement = 8;
    int secondElement = 2;

    Node<Integer> firstNode = NodeTask.pairOf(firstElement, secondElement);

    Node<Integer> secondNode = getNodeNext(firstNode);
    assertThat(getNodeElement(firstNode)).isEqualTo(firstElement);
    assertThat(getNodeElement(secondNode)).isEqualTo(secondElement);
    assertThat(getNodeNext(secondNode)).isNull();
  }

  @Test
  @Order(4)
  void closedPair() {
    int firstElement = 8;
    int secondElement = 2;

    Node<Integer> firstNode = NodeTask.closedPairOf(firstElement, secondElement);

    Node<Integer> secondNode = getNodeNext(firstNode);
    assertThat(getNodeElement(firstNode)).isEqualTo(firstElement);
    assertThat(getNodeElement(secondNode)).isEqualTo(secondElement);
    assertThat(getNodeNext(secondNode)).isEqualTo(firstNode);
  }

  @Test
  @Order(5)
  void chain() {
    int firstElement = 8;
    int secondElement = 1;
    int thirdElement = 13;
    int fourthElement = 5;

    Node<Integer> firstNode = NodeTask.chainOf(firstElement, secondElement, thirdElement, fourthElement);

    Node<Integer> secondNode = getNodeNext(firstNode);
    Node<Integer> thirdNode = getNodeNext(secondNode);
    Node<Integer> fourthNode = getNodeNext(thirdNode);
    assertThat(getNodeElement(firstNode)).isEqualTo(firstElement);
    assertThat(getNodeElement(secondNode)).isEqualTo(secondElement);
    assertThat(getNodeElement(thirdNode)).isEqualTo(thirdElement);
    assertThat(getNodeElement(fourthNode)).isEqualTo(fourthElement);
    assertThat(getNodeNext(fourthNode)).isNull();
  }

  @Test
  @Order(6)
  void circle() {
    int firstElement = 8;
    int secondElement = 1;
    int thirdElement = 13;
    int fourthElement = 5;

    Node<Integer> firstNode = NodeTask.circleOf(firstElement, secondElement, thirdElement, fourthElement);

    Node<Integer> secondNode = getNodeNext(firstNode);
    Node<Integer> thirdNode = getNodeNext(secondNode);
    Node<Integer> fourthNode = getNodeNext(thirdNode);
    assertThat(getNodeElement(firstNode)).isEqualTo(firstElement);
    assertThat(getNodeElement(secondNode)).isEqualTo(secondElement);
    assertThat(getNodeElement(thirdNode)).isEqualTo(thirdElement);
    assertThat(getNodeElement(fourthNode)).isEqualTo(fourthElement);
    assertThat(getNodeNext(fourthNode)).isEqualTo(firstNode);
  }

  @Test
  @Order(7)
  void testPrintList() {
    int firstElement = 8;
    int secondElement = 1;
    int thirdElement = 13;
    int fourthElement = 5;

    var firstNode = NodeTask.chainOf(firstElement, secondElement, thirdElement, fourthElement);
    var expected = "[8 -> 1 -> 13 -> 5]";

    var actual = NodeTask.printList(firstNode);

    assertEquals(actual, expected);
  }

  @Test
  @Order(8)
  void testReversed() {
    int firstElement = 8;
    int secondElement = 1;
    int thirdElement = 13;
    int fourthElement = 5;

    var firstNode = NodeTask.chainOf(firstElement, secondElement, thirdElement, fourthElement);
    var expected = "[5 -> 13 -> 1 -> 8]";

    var reversed = NodeTask.reverse(firstNode);
    var actual = NodeTask.printList(reversed);

    assertEquals(actual, expected);
  }

  @SneakyThrows
  @SuppressWarnings("unchecked")
  private Node<Integer> createNodeOf(int element) {
    Constructor<?> constructor = Arrays.stream(Node.class.getDeclaredConstructors())
        .findAny()
        .orElseThrow();
    constructor.setAccessible(true);
    Node<Integer> node;
    if (constructor.getParameters().length > 0) {
      node = (Node<Integer>) constructor.newInstance(element);
    } else {
      node = (Node<Integer>) constructor.newInstance();
      setNodeElement(node, element);
    }
    return node;
  }

  @SneakyThrows
  @SuppressWarnings("unchecked")
  private <T> T getNodeElement(Node<T> node) {
    Field elementField = getAccessibleElementField();
    return (T) elementField.get(node);
  }

  @SneakyThrows
  private <T> void setNodeElement(Node<T> node, T element) {
    Field elementField = getAccessibleElementField();
    elementField.set(node, element);
  }

  @SneakyThrows
  @SuppressWarnings("unchecked")
  private <T> Node<T> getNodeNext(Node<T> node) {
    Field nextField = getAccessibleNextField();
    return (Node<T>) nextField.get(node);
  }

  @SneakyThrows
  private <T> void setNodeNext(Node<T> node, Node<T> next) {
    Field elementField = getAccessibleNextField();
    elementField.set(node, next);
  }

  private Field getAccessibleElementField() {
    Field elementField = Arrays.stream(Node.class.getDeclaredFields())
        .filter(field -> field.getType().equals(Object.class))
        .findAny()
        .orElseThrow();
    elementField.setAccessible(true);
    return elementField;
  }

  private Field getAccessibleNextField() {
    Field nextField = Arrays.stream(Node.class.getDeclaredFields())
        .filter(field -> field.getType().equals(Node.class))
        .findAny()
        .orElseThrow();
    nextField.setAccessible(true);
    return nextField;
  }
}