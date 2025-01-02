package yym.svydovets.algorithm.task.heap;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class MergingIteratorTask {

    public static void main(String[] args) {
        List<Iterator<Integer>> iterators = Arrays.asList(
            Arrays.asList(2, 5, 9).iterator(),
            Arrays.asList(-2, -1, 0, 1, 2).iterator(),
            Arrays.asList(4, 10).iterator());
        MergingIterator itr = new MergingIterator(iterators);
        System.out.println(itr.hasNext()); 	// true
        System.out.println(itr.next()); // -2
        System.out.println(itr.next()); // -1
        System.out.println(itr.next()); // 0
        System.out.println(itr.next()); // 1
        System.out.println(itr.next()); // 2
        System.out.println(itr.next()); // 2
        System.out.println(itr.next()); // 4
        System.out.println(itr.next()); // 5
        System.out.println(itr.next()); // 9
        System.out.println(itr.next()); // 10

        System.out.println(itr.hasNext());   // false
        System.out.println("OK");
    }

    public static class MergingIterator implements Iterator<Integer> {
        private Map<Iterator<Integer>, Integer> map;
        private PriorityQueue<Iterator<Integer>> pq;
        public MergingIterator(List<Iterator<Integer>> iterators) {
            pq = new PriorityQueue<>(
                (a,b) -> Integer.compare(map.get(a), map.get(b)));
            map = new HashMap<>();

            for (var it : iterators) {
                if (it.hasNext()) {
                    map.put(it, it.next());
                    pq.add(it);
                }
            }
        }
        @Override
        public boolean hasNext() {
            return !pq.isEmpty();
        }

        @Override
        public Integer next() {
            if (pq.isEmpty()) throw new RuntimeException();
            Iterator<Integer> it = pq.poll();
            Integer value = map.get(it);
            if (it.hasNext()) {
                map.put(it, it.next());
                pq.add(it);
            }
            return value;
        }
    }

}
