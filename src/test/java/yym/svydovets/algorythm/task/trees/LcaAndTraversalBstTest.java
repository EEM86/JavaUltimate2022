package yym.svydovets.algorythm.task.trees;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import yym.svydovets.utils.BinaryTree;
import yym.svydovets.utils.TreeNode;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static yym.svydovets.algorythm.task.trees.LcaAndTraversalBst.buildTree;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class LcaAndTraversalBstTest {

  @Test
  @Order(1)
  void testLca_v1() {
    var tree = BinaryTree.of(6,2,8,0,4,7,9,3,5);
    var p = new TreeNode<>(2);
    var q = new TreeNode<>(8);

    var expected = 6;

    var actual = LcaAndTraversalBst.lowestCommonAncestor(tree.root, p, q);

    assertEquals(expected, actual.value);
  }

  @Test
  @Order(2)
  void testLca_v2() {
    var tree = BinaryTree.of(6,2,8,0,4,7,9,3,5);
    var p = new TreeNode<>(2);
    var q = new TreeNode<>(4);

    var expected = 2;

    var actual = LcaAndTraversalBst.lowestCommonAncestor(tree.root, p, q);

    assertEquals(expected, actual.value);
  }

  @Test
  @Order(3)
  void testLevelOrderDfs_v1() {
    var tree = BinaryTree.of(9,3,20,15,25);
    var expected = List.of(List.of(9), List.of(3,20), List.of(15,25));

    var actual = LcaAndTraversalBst.levelOrderDfs(tree.root);

    assertEquals(expected, actual);
  }

  @Test
  @Order(4)
  void testLevelOrderDfs_v2() {
    var tree = BinaryTree.of(1);
    var expected = List.of(List.of(1));

    var actual = LcaAndTraversalBst.levelOrderDfs(tree.root);

    assertEquals(expected, actual);
  }

  @Test
  @Order(5)
  void testLevelOrderBfs_v1() {
    var tree = BinaryTree.of(9,3,20,15,25);
    var expected = List.of(List.of(9), List.of(3,20), List.of(15,25));

    var actual = LcaAndTraversalBst.levelOrderBfs(tree.root);

    assertEquals(expected, actual);
  }

  @Test
  @Order(6)
  void testLevelOrderBfs_v2() {
    var tree = BinaryTree.of(1);
    var expected = List.of(List.of(1));

    var actual = LcaAndTraversalBst.levelOrderBfs(tree.root);

    assertEquals(expected, actual);
  }

  @Test
  @Order(7)
  void testBuildTree_v1() {
    int[] preorder = new int[]{3,9,20,15,7};
    int[] inOrder = new int[]{9,3,15,20,7};

    var root = buildTree(preorder, inOrder);

    assertEquals(3, root.value);
    assertEquals(9, root.left.value);
    assertEquals(20, root.right.value);
    assertEquals(15, root.right.left.value);
    assertEquals(7, root.right.right.value);
  }

  @Test
  @Order(8)
  void testBuildTree_v2() {
    int[] preorder = new int[]{8,2,7,1,9,3,6};
    int[] inOrder = new int[]{7,2,1,8,3,9,6};

    var root = buildTree(preorder, inOrder);

    assertEquals(8, root.value);
    assertEquals(2, root.left.value);
    assertEquals(7, root.left.left.value);
    assertEquals(1, root.left.right.value);
    assertEquals(9, root.right.value);
    assertEquals(3, root.right.left.value);
    assertEquals(6, root.right.right.value);
  }
}