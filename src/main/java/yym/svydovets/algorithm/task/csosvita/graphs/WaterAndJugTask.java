package yym.svydovets.algorithm.task.csosvita.graphs;

import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

/*
 * Die Hard 3 water bottles task.
 * You are given two jugs with capacities x liters and y liters.
 * You have an infinite water supply. Return whether the total amount of water
 * in both jugs may reach target using the following operations:
 * - Fill either jug completely with water.
 * - Completely empty either jug.
 * - Pour water from one jug into another until the receiving jug is full, or the transferring jug is empty.
 *
 * 1 <= x <= 10^6
 * 1 <= y <= 10^6
 * 0 <= target <= 10^6
 *
 * Sample Input 0:
 * 3 5 4
 * Sample Output 0:
 * 1
 * Explanation 0:
 * Steps to rich the target (0,4)
 * 1. Fill the 5-liter jug (0,5)
 * 2 Pour 5-l -> 3-l jug   (3,2)
 * 3. Empty the 3-liter jug (0,2)
 * 4. Pour 5-l -> 3-l jug   (2,0)
 * 5. Fill the 5-liter jug (2,5)
 * 6. Pour 5liter -> 3liter (3,4)
 * 7. Empty 3-liter jug     (0,4)
 */
public class WaterAndJugTask {
    int firstJug;
    int secondJug;
    int target;
    Set<State> visited;

    public WaterAndJugTask(int firstJug, int secondJug, int target) {
        this.firstJug = firstJug;
        this.secondJug = secondJug;
        this.target = target;
        visited = new HashSet<>();
    }

    public int waysToRichTarget() {
        return dfs(0, 0) ? 1 : 0;
    }

    private boolean dfs(int first, int second) {
        if (first + second == target) {
            return true;
        }
        State newState = new State(first, second);
        if (visited.contains(newState)) {
            return false;
        }
        visited.add(newState);
        boolean result = dfs(0, second)
                ||   dfs(first, 0)
                ||   dfs(this.firstJug, second)
                ||   dfs(first, this.secondJug)
                ||   dfs(first - Math.min(first, this.secondJug - second), second + Math.min(first, this.secondJug - second))
                ||   dfs(first + Math.min(second, this.firstJug - first), second - Math.min(second, this.firstJug - first));
        return result;
    }


    private static class State {
        public int x;
        public int y;

        public State(int x, int y) {
            this.x = x;
            this.y = y;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            State state = (State) o;
            return x == state.x && y == state.y;
        }

        @Override
        public int hashCode() {
            return Objects.hash(x, y);
        }
    }

}
