package yym.svydovets.dataStructure.task;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class TopKfrequence {

  public static void main(String[] args) {
    var arr = new int[]{1, 1, 1, 2, 2, 3};
    System.out.println(Arrays.toString(topKFrequentOptimal(arr, 2)));
  }

  /*
  Given an integer array nums and an integer k, return the k most frequent elements.
  You may return the answer in any order.
  Example:
  Input: nums = [1,1,1,2,2,3], k = 2
  Output: [1,2]
  https://leetcode.com/problems/top-k-frequent-elements/
   */
  static int[] topKFrequent(int[] nums, int k) {
    var res = new int[k];
    var map = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; i++) {
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    }

    int i = 0;
    while (i < k) {
      var max = findMax(map);
      res[i] = max;
      map.remove(max);
      i++;
    }

    return res;
  }

  private static int findMax(HashMap<Integer, Integer> map) {
    var max = 0;
    var maxVal = 0;
    for (var entry : map.entrySet()) {
      if (entry.getValue() > maxVal) {
        maxVal = entry.getValue();
        max = entry.getKey();
      }
    }
    return max;
  }


  static int[] topKFrequentOptimal(int[] nums, int k) {
    int min = Integer.MAX_VALUE;
    int max = Integer.MIN_VALUE;

    for (int i : nums) {
      if (min > i) min = i;
      if(i > max) max = i;
    }

    int[] freq = new int[max - min + 1];
    for (int i : nums)
      freq[i - min]++;

    List<Integer>[] buckets = new List[nums.length + 1];

    int max_freq = 0;
    for (int i = 0; i < freq.length; i++) {
      if (freq[i] > 0) {
        if (buckets[freq[i]] == null)
          buckets[freq[i]] = new ArrayList<>();
        buckets[freq[i]].add(i + min);

        max_freq = Math.max(freq[i], max_freq);
      }
    }

    int[] res = new int[k];
    for (int i = max_freq, idx = 0; i > 0 && idx < k; i--)
      if (buckets[i] != null)
        for (int num : buckets[i]) {
          if (idx == k) break;
          res[idx++] = num;
        }
    return res;
  }

}
