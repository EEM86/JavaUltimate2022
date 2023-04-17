package yym.svydovets.algorythm.task.trees;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import yym.svydovets.utils.BinaryTree;
import yym.svydovets.utils.TreeNode;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.class)
class InvertBinaryTreeTest {

  @Test
  @Order(1)
  void testInvertTree_v1() {
    var root = BinaryTree.of(4,2,7,1,3,6,9).root;

    var actual = InvertBinaryTree.invertTree(root);

    assertEquals(4, actual.value);
    assertEquals(7, actual.left.value);
    assertEquals(9, actual.left.left.value);
    assertEquals(6, actual.left.right.value);
    assertEquals(2, actual.right.value);
    assertEquals(3, actual.right.left.value);
    assertEquals(1, actual.right.right.value);
  }

  @Test
  @Order(2)
  void testInvertTree_v2() {
    var root = BinaryTree.of(2, 1, 3).root;

    var actual = InvertBinaryTree.invertTree(root);

    assertEquals(2, actual.value);
    assertEquals(3, actual.left.value);
    assertEquals(1, actual.right.value);
  }

  @Test
  @Order(3)
  void testInvertTree_v3() {
    var root = new TreeNode<Integer>();

    var actual = InvertBinaryTree.invertTree(root);

    assertNull(actual.value);
  }

  @Test
  @Order(4)
  void testMaxDepth_v1() {
    var root = BinaryTree.of(9,3,20,15,7).root;
    var expected = 3;

    var actual = InvertBinaryTree.maxDepth(root);

    assertEquals(expected, actual);
  }

  @Test
  @Order(5)
  void testMaxDepth_v2() {
    var root = BinaryTree.of(1,2).root;
    var expected = 2;

    var actual = InvertBinaryTree.maxDepth(root);

    assertEquals(expected, actual);
  }

  @Test
  @Order(6)
  void testIsSameTree_v1() {
    var first = BinaryTree.of(1,2,3).root;
    var second = BinaryTree.of(1,2,3).root;

    var actual = InvertBinaryTree.isSameTree(first, second);

    assertTrue(actual);
  }

  @Test
  @Order(7)
  void testIsSameTree_v2() {
    var first = BinaryTree.of(1,1,2).root;
    var second = new TreeNode<>(1);
    second.left = new TreeNode<>(2);
    second.right = new TreeNode<>(1);

    var actual = InvertBinaryTree.isSameTree(first, second);

    assertFalse(actual);
  }

  @Test
  @Order(8)
  void testIsSubTree_v1() {
    var first = BinaryTree.of(4,3,5,1,2).root;
    var second = BinaryTree.of(3,1,2).root;

    var actual = InvertBinaryTree.isSubtree(first, second);

    assertTrue(actual);
  }

  @Test
  @Order(8)
  /*    root
   *     4      subRoot
   *    3  5       3
   *   1 2        1 2
   *      0
   */
  void testIsSubTree_v2() {
    var first = BinaryTree.of(4,3,5,1,2,0).root;
    var second = BinaryTree.of(3,1,2).root;

    var actual = InvertBinaryTree.isSubtree(first, second);

    assertFalse(actual);
  }

}