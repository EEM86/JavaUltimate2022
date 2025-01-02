package yym.svydovets.algorithm.task.csosvita.data_structures;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;
import org.checkerframework.checker.units.qual.A;

public class Segments {

    public static int countSegments(long[] arr, int k) {
        int n = arr.length;
        int cnt = 0;

        var segment = new Segment(k);

        int l = 0;
        for (int r = 0; r < n; r++) {
            segment.add(arr[r]);
            while (!segment.isGood()) {
                segment.remove(arr[l]);
                l++;
                r = l;
            }
            cnt++;
        }

        return cnt;
    }

    private static class Segment {
        int k;
        Queue queue = new Queue();

        public Segment(int k) {
            this.k = k;
        }

        public boolean isGood() {
            return queue.getMax() - queue.getMin() <= k;
        }

        public void add(long el) {
            queue.enqueue(el);
        }

        public Long remove(long el) {
            return queue.dequeue(el);
        }
    }

    private static class Queue {
        AdvancedStack in = new AdvancedStack();
        AdvancedStack out = new AdvancedStack();

        public void enqueue(long el) {
            in.push(el);
        }

        public Long getMax() {
            if (in.size == 0) {
                return out.getMax();
            }
            return in.getMax();
        }

        public Long getMin() {
            if (in.size == 0) {
                return out.getMin();
            }
            return in.getMin();
        }

        public Long dequeue(long el) {
            if (out.size == 0) {
                while (in.size != 0) {
                    long value = in.pop();
                    out.push(value);
                }
            }
            return out.pop();
        }


    }

    public static class AdvancedStack {

        List<Long> stack = new ArrayList<>();
        List<Pair> minMax = new ArrayList<>();
        private int size = 0;

        public void push(long val) {
            stack.add(size, val);
            if (size == 0) {
                minMax.add(size, new Pair(val, val));
            } else {
                long lastMin = Math.min(val, minMax.get(size - 1).min);
                long lastMax = Math.max(val, minMax.get(size - 1).max);
                minMax.add(size, new Pair(lastMin, lastMax));
            }
            size++;
        }

        public Long pop() {
            final Long removed = stack.remove(size - 1);
            minMax.remove(size - 1);
            size--;
            return removed;
        }

        public Long peek() {
            return stack.get(size - 1);
        }

        public long getMax() {
            return minMax.get(size - 1).max;
        }

        public long getMin() {
            return minMax.get(size - 1).min;
        }

        public int getSize() {
            return size;
        }


    }

    public static class Pair {
        long min;
        long max;

        public Pair(long min, long max) {
            this.min = min;
            this.max = max;
        }
    };


}
