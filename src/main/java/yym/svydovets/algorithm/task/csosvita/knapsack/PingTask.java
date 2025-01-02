package yym.svydovets.algorithm.task.csosvita.knapsack;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

public class PingTask {

    /*
     * In this problem, you must implement your own Queue class
     * (enqueue and dequeue operations should work in constant time)
     *
     * Implement the RecentCounter class:
     * - RecentCounter() Initializes the counter with zero recent requests.
     * - int ping(int t) Adds a new request at time t, where t represents some time in milliseconds,
     * and returns the number of requests that has happened in the past 3000 milliseconds
     * (including the new request). Specifically, return the number of requests that have
     * happened in the inclusive range [t - 3000, t]
     *
     * It is guaranteed that every call to ping uses a strictly larger value of t than the previous call.
     *
     * 1 <= t <= 10^9
     *
     * Sample Input 0:
     * 1 100 3001 3002
     * Sample Output 0:
     * 1 2 3 3
     *
     * RecentCounter recentCounter = new RecentCounter();
     * recentCounter.ping(1); // requests = [1], range is [-2999,1], return 1
     * recentCounter.ping(100); // requests = [1, 100], range is [-2900,100], return 2
     * recentCounter.ping(3001); // requests = [1, 100, 3001], range is [1,3001], return 3
     * recentCounter.ping(3002); // requests = [1, 100, 3001, 3002], range is [2,3002], return 3
     */
    public static class RecentCounter {
        private int requests;
        private int window = 3000;
        private Queue<Integer> queue = new ArrayDeque<>();

        public int ping(int t) {
            queue.add(t);
            int firstExpected = t - window;
            while (!queue.isEmpty() && queue.peek() < firstExpected) {
                queue.poll();
            }
            return queue.size();
        }
    }

    public static void main(String[] args) {
        RecentCounter rc = new RecentCounter();
        var sc = new Scanner(System.in);
        String line = sc.nextLine();
        final String[] points = line.split(" ");
        var sb = new StringBuilder();
        for (String p : points) {
            int num = Integer.parseInt(p);
            sb.append(rc.ping(num)).append(" ");
        }
        if (!sb.isEmpty()) {
            sb.deleteCharAt(sb.length() - 1);
        }
        System.out.println(sb);
    }

}
