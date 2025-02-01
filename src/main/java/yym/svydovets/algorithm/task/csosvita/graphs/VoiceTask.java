package yym.svydovets.algorithm.task.csosvita.graphs;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/*
 * There are people with voice power. Find minimum distance for the voice power that is able
 * to connect all people, use accuracy <= 10^6
 *
 * 1 <= n <= 50
 * -10000 <= xi <= 10000
 * -10000 <= yi <= 10000
 *
 * Example: [3,2], [3,3], [3,7]. The minimum distance between them is 4.
 */
public class VoiceTask {
    private boolean[] visited;
    private List<List<Node>> adjacencyList;
    private int[][] people;
    private double max;

    public VoiceTask(int[][] people) {
        this.people = people;
        this.visited = new boolean[people.length];
        adjacencyList = new ArrayList<>(people.length);

        for (int i = 0; i < people.length; i++) {
            adjacencyList.add(new ArrayList<>());
        }
        generateAdjList();
    }

    public double findMinimumVoiceNeeded() {
        double bad = 0;
        double good = max;

        while (good - bad > 1e-6) {
            double cand = bad + (good - bad) / 2;
            if (canCommunicate(cand)) {
                good = cand;
            } else {
                bad = cand;
            }
        }
        return good;
    }

    private void generateAdjList() {
        final int n = people.length;
        double maxDist = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                double dist = calcDistance(people[i], people[j]);
                adjacencyList.get(i).add(new Node(j, dist));
                adjacencyList.get(j).add(new Node(i, dist));
                maxDist = Math.max(maxDist, dist);
            }
        }
        max = maxDist;
    }

    private boolean canCommunicate(double distance) {
        Arrays.fill(visited, false);
        Queue<Integer> queue = new LinkedList<>();
        queue.add(0);
        visited[0] = true;
        int count = 1;

        while (!queue.isEmpty()) {
            int node = queue.poll();
            for (var u : adjacencyList.get(node)) {
                if (!visited[u.neighbor] && u.distance <= distance) {
                    visited[u.neighbor] = true;
                    queue.add(u.neighbor);
                    count++;
                }
            }
        }
        return count == adjacencyList.size();
    }

    private static double calcDistance(int[]first, int[] second) {
        double firstDistance = first[0] - second[0];
        double secondDistance = first[1] - second[1];
        return Math.sqrt(Math.pow(firstDistance,2) + Math.pow(secondDistance,2));
    }

    private static class Node {
        public int neighbor;
        public double distance;

        public Node(int neighbor, double distance) {
            this.neighbor = neighbor;
            this.distance = distance;
        }
    }

}