package yym.svydovets.algorythm.task.graphs;

import java.util.stream.IntStream;

/*
 * Medium (UnionFind algorythm for the solution)
 * Complexity: time - O(log n), space - O(n)
 *
 * You have a graph of n nodes. You are given an integer n
 * and an array edges where edges[i] = [Ai, Bi] indicates
 * that there is an edge between A1 and B1 in the graph.
 * Return the number of connected components in the graph;
 *
 * Example:
 * [ 0 ] --- [ 1 ]    [ 3 ]
 *             |        |
 *           [ 2 ]    [ 4 ]
 * Intput: n = 5, edges = [[0,1],[1,2],[3,4]]
 * Output: 2
 */
public class NumberOfConnected {

  private int[] parents;
  private int[] ranks;

  public int countComponents(int n, int[][] edges) {
    parents = IntStream.range(0, n).toArray();
    ranks = IntStream.range(0, n).toArray();

    int res = n;
    for (int[] edge : edges) {
      if (union(edge[0], edge[1])) {
        res--;
      }
    }
    return res;
  }

  private int find(int node) {
    var res = node;

    while (parents[res] != res) {
      parents[res] = parents[parents[res]]; // optimization
      res = parents[res];
    }
    return res;
  }

  private boolean union(int first, int second) {
    int p1 = find(first), p2 = find(second);

    if (p1 == p2) return false;

    if (ranks[p2] > ranks[p1]) {
      parents[p1] = p2;
      ranks[p2] += ranks[p1];
    } else {
      parents[p2] = p1;
      ranks[p1] += ranks[p2];
    }
    return true;
  }

}
