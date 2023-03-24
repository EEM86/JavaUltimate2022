package yym.svydovets.algorythm.task;

import org.apache.commons.lang3.NotImplementedException;

import java.util.Objects;

/**
 * Create a node list and a reversed list
 */
public class NodeTask {

  public static void main(String[] args) {
    var node = Node.of(4, 5, 7, 9, 11);
    node = node.reverse();
    node.printList();
  }


  private static class Node<T> {

    T value;
    Node<T> next;

    public Node(T value) {
      this.value = value;
    }

    public static <E> Node<E> of(E... values) {
      throw new NotImplementedException();
    }

    public void printList() {

    }

    public <E> Node<T> reverse() {
      throw new NotImplementedException();
    }

  }
}


