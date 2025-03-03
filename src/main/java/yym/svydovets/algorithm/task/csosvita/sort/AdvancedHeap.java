package yym.svydovets.algorithm.task.csosvita.sort;

import java.util.HashMap;
import java.util.Map;

/*
 * In traditional PriorityQueue implementations, removing an arbitrary element has
 * a time complexity of O(n) because it may require scanning the entire queue to find the element.
 * Your task is to design and implement a modified version of a priority queue
 * that supports removing an arbitrary element faster.
 *
 * There are 3 types of query:
 * "1 v" - Add an element v to the heap.
 * "2 v" - Delete the element v from the heap.
 * "3"   - Print the minimum of all the elements in the heap.
 *
 * It is guaranteed that the element to be deleted will be there in the heap.
 * At ant instant, only distinct elements will be in the heap.
 *
 * 1 <= Q (queries) <= 10^5
 * -10^9 <= v <= 10^9

 */
public class AdvancedHeap {

    int n;
    int[] arr;
    Map<Integer, Integer> cache;

    public AdvancedHeap() {
        arr = new int[10_000];
        cache = new HashMap<>();
    }

    public void add(int el) {
        n++;
        arr[n] = el;
        cache.put(el, n);
        siftUp(n);
    }

    public void remove(int el) {
        int idx = cache.get(el);
        swap(idx, n--);
        siftDown(idx);
        siftUp(idx);
        cache.remove(el);
    }

    public int getMin() {
        return arr[1];
    }

    private void siftUp(int i) {
        while (i > 1 && arr[i/2] > arr[i]) {
            swap(i/2, i);
            i/=2;
        }
    }

    private void siftDown(int i) {
        while (2*i <= n) {
            int j = i;
            if (arr[2*i] < arr[j]) {
                j = 2*i;
            }
            if (2*i+1 <= n && arr[2*i+1] < arr[j]) {
                j = 2*i+1;
            }
            if (i == j) {
                break;
            }
            swap(i,j);
            i = j;
        }
    }

    private void swap(int i, int j) {
        final int first = arr[i];
        final int second = arr[j];
        cache.put(first, j);
        cache.put(second, i);
        arr[i] = second;
        arr[j] = first;
    }

}
