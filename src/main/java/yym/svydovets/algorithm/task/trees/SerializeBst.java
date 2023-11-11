package yym.svydovets.algorithm.task.trees;

import yym.svydovets.utils.TreeNode;

import java.util.LinkedList;

public class SerializeBst {

  /*
   * Hard
   * Serialize into the String
   * Example:
   *          1
   *       2    3
   *          4   5
   * Should be serialized into [1,2,3,null,null,4,5,null,null,null,null]
   *
   * https://leetcode.com/problems/serialize-and-deserialize-binary-tree/description/
   */
  public static String serialize(TreeNode<Integer> root) {
    var sb = new StringBuilder();

    var queue = new LinkedList<TreeNode<Integer>>();
    queue.add(root);

    while (!queue.isEmpty()) {
      var current = queue.poll();
      if (current == null) {
        sb.append("null,");
        continue;
      }
      sb.append(current.value).append(",");
      queue.add(current.left);
      queue.add(current.right);
    }

    sb.deleteCharAt(sb.length() - 1);
    return sb.toString();
  }

  /*
   * Deserialize by the pattern described in #serialize
   */
  public static TreeNode<Integer> deserialize(String data) {
    if (data == null || data.isEmpty()) return null;
    var queue = new LinkedList<TreeNode<Integer>>();

    var values = data.split(",");
    var root = new TreeNode<>(Integer.parseInt(values[0]));
    queue.add(root);

    for (int i = 1; i < values.length; i++) {
      var current = queue.poll();
      if (!values[i].equals("null")) {
        var left = new TreeNode<>(Integer.parseInt(values[i]));
        current.left = left;
        queue.add(left);
      }
      if (!values[++i].equals("null")) {
        var right = new TreeNode<>(Integer.parseInt(values[i]));
        current.right = right;
        queue.add(right);
      }
    }
    return root;
  }

}
