package yym.svydovets.algorythm.task.graphs;

import yym.svydovets.utils.GraphNode;

import java.util.HashMap;
import java.util.Map;

public class DeepClone {

  /*
   * Medium
   * Given a reference of a node in a connected undirected graph.
   * Return a deep copy (clone) of the graph.
   * Each node in the graph contains a value (int) and a list (List[Node]) of its neighbors.
   *
   * [ 1 ]    ----    [ 2 ]                      ( 1 )    ----    ( 2 )
   *   |                |               ==>        |                |
   *   |                |                          |                |
   * [ 3 ]    ----    [ 4 ]                      ( 3 )    ----    ( 4  )
   *
   * Input: adjList = [[2,4],[1,3],[2,4],[1,3]]
   * Output: [[2,4],[1,3],[2,4],[1,3]]
   * Explanation: There are 4 nodes in the graph.
   * 1st node (val = 1)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
   * 2nd node (val = 2)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
   * 3rd node (val = 3)'s neighbors are 2nd node (val = 2) and 4th node (val = 4).
   * 4th node (val = 4)'s neighbors are 1st node (val = 1) and 3rd node (val = 3).
   */
  public GraphNode cloneGraph(GraphNode node) {
    if (node == null) return null;
    var map = new HashMap<GraphNode, GraphNode>();
    return dfs(map, node);
  }

  private GraphNode dfs(Map<GraphNode, GraphNode> map, GraphNode node) {
    if (map.containsKey(node)) {
      return map.get(node);
    }
    var copy = new GraphNode(node.val);
    map.put(node, copy);

    for (var el : node.neighbors) {
      copy.neighbors.add(dfs(map, el));
    }
    return copy;
  }

}
