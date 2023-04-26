package yym.svydovets.algorythm.task.nodes;

import yym.svydovets.utils.Node;

public class EasyNode {

  /*
   * Easy
   * Given head, the head of a linked list, determine if the linked list has a cycle in it.
   * There is a cycle in a linked list if there is some node in the list that can be
   * reached again by continuously following the next pointer.
   * Internally, pos is used to denote the index of the node that tail's
   * next pointer is connected to. Note that pos is not passed as a parameter.
   *
   * Return true if there is a cycle in the linked list. Otherwise, return false.
   *
   * https://leetcode.com/problems/linked-list-cycle/
   */
  public static boolean hasCycle(Node<?> head) {
    Node<?> slow = head;
    Node<?> fast = head;

    while (fast != null && fast.next != null) {
      slow = slow.next;
      fast = fast.next.next;

      if (slow == fast) {
        return true;
      }
    }
    return false;
  }

  /*
   * Easy
   * Given the head of a singly linked list,
   * reverse the list, and return the reversed list.
   *
   * Example: Input: head = [1,2,3,4,5]. Output: [5,4,3,2,1]
   *
   * https://leetcode.com/problems/reverse-linked-list/
   */
  public static Node<Integer> reverseList(Node<Integer> head) {
    var cur = head;
    Node<Integer> prev = null;

    while (cur != null) {
      var next = cur.next;
      cur.next = prev;
      prev = cur;
      cur = next;
    }
    return prev;
  }

  /*
   * Easy
   * You are given the heads of two sorted linked lists list1 and list2.
   * Merge the two lists in a one sorted list. The list should be made by
   * splicing together the nodes of the first two lists.
   *
   * Return the head of the merged linked list.
   * Example: Input: list1 = [1,2,4], list2 = [1,3,4].
   * Output: [1,1,2,3,4,4]
   *
   * https://leetcode.com/problems/merge-two-sorted-lists/
   */
  public static Node<Integer> mergeTwoLists(Node<Integer> list1, Node<Integer> list2) {
    var initNode = new Node<>(0);
    Node<Integer> cur = initNode;
    initNode.next = cur;

    while (list1 != null && list2 != null) {
      if (list1.value <= list2.value) {
        cur.next = list1;
        list1 = list1.next;
      } else {
        cur.next = list2;
        list2 = list2.next;
      }
      cur = cur.next;
    }

    cur.next = list1 == null ? list2 : list1;
    return initNode.next;
  }

}
