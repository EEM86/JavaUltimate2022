package yym.svydovets.algorythm.task.trees;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import yym.svydovets.utils.BinaryTree;
import yym.svydovets.utils.TreeNode;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

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
}