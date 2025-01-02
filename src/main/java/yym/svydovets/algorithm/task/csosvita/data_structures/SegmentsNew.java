package yym.svydovets.algorithm.task.csosvita.data_structures;

import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class SegmentsNew {

    public static void main(String[] args) {
        var sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }
        final int res = countSegments(arr, k);
        System.out.println(res);
    }

    public static int countSegments(long[] arr, int k) {
        int n = arr.length;
        int cnt = 0;

        Segment segment = new Segment(k);

        int l = 0;
        for (int r = 0; r < n; r++) {
            segment.add(arr[r]);
            while (!segment.isGood()) {
                segment.remove(arr[l]);
                l++;
            }
            cnt += r - l + 1;  // Count all subarrays ending at r
        }

        return cnt;
    }

    static class Segment {
        private Queue<Long> inQueue;
        private Queue<Long> outQueue;
        private Deque<Pair> minMaxStack; // Stack to store min and max pairs
        private int k;

        public Segment(int k) {
            this.k = k;
            inQueue = new LinkedList<>();
            outQueue = new LinkedList<>();
            minMaxStack = new ArrayDeque<>();
        }

        public void add(long value) {
            inQueue.add(value);

            // Update minMaxStack for new value
            long currentMin = value;
            long currentMax = value;

            if (!minMaxStack.isEmpty()) {
                Pair top = minMaxStack.peek();
                currentMin = Math.min(top.min, value);
                currentMax = Math.max(top.max, value);
            }

            minMaxStack.push(new Pair(currentMin, currentMax));
        }

        public void remove(long value) {
            if (!outQueue.isEmpty() && outQueue.peek() == value) {
                outQueue.poll();
            } else {
                if (!inQueue.isEmpty()) {
                    outQueue.add(inQueue.poll());
                    minMaxStack.pop();
                }
            }
        }

        public boolean isGood() {
            if (minMaxStack.isEmpty()) return true;

            Pair top = minMaxStack.peek();
            return (top.max - top.min) <= k;
        }
    }

    static class Pair {
        long min;
        long max;

        public Pair(long min, long max) {
            this.min = min;
            this.max = max;
        }
    }


}
