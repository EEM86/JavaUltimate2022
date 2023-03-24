package yym.svydovets.algorythm.task.numbers;

import java.util.Arrays;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsecutiveSequence {

  /*
  Medium
  Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
  You must write an algorithm that runs in O(n) time.
  Example 1:
  Input: nums = [100,4,200,1,3,2] ; 0,3,7,2,5,8,4,6,0,1
  Output: 4                       ; 9
  Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
  https://leetcode.com/problems/longest-consecutive-sequence/
   */
  static int longestConsecutive(int[] nums) {
    var set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
    int res = 0;

    for (int i = 0; i < nums.length; i++) {
      if (!partOfChain(set, nums[i])) {
        var curNum = nums[i];
        int maxChain = 1;
        while (set.contains(curNum + 1)) {
          maxChain++;
          curNum++;
        }
        res = Math.max(res, maxChain);
      }
    }
    return res;
  }

  private static boolean partOfChain(Set<Integer> set, int num) {
    return set.contains(num - 1);
  }

}
