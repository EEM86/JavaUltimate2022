package yym.svydovets.algorythm.task.trees;

import org.junit.jupiter.api.Test;
import yym.svydovets.utils.TreeNode;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SerializeBstTest {

  @Test
  void testSerialize() {
    var root = new TreeNode<>(1);
    root.left = new TreeNode<>(2);
    root.right = new TreeNode<>(3);
    root.right.left = new TreeNode<>(4);
    root.right.right = new TreeNode<>(5);

    var expected = "1,2,3,null,null,4,5,null,null,null,null";
    var actual = SerializeBst.serialize(root);

    assertEquals(expected, actual);
  }

  @Test
  void testDeserialize() {
    var input = "1,2,3,null,null,4,5,null,null,null,null";

    var actual = SerializeBst.deserialize(input);

    assertEquals(1, actual.value);
    assertEquals(2, actual.left.value);
    assertEquals(3, actual.right.value);
    assertEquals(4, actual.right.left.value);
    assertEquals(5, actual.right.right.value);
  }

}