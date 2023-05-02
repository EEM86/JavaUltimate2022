package yym.svydovets.algorythm.task.nodes;

import yym.svydovets.utils.Node;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import static java.util.Comparator.comparingInt;

public class MediumNode {

  /*
   * Medium
   *
   * You are given the head of a singly linked-list. The list can be represented as:
   * L0 → L1 → … → Ln - 1 → Ln
   * Reorder the list to be on the following form:
   * L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
   * You may not modify the values in the list's nodes. Only nodes themselves may be changed.
   *
   * Example: Input: head = [1,2,3,4]. Output: [1,4,2,3]
   * https://leetcode.com/problems/reorder-list/description/
   */
  public static void reorderList(Node<Integer> head) {
    var midNode = findMidNode(head);
    var nextToMid = midNode.next;
    midNode.next = null;
    var mergeSecond = reverse(nextToMid);

    var mergeFirst = head;
    Node<Integer> nextToFirst = null;

    while (mergeFirst != null && mergeSecond != null) {
      nextToFirst = mergeFirst.next;
      mergeFirst.next = mergeSecond;

      mergeFirst = mergeSecond;
      mergeSecond = nextToFirst;
    }
  }

  private static Node<Integer> reverse(Node<Integer> head) {
    var cur = head;
    Node<Integer> previous = null;
    Node<Integer> next = null;

    while (cur != null) {
      next = cur.next;
      cur.next = previous;
      previous = cur;
      cur = next;
    }
    return previous;
  }

  private static Node<Integer> findMidNode(Node<Integer> head) {
    var slow = head;
    var fast = head;

    while (fast.next != null && fast.next.next != null) {
      slow = slow.next;
      fast = fast.next.next;
    }

    return slow;
  }

  /*
   * Medium
   * Given the head of a linked list, remove the nth node
   * from the end of the list and return its head.
   *
   * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
   */
  public static Node<Integer> removeNthFromEnd(Node<Integer> head, int n) {
    var initNode = new Node<>(0);
    var first = initNode;
    var second = initNode;
    initNode.next = head;

    for (int i = 0; i <= n; i++) {
      first = first.next;
    }

    while (first != null) {
      first = first.next;
      second = second.next;
    }

    second.next = second.next.next;
    return initNode.next;
  }

  /*
   * Hard
   * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
   * Merge all the linked-lists into one sorted linked-list and return it.
   *
   * Example:
   * Input: lists = [[1,4,5],[1,3,4],[2,6]]
   * Output: [1,1,2,3,4,4,5,6]
   *
   * https://leetcode.com/problems/merge-k-sorted-lists/
   */
  public static Node<Integer> mergeKLists(List<Node<Integer>> lists) {
    if (lists == null || lists.size() == 0) return null;

    var heap = new PriorityQueue<Integer>();

    for (var node : lists) {
      while (node != null) {
        heap.offer(node.value);
        node = node.next;
      }
    }

    var head = new Node<Integer>();
    var headPointer = head;

    while (!heap.isEmpty()) {
      head.next = new Node<>(heap.poll());
      head = head.next;
    }
    return headPointer.next;
  }

}
