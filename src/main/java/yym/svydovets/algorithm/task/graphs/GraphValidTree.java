package yym.svydovets.algorithm.task.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class GraphValidTree {

  /*
   * Medium Premium
   * Given n nodes labeled from 0 to n - 1 and a list of undirected
   * edges (each edge has a pair of nodes), write a function to check
   * whether these edges make up a valid tree.
   *
   * Example:
   * Input = 5, edges = [{0,1}, {0,2}, {0,3}, {1,4}]
   * Output: true
   *         0
   *    1    2    3
   *      4
   */
  public boolean isValidTree(int n, int[][] edges) {
    if (n == 0 || n == 1) return true;
    if (edges == null || edges.length == 0) return false;
    var map = new HashMap<Integer, List<Integer>>();
    for (int[] edge : edges) {
      map.putIfAbsent(edge[0], new ArrayList<>());
      map.putIfAbsent(edge[1], new ArrayList<>());
      map.get(edge[0]).add(edge[1]);
      map.get(edge[1]).add(edge[0]);
    }

    var visited = new HashSet<Integer>();
    return dfs(map, edges[0][0], visited, -1) && n == visited.size();
  }

  private boolean dfs(Map<Integer, List<Integer>> map, int cur, Set<Integer> visited, int prev) {
    if (visited.contains(cur)) return false;
    visited.add(cur);

    for (var el : map.get(cur)) {
      if (el == prev) continue;
      if (!dfs(map, el, visited, cur)) {
        return false;
      }
    }
    return true;
  }

}
