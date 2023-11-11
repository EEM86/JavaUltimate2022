package yym.svydovets.algorithm.task.trees;

import yym.svydovets.utils.TreeNode;

import java.util.ArrayList;
import java.util.Stack;

public class ValidateAndFindSmallestInBst {

  /*
   * Medium
   * Given the root of a binary tree, determine if it is a valid binary search tree (BST).
   * A valid BST is defined as follows:
   *    The left subtree of a node contains only nodes with keys less than the node's key.
   *    The right subtree of a node contains only nodes with keys greater than the node's key.
   *    Both the left and right subtrees must also be binary search trees.
   * Example (true / false):
   *   2                   5
   * 1   3               1   4
   *                        3 6
   * https://leetcode.com/problems/validate-binary-search-tree/description/
   */
  public static boolean isValidBST(TreeNode<Integer> root) {
    // recursive traversal
    return validate(root, null, null);
  }

  private static boolean validate(TreeNode<Integer> root, Integer low, Integer high) {
    if (root == null) return true;

    // The current node's value must be between low and high
    if ((low != null && root.value <= low) || (high != null && root.value >= high)) {
      return false;
    }

    return validate(root.left, low, root.value) && validate(root.right, root.value, high);
  }

  // The same task but using Iterative In Order Traversal algo
  public static boolean isValidInOrderTraversal(TreeNode<Integer> root) {
    if (root == null) return true;
    var stack = new Stack<TreeNode<Integer>>();
    TreeNode<Integer> previous = null;

    while (root != null || !stack.isEmpty()) {
      while (root != null) {
        stack.push(root);
        root = root.left;
      }
      root = stack.pop();

      // If the next element in InOrderTraversal
      // is smaller than the previous one, that's not BST
      if (previous != null && root.value <= previous.value) {
        return false;
      }
      previous = root;
      root = root.right;
    }
    return true;
  }

  /*
   * Medium
   * Given the root of a binary search tree, and an integer k,
   * return the kth smallest value (1-indexed)
   * of all the values of the nodes in the tree.
   *
   * https://leetcode.com/problems/kth-smallest-element-in-a-bst/description/
   */
  public static int kthSmallest(TreeNode<Integer> root, int k) {
    int visited = 0;
    var stack = new Stack<TreeNode<Integer>>();
    var cur = root;

    while (cur != null || !stack.isEmpty()) {
      while (cur != null) {
        stack.push(cur);
        cur = cur.left;
      }
      cur = stack.pop();
      visited++;
      if (visited == k) {
        return cur.value;
      }
      cur = cur.right;
    }
    return -1;
  }
}
