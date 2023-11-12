package yym.svydovets.algorithm.task.nodes;

import org.apache.commons.lang3.NotImplementedException;
import yym.svydovets.utils.Node;

import java.util.List;

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
    throw new NotImplementedException();
  }

  /*
   * Medium
   * Given the head of a linked list, remove the nth node
   * from the end of the list and return its head.
   *
   * https://leetcode.com/problems/remove-nth-node-from-end-of-list/
   */
  public static Node<Integer> removeNthFromEnd(Node<Integer> head, int n) {
    throw new NotImplementedException();
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
    throw new NotImplementedException();
  }

}
