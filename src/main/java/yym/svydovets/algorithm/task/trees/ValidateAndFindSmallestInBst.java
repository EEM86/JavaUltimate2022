package yym.svydovets.algorithm.task.trees;

import org.apache.commons.lang3.NotImplementedException;
import yym.svydovets.utils.TreeNode;

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
    throw new NotImplementedException();
  }

  // The same task but using Iterative In Order Traversal algo
  public static boolean isValidInOrderTraversal(TreeNode<Integer> root) {
    throw new NotImplementedException();
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
    throw new NotImplementedException();
  }
}
