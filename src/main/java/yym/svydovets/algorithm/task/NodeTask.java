package yym.svydovets.algorithm.task;

import org.apache.commons.lang3.NotImplementedException;
import yym.svydovets.utils.Node;

import java.util.Objects;

/**
 * Create a node list and a reversed list
 */
public class NodeTask {
  private NodeTask() {};

  /**
   * Creates a new instance of {@link Node} that holds provided element
   *
   * @param element any element of type T
   * @param <T>     generic type
   * @return a new instance of {@link Node}
   */
  public static <T> Node<T> create(T element) {
    throw new NotImplementedException();
  }

  /**
   * Create a connection between first and second nodes, so object first stores a reference to the second.
   *
   * @param first  any {@link Node} object
   * @param second any {@link Node} object
   * @param <T>    a genetic type
   */
  public static <T> void link(Node<T> first, Node<T> second) {
    throw new NotImplementedException();
  }

  /**
   * Creates two new {@link Node} objects using provided firstElement and secondElement, and create a connection
   * between those two elements so the first node will hold a reference to a second one.
   *
   * @param firstElement  any element of type T
   * @param secondElement any element of type T
   * @param <T>           a genetic type
   * @return a reference to a first node created based on firstElement
   */
  public static <T> Node<T> pairOf(T firstElement, T secondElement) {
    throw new NotImplementedException();
  }

  /**
   * Creates two new {@link Node} objects using provided firstElement and secondElement, and creates connections
   * between those nodes so the first node will hold a reference to a second one, and a second node will hold
   * a reference to the first one.
   *
   * @param firstElement  any element of type T
   * @param secondElement any element of type T
   * @param <T>           generic type T
   * @return a reference to the first node
   */
  public static <T> Node<T> closedPairOf(T firstElement, T secondElement) {
    throw new NotImplementedException();
  }

  /**
   * Creates a linked chain of {@link Node} objects based on provided elements. Creates a connection between those
   * nodes so each node will hold a reference to the next one in the chain. HINT: it's basically a linked list.
   *
   * @param elements a array of elements of type T
   * @param <T>      generic type T
   * @return a reference to the first element of the chain
   */
  public static <T> Node<T> chainOf(T... elements) {
    throw new NotImplementedException();
  }

  /**
   * Creates a linked circle of {@link Node} objects based on provided elements. Creates a connection between those
   * nodes so each node will hold a reference to the next one in the chain, and the last one will hold a reference to
   * the first one.
   *
   * @param elements a array of elements of type T
   * @param <T>      generic type T
   * @return a reference to the first element of the chain
   */
  public static <T> Node<T> circleOf(T... elements) {
    throw new NotImplementedException();
  }

  /**
   * Print node list
   * @param head the first node
   * @return String with nodes [node1.element -> node2.element -> ... -> nodeN.element]
   */
  public static String printList(Node<?> head) { throw new NotImplementedException(); }

  /**
   * Reverse a node list
   * @param <T> generic type T
   * @param head current head
   * @return a reference to the first element
   */
  public static <T> Node<T> reverse(Node<T> head) {
      throw new NotImplementedException();
    }


}


