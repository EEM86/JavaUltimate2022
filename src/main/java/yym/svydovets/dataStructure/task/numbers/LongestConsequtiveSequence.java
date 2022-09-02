package yym.svydovets.dataStructure.task.numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

public class LongestConsequtiveSequence {

  public static void main(String[] args) {
    var nums = new int[]{0,0,-1};
    System.out.println(longestConsecutive(nums));
  }

  /*
  Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
  You must write an algorithm that runs in O(n) time.
  Example 1:
  Input: nums = [100,4,200,1,3,2] ; 0,3,7,2,5,8,4,6,0,1
  Output: 4
  Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
   */
  static int longestConsecutive(int[] nums) {
    var set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
    var longest = 0;

    for (int i = 0; i < nums.length; i++) {
      if (!set.contains(nums[i] - 1)) {
        int chainSize = 1;
        var currentInChain = nums[i];
        while (set.contains(currentInChain + 1)) {
          chainSize++;
          currentInChain++;
        }
        longest = Math.max(longest, chainSize);
      }
    }
    return longest;
  }

  static int longestConsecutiveSite(int[] nums) {
    if (nums.length == 0) return 0;
    Set<Integer> set = new HashSet<>();
    int ans = 1;
    for (int num : nums) set.add(num);
    for (int num : nums) {
      if (!set.contains(num - 1)) {
        int count = 1;
        while (set.contains(num + 1)) {
          num++;
          count++;
        }
        ans = Math.max(count, ans);
      }
    }
    return ans;
  }

}
