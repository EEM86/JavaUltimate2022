package yym.svydovets.javaBaseLib;

import yym.svydovets.utils.Account;
import yym.svydovets.utils.Accounts;

import java.util.Comparator;
import java.util.Objects;
import java.util.Stack;

public class DemoJavaBaseLibraries {

  public static void main(String[] args) {

    var head = createLinkedList(4, 3, 9, 1);

    printReversedRecursively(head);
    System.out.println("");
    printReversedStack(head);
    System.out.println("");

    Comparator<Account> accountComparator = new RandomFieldComparator<>(Account.class, false);
    System.out.println(accountComparator);
    Accounts.generateAccountList(10)
        .stream()
        .sorted(accountComparator)
        .forEach(System.out::println);

  }

  /**
   * Creates a list of linked {@link Node} objects based on the given array of elements and returns a head of the list.
   *
   * @param elements an array of elements that should be added to the list
   * @param <T>      elements type
   * @return head of the list
   */
  public static <T> Node<T> createLinkedList(T... elements) {
    Objects.checkIndex(0, elements.length);
    var head = new Node<>(elements[0]);
    var current = head;
    var prev = head;
    for (int i = 1; i < elements.length; i++) {
      current.next = new Node<>(elements[i]);
      current.next.prev = current;
      current = current.next;

    }
    return head;
  }

  private static <T> void printReversedRecursively(Node<T> node) {
    if (node == null) return;
    printReversedRecursively(node.next);
    if (node.prev == null) {
      System.out.print(node.element);
    } else {
      System.out.print(node.element + " -> ");
    }
  }

  public static <T> void printReversedStack(Node<T> head) {
    Objects.requireNonNull(head);
    var stack = new Stack<T>();
    printRecursivelyStack(stack, head.next);
    while (!stack.isEmpty()) {
      System.out.print(stack.pop() + " -> ");
    }
    System.out.print(head.element);
  }

  private static <T> void printRecursivelyStack(Stack<T> stack, Node<T> node) {
    while (node != null) {
      stack.push(node.element);
      node = node.next;
    }
  }
}
