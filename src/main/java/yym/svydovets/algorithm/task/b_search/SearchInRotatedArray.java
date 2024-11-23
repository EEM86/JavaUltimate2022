package yym.svydovets.algorithm.task.b_search;

import org.apache.commons.lang3.NotImplementedException;

public class SearchInRotatedArray {

  /*
   * Medium
   * There is an integer array nums sorted in ascending order (with distinct values).
   * Prior to being passed to your function, nums is possibly rotated at an unknown pivot
   * index k (1 <= k < nums.length) such that the resulting array is
   * [nums[k], nums[k+1], ..., nums[n-1], nums[0], nums[1], ..., nums[k-1]] (0-indexed).
   * For example, [0,1,2,4,5,6,7] might be rotated at pivot index 3 and become [4,5,6,7,0,1,2].
   *
   * Given the array nums after the possible rotation and an integer target,
   * return the index of target if it is in nums, or -1 if it is not in nums.
   *
   * You must write an algorithm with O(log n) runtime complexity.
   * Example:
   * Input: nums = [4,5,6,7,0,1,2], target = 0
   * Output: 4
   * https://leetcode.com/problems/search-in-rotated-sorted-array/
   */
  public static int search(int[] nums, int target) {
    int bad = -1;
    int good = nums.length;

    while (good - bad > 1) {
      int candidate = (good + bad) / 2;
      if (nums[candidate] == target) {
        return candidate;
      }
      if (isGood(candidate, nums, target)) {
        good = candidate;
      } else {
        bad = candidate;
      }
    }
    return (good == nums.length || nums[good] != target) ? -1 : good;
  }

  private static boolean isGood(int candidate, int[] nums, int target) {
    boolean isGood = false;

    if (nums[candidate] >= nums[0]) {
        return nums[candidate] > target && target >= nums[0];
    };

    if (nums[candidate] <= nums[nums.length - 1]) {
        return target <= nums[candidate] || target > nums[nums.length - 1];
    }
    return isGood;
  }

}
