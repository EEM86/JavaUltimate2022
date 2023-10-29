package yym.svydovets.algorythm.task.graphs;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

public class CourseSchedule {

  /*
   * Medium
   * There are a total of numCourses courses you have to take, labeled from 0 to numCourses - 1.
   * You are given an array prerequisites where prerequisites[i] = [ai, bi] indicates
   * that you must take course bi first if you want to take course ai.
   *
   * For example, the pair [0, 1], indicates that to take course 0 you have to first take course 1.
   * Return true if you can finish all courses. Otherwise, return false.
   *
   * Example:
   * Input: numCourses = 2, prerequisites = [[1,0],[0,1]]
   * Output: false
   * Explanation: There are a total of 2 courses to take.
   * To take course 1 you should have finished course 0, and to take course 0 you should also have finished course 1.
   * So it is impossible.
   */
  public boolean canFinish(int numCourses, int[][] prerequisites) {
    var map = new HashMap<Integer, List<Integer>>();
    for (int i = 0; i < numCourses; i++) {
      map.put(i, new ArrayList<>());
    }

    for (int[] prerequisite : prerequisites) {
      map.get(prerequisite[0]).add(prerequisite[1]);
    }

    var visitSet = new HashSet<Integer>();

    while (!map.isEmpty()) {
      if (!dfs(map, visitSet)) {
        return false;
      }
    }
    return true;
  }

  private boolean dfs(Map<Integer, List<Integer>> map, Set<Integer> set) {
    for (var key : map.keySet()) {
      var values = map.get(key);
      if (set.containsAll(values)) {
        set.add(key);
        map.remove(key);
        return true;
      }
    }
    return false;
  }

  public boolean canFinishDfs(int numCourses, int[][] prerequisites) {
    int[] indegree = new int[numCourses];
    List<List<Integer>> adj = new ArrayList<>(numCourses);

    for (int i = 0; i < numCourses; i++) {
      adj.add(new ArrayList<>());
    }

    for (int[] prerequisite : prerequisites) {
      adj.get(prerequisite[1]).add(prerequisite[0]);
      indegree[prerequisite[0]]++;
    }

    Queue<Integer> queue = new LinkedList<>();
    // Push all the nodes with indegree zero in the queue.
    for (int i = 0; i < numCourses; i++) {
      if (indegree[i] == 0) {
        queue.offer(i);
      }
    }

    int nodesVisited = 0;
    while (!queue.isEmpty()) {
      int node = queue.poll();
      nodesVisited++;

      for (int neighbor : adj.get(node)) {
        // Delete the edge "node -> neighbor".
        indegree[neighbor]--;
        if (indegree[neighbor] == 0) {
          queue.offer(neighbor);
        }
      }
    }

    return nodesVisited == numCourses;
  }

}
