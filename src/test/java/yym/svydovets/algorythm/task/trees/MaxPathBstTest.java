package yym.svydovets.algorythm.task.trees;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import yym.svydovets.utils.BinaryTree;
import yym.svydovets.utils.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

class MaxPathBstTest {

  @BeforeEach
  void setUp() {
    MaxPathBst.answer = Integer.MIN_VALUE;
  }

  @Test
  void testMaxPathSum_v1() {
    var root = new TreeNode<>(-10);
    root.left = new TreeNode<>(9);
    root.right = new TreeNode<>(20);
    root.right.left = new TreeNode<>(-3);
    root.right.right = new TreeNode<>(8);
    root.right.left.left = new TreeNode<>(5);
    root.right.left.right = new TreeNode<>(-4);
    root.right.right.right = new TreeNode<>(-2);
    root.right.left.left.left = new TreeNode<>(-2);

    var expected = 30;

    var actual = MaxPathBst.maxPathSum(root);

    assertEquals(expected, actual);
  }

  @Test
  void testMaxPathSum_v2() {
    var root = new TreeNode<>(-2);
    root.left = new TreeNode<>(-1);
    int expected = -1;
    var actual = MaxPathBst.maxPathSum(root);
    assertEquals(expected, actual);
  }

  @Test
  void testMaxPathSum_v3() {
    var root = BinaryTree.of(1,2,3).root;
    int expected = 6;
    var actual = MaxPathBst.maxPathSum(root);
    assertEquals(expected, actual);
  }

  @Test
  void testMaxPathSum_v4() {
    var root = new TreeNode<>(-10);
    root.left = new TreeNode<>(9);
    root.right = new TreeNode<>(20);
    root.right.left = new TreeNode<>(15);
    root.right.right = new TreeNode<>(7);

    var expected = 42;

    var actual = MaxPathBst.maxPathSum(root);

    assertEquals(expected, actual);
  }

}