package yym.svydovets.algorythm.task.trees;

import yym.svydovets.utils.TreeNode;

public class InvertBinaryTree {

  /*
   * Easy
   * Given the root of a binary tree, invert the tree, and return its root.
   * Example: Input: root = [4,2,7,1,3,6,9], Output: [4,7,2,9,6,3,1]
   * https://leetcode.com/problems/invert-binary-tree/description/
   */
  public static TreeNode<Integer> invertTree(TreeNode<Integer> root) {
    if (root == null) {
      return null;
    }
    var right = invertTree(root.right);
    var left = invertTree(root.left);
    root.left = right;
    root.right = left;
    return root;
  }

  /*
   * Easy
   * Given the root of a binary tree, return its maximum depth.
   * A binary tree's maximum depth is the number of nodes along
   * the longest path from the root node down to the farthest leaf node.
   *
   * Example Input: root = [9,3,20,15,7], Output: 3
   * https://leetcode.com/problems/maximum-depth-of-binary-tree/description/
   */
  public static int maxDepth(TreeNode<Integer> root) {
    if (root == null) {
      return 0;
    }
    return 1 + Math.max(maxDepth(root.left), maxDepth(root.right));
  }

  /*
   * Easy
   * Given the roots of two binary trees p and q,
   * write a function to check if they are the same or not.
   * Two binary trees are considered the same if
   * they are structurally identical, and the nodes have the same value.
   * https://leetcode.com/problems/same-tree/description/
   */
  public static boolean isSameTree(TreeNode<Integer> p, TreeNode<Integer> q) {
    if (p == null && q == null) return true;
    if (p == null || q == null) return false;
    if (p.value.intValue() != q.value.intValue()) return false;
    return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
  }

  /*
   * Easy
   * Given the roots of two binary trees root and subRoot,
   * return true if there is a subtree of root with the same structure
   * and node values of subRoot and false otherwise.
   * A subtree of a binary tree is a tree that consists of a node in tree
   * and all of this node's descendants. The tree could also be considered
   * as a subtree of itself.
   * Example, Input: root = [3,4,5,1,2], subRoot = [4,1,2]. Output: true
   * https://leetcode.com/problems/subtree-of-another-tree/description/
   */
  public static boolean isSubTree(TreeNode<Integer> root, TreeNode<Integer> subRoot) {
    if (root == null) return false;
    if (isSameTree(root, subRoot)) return true;
    return isSubTree(root.left, subRoot) || isSubTree(root.right, subRoot);
  }



}
