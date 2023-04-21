package yym.svydovets.algorythm.task.trees;

import org.apache.commons.lang3.NotImplementedException;
import yym.svydovets.utils.TreeNode;

import java.util.List;

public class LcaAndTraversalBst {

  /*
   * Medium
   * Given a binary search tree (BST), find the lowest common ancestor (LCA)
   * node of two given nodes in the BST.
   * According to the definition of LCA on Wikipedia: “The lowest common ancestor
   * is defined between two nodes p and q as the lowest node in T
   * that has both p and q as descendants (where we allow a node to be a descendant of itself).”
   *
   * Example: Input: root = [6,2,8,0,4,7,9,3,5], p = 2, q = 8. Output: 6
   *             6
   *        2         8
   *      0   4     7   9
   *         3 5
   *
   * https://leetcode.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/
   */
  public static TreeNode<Integer> lowestCommonAncestor(TreeNode<Integer> root, TreeNode<Integer> p, TreeNode<Integer> q) {
    throw new NotImplementedException();
  }

  /*
   * Medium
   * Given the root of a binary tree, return the level order traversal of its nodes' values.
   * (i.e., from left to right, level by level).
   *
   * Example: Input: root = [9,3,20,15,25]. Output: [[9],[3,20],[15,25]]
   *         9
   *      3     20
   *           15 25
   *
   * https://leetcode.com/problems/binary-tree-level-order-traversal/description/
   */
  public static List<List<Integer>> levelOrderDfs(TreeNode<Integer> root) {
    throw new NotImplementedException();
  }

  /*
   * See the previous description. This method uses Breadth first search.
   */
  public static List<List<Integer>> levelOrderBfs(TreeNode<Integer> root) {
    throw new NotImplementedException();
  }

  /*
   * Medium
   * Given two integer arrays preorder and inorder where preorder is
   * the preorder traversal of a binary tree and inorder is
   * the inorder traversal of the same tree, construct and return the binary tree.
   *
   * Example: Input: preorder = [3,9,20,15,7], inorder = [9,3,15,20,7]
   * Output: [3,9,20,null,null,15,7] ->   3
   *                                    9  20
   *                                      15 7
   * https://leetcode.com/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/
   */
  public static TreeNode<Integer> buildTree(int[] preorder, int[] inorder) {
    throw new NotImplementedException();
  }

}
