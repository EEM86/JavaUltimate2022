package yym.svydovets.algorithm.task.trees;

import yym.svydovets.utils.TreeNode;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Queue;

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
    if (root == null) return null;
    if (p.value < root.value && q.value < root.value) {
      return lowestCommonAncestor(root.left, p, q);
    } else if (p.value > root.value && q.value > root.value) {
      return lowestCommonAncestor(root.right, p, q);
    } else {
      return root;
    }
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
    var res = new ArrayList<List<Integer>>();
    if (root == null) return res;
    traverseDfs(res, root, 0);
    return res;
  }

  private static void traverseDfs(List<List<Integer>> res, TreeNode<Integer> root, int level) {
    if (root == null) return;

    if (level + 1 > res.size()) {
      res.add(new ArrayList<>());
    }

    List<Integer> lvlList = res.get(level);
    lvlList.add(root.value);

    traverseDfs(res, root.left, level + 1);
    traverseDfs(res, root.right, level + 1);
  }

  /*
   * See the previous description. This method uses Breadth first search.
   */
  public static List<List<Integer>> levelOrderBfs(TreeNode<Integer> root) {
    var res = new ArrayList<List<Integer>>();
    if (root == null) return res;
    Queue<TreeNode<Integer>> queue = new ArrayDeque<>();
    queue.add(root);
    while (!queue.isEmpty()) {
      int lvlSize = queue.size();
      var lvlList = new ArrayList<Integer>();
      for (int i = 0; i < lvlSize; i++) {
        var node = queue.poll();
        lvlList.add(node.value);
        if (node.left != null) {
          queue.add(node.left);
        }
        if (node.right != null) {
          queue.add(node.right);
        }
      }
      res.add(lvlList);
    }
    return res;
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
    var inElToIdx = new HashMap<Integer, Integer>();
    for (int i = 0; i < inorder.length; i++) {
      inElToIdx.put(inorder[i], i);
    }
    int preOrderIdx = 0;
    int inLeft = 0, inRight = inorder.length - 1;
    return splitTree(inElToIdx, preorder, preOrderIdx, inLeft, inRight);
  }

  private static TreeNode<Integer> splitTree(HashMap<Integer, Integer> inElToIdx,
                                            int[] preorder,
                                            int preOrderIdx,
                                            int inLeft,
                                            int inRight) {
    int rootVal = preorder[preOrderIdx];
    int inMidIdx = inElToIdx.get(rootVal);
    var node = new TreeNode<>(rootVal);
    if (inMidIdx > inLeft) {
      int end = inMidIdx - 1;
      node.left = splitTree(inElToIdx, preorder, preOrderIdx+1, inLeft, end);
    }
    if (inMidIdx < inRight) {
      int rightSubTreeIdxBegins = preOrderIdx + 1 + (inMidIdx - inLeft);
      int start = inMidIdx + 1;
      node.right = splitTree(inElToIdx, preorder, rightSubTreeIdxBegins, start, inRight);
    }
    return node;
  }
}
