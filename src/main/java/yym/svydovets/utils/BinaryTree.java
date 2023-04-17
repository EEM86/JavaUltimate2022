package yym.svydovets.utils;

import java.util.Arrays;
import java.util.Objects;
import java.util.function.Consumer;

public class BinaryTree<T extends Comparable<? super T>> {

  public TreeNode<T> root;
  public int size;

  @SafeVarargs
  public static <T extends Comparable<T>> BinaryTree<T> of(T... elements) {
    var tree = new BinaryTree<T>();
    Arrays.stream(elements).forEach(tree::insert);
    return tree;
  }

  public boolean insert(T element) {
    Objects.requireNonNull(element);
    boolean isInserted = insertElement(element);
    if (isInserted) {
      size++;
    }
    return isInserted;
  }

  private boolean insertElement(T element) {
    if (root == null) {
      root = new TreeNode<>(element);
      return true;
    } else {
      return insertToSubTree(root, element);
    }
  }

  private boolean insertToSubTree(TreeNode<T> node, T element) {
    if (node.value.compareTo(element) > 0) {
      return insertToTheLeft(node, element);
    } else if (node.value.compareTo(element) < 0) {
      return insertToTheRight(node, element);
    } else {
      return false;
    }
  }

  private boolean insertToTheRight(TreeNode<T> node, T element) {
    if (node.right == null) {
      node.right = new TreeNode<>(element);
      return true;
    } else {
      return insertToSubTree(node.right, element);
    }
  }

  private boolean insertToTheLeft(TreeNode<T> node, T element) {
    if (node.left == null) {
      node.left = new TreeNode<>(element);
      return true;
    } else {
      return insertToSubTree(node.left, element);
    }
  }

  public boolean contains(T element) {
    Objects.requireNonNull(element);
    return findChildByNode(root, element) != null;
  }

  private TreeNode<T> findChildByNode(TreeNode<T> node, T element) {
    if (node == null) {
      return null;
    } else if (node.value.compareTo(element) == 0) {
      return node;
    } else if (node.value.compareTo(element) < 0) {
      return findChildByNode(node.right, element);
    } else {
      return findChildByNode(node.left, element);
    }
  }

  public int size() {
    return size;
  }

  public int depth() {
    return root == null ? 0 : depth(root) - 1;
  }

  private int depth(TreeNode<T> node) {
    if (node == null) {
      return 0;
    } else {
      return 1 + Math.max(depth(node.left), depth(node.right));
    }
  }

  public void inOrderTraversal(Consumer<T> consumer) {
    inOrderTraversal(root, consumer);
  }

  private void inOrderTraversal(TreeNode<T> node, Consumer<T> consumer) {
    if (node != null) {
      inOrderTraversal(node.left, consumer);
      consumer.accept(node.value);
      inOrderTraversal(node.right, consumer);
    }
  }
  
}
