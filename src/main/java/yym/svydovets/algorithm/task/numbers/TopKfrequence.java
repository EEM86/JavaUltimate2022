package yym.svydovets.algorithm.task.numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TopKfrequence {

  public static void main(String[] args) {
    var arr = new int[] {1, 1, 1, 2, 2, 3};
    System.out.println(Arrays.toString(topKFrequentHeap(arr, 2)));
  }

  /*
  Medium
  Given an integer array nums and an integer k, return the k most frequent elements.
  You may return the answer in any order.
  Example:
  Input: nums = [1,1,1,2,2,3], k = 2
  Output: [1,2]
  https://leetcode.com/problems/top-k-frequent-elements/
   */
  static int[] topKFrequentBucket(int[] nums, int k) {
    List<Integer>[] bucket = new List[nums.length + 1];
    var freqMap = new HashMap<Integer, Integer>();

    for (var n : nums) {
      freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
    }

    for (var key : freqMap.keySet()) {
      int frequency = freqMap.get(key);
      if (bucket[frequency] == null) {
        bucket[frequency] = new ArrayList<>();
      }
      bucket[frequency].add(key);
    }

    List<Integer> res = new ArrayList<>();
    for (int i = bucket.length - 1; i >= 0 && res.size() < k; i--) {
      if (bucket[i] != null) {
        res.addAll(bucket[i]);
      }
    }

    return res.stream().mapToInt(a -> a).toArray();
  }

  static int[] topKFrequentHeap(int[] nums, int k) {
    // O(1) time
    if (k == nums.length) {
      return nums;
    }

    // 1. build hash map : character and how often it appears
    // O(N) time
    Map<Integer, Integer> freqMap = new HashMap<>();
    for (var n : nums) {
      freqMap.put(n, freqMap.getOrDefault(n, 0) + 1);
    }

    // init heap 'the less frequent element first'
    var heap = new PriorityQueue<Integer>(Comparator.comparingInt(freqMap::get));

    // 2. keep k top frequent elements in the heap
    // O(N log k) < O(N log N) time
    for (int n : freqMap.keySet()) {
      heap.add(n);
      if (heap.size() > k) {
        heap.poll();
      }
    }

    // 3. build an output array
    // O(k log k) time
    int[] top = new int[k];
    for (int i = k - 1; i >= 0 && heap.size() > 0; --i) {
      top[i] = heap.poll();
    }
    return top;
  }

}
