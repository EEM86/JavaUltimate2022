package yym.svydovets.algorythm.task.trees;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import yym.svydovets.utils.BinaryTree;
import yym.svydovets.utils.TreeNode;

import static org.junit.jupiter.api.Assertions.*;
import static yym.svydovets.algorythm.task.trees.ValidateAndFindSmallestInBst.isValidBST;
import static yym.svydovets.algorythm.task.trees.ValidateAndFindSmallestInBst.isValidInOrderTraversal;
import static yym.svydovets.algorythm.task.trees.ValidateAndFindSmallestInBst.kthSmallest;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ValidateAndFindSmallestInBstTest {

  @Test
  @Order(1)
  void testIsValid_v1() {
    var root = BinaryTree.of(2,1,3).root;

    var actual = isValidBST(root);

    assertTrue(actual);
  }

  @Test
  @Order(2)
  void testIsValid_v2() {
    var root = new TreeNode<>(5);
    root.left = new TreeNode<>(1);
    root.right = new TreeNode<>(4);
    root.right.left = new TreeNode<>(3);
    root.right.right = new TreeNode<>(6);

    var actual = isValidBST(root);

    assertFalse(actual);
  }

  @Test
  @Order(3)
  void testIsValid_v3() {
    var root = BinaryTree.of(7,3,15,2,5,9,18).root;

    var actual = isValidBST(root);

    assertTrue(actual);
  }

  @Test
  @Order(4)
  void testIsValid_v4() {
    var root = BinaryTree.of(2,1,3).root;

    var actual = isValidInOrderTraversal(root);

    assertTrue(actual);
  }

  @Test
  @Order(5)
  void testIsValid_v5() {
    var root = new TreeNode<>(5);
    root.left = new TreeNode<>(1);
    root.right = new TreeNode<>(4);
    root.right.left = new TreeNode<>(3);
    root.right.right = new TreeNode<>(6);

    var actual = isValidInOrderTraversal(root);

    assertFalse(actual);
  }

  @Test
  @Order(6)
  void testIsValid_v6() {
    var root = BinaryTree.of(7,3,15,2,5,9,18).root;

    var actual = isValidInOrderTraversal(root);

    assertTrue(actual);
  }

  @Test
  @Order(7)
  void testIsValid_v7() {
    var root = new TreeNode<>(2);
    root.left = new TreeNode<>(2);
    root.right = new TreeNode<>(2);

    var actual = isValidInOrderTraversal(root);

    assertFalse(actual);
  }

  @Test
  @Order(8)
  void testKthSmallest_v1() {
    var root = BinaryTree.of(3,1,4,2).root;
    var k = 1;
    var expected = 1;

    var actual = kthSmallest(root, k);

    assertEquals(expected, actual);
  }

  @Test
  @Order(9)
  void testKthSmallest_v2() {
    var root = new TreeNode<>(5);
    root.left = new TreeNode<>(3);
    root.right = new TreeNode<>(6);
    root.left.left = new TreeNode<>(2);
    root.left.right = new TreeNode<>(4);
    root.left.left.left = new TreeNode<>(1);
    var k = 3;
    var expected = 3;

    var actual = kthSmallest(root, k);

    assertEquals(expected, actual);
  }

}