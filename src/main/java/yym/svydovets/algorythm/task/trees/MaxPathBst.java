package yym.svydovets.algorythm.task.trees;

import org.apache.commons.lang3.NotImplementedException;
import yym.svydovets.utils.TreeNode;

public class MaxPathBst {

  /*
   * Hard
   * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes
   * in the sequence has an edge connecting them. A node can only appear in the sequence at most once.
   * Note that the path does not need to pass through the root.
   * The path sum of a path is the sum of the node's values in the path.
   * Given the root of a binary tree, return the maximum path sum of any non-empty path.
   *
   * Example: Input: root = [-10,9,20,null,null,15,7]. Output: 42
   * Explanation: The optimal path is 15 -> 20 -> 7 with a path sum of 15 + 20 + 7 = 42.
   *            -10
   *         9        20
   *                15   7
   * https://leetcode.com/problems/binary-tree-maximum-path-sum/
   */
  static int answer = Integer.MIN_VALUE;

  public static int maxPathSum(TreeNode<Integer> root) {
    throw new NotImplementedException();
  }

}
