package yym.svydovets.algorithm.task.numbers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TwoSum {

  public static void main(String[] args) {
//    var nums = new int[] {2,3,11,15};
//    var target = 9;
//    System.out.println(Arrays.toString(twoSumV2(nums, target)));

    var threeNums = new int[] {4, 0, 1, 2, -1, -4};
    threeSum(threeNums).forEach(System.out::println);

  }

  /*
  Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
  You may assume that each input would have exactly one solution, and you may not use the same element twice.
  You can return the answer in any order.

  Example:
  Input: nums = [2,7,11,15], target = 9
  Output: [0,1]
  Explanation: Because nums[0] + nums[1] == 9, we return [0, 1].
  https://leetcode.com/problems/two-sum/submissions/
   */
  static int[] twoSum(int[] nums, int target) {
    var n = nums.length;
    for (int i = 0; i < n; i++) {
      for (int j = i; j < n - 1; j++) {
        if (nums[i] + nums[j + 1] == target) {
          return new int[] {i, j + 1};
        }
      }
    }
    return null;
  }

  /*
  Given a 1-indexed array of integers numbers that is already sorted in non-decreasing order,
  find two numbers such that they add up to a specific target number.
  Let these two numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <= numbers.length.
  Return the indices of the two numbers, index1 and index2, added by one as an integer array [index1, index2] of length 2.
  The tests are generated such that there is exactly one solution. You may not use the same element twice.
  Your solution must use only constant extra space.

  Example 1:
  Input: numbers = [2,7,11,15], target = 9
  Output: [1,2]
  Explanation: The sum of 2 and 7 is 9. Therefore, index1 = 1, index2 = 2. We return [1, 2].
  https://leetcode.com/problems/two-sum-ii-input-array-is-sorted/
   */
  static int[] twoSumV2(int[] numbers, int target) {
    int leftPointer = 0;
    int rightPointer = numbers.length - 1;

    while (leftPointer < rightPointer) {
      if (numbers[leftPointer] + numbers[rightPointer] > target) {
        rightPointer--;
      } else if (numbers[leftPointer] + numbers[rightPointer] < target) {
        leftPointer++;
      } else {
        return new int[] {leftPointer + 1, rightPointer + 1};
      }
    }

    return new int[] {};
  }

  static int[] twoSumOptimal(int[] nums, int target) {
    var valueToIndexMap = new HashMap<Integer, Integer>();
    for (int i = 0; i < nums.length; i++) {
      var numToFind = target - nums[i];
      var captured = valueToIndexMap.get(numToFind);
      if (captured != null) {
        return new int[] {captured, i};
      } else {
        valueToIndexMap.put(nums[i], i);
      }
    }
    return null;
  }

  /*
  Given an integer array nums, return all the triplets [nums[i], nums[j], nums[k]] such that i != j, i != k, and j != k, and nums[i] + nums[j] + nums[k] == 0.
  Notice that the solution set must not contain duplicate triplets.
  Example:
  Input: nums = [-1,0,1,2,-1,-4]
  Output: [[-1,-1,2],[-1,0,1]]
  Explanation:
  nums[0] + nums[1] + nums[2] = (-1) + 0 + 1 = 0.
  nums[1] + nums[2] + nums[4] = 0 + 1 + (-1) = 0.
  nums[0] + nums[3] + nums[4] = (-1) + 2 + (-1) = 0.
  The distinct triplets are [-1,0,1] and [-1,-1,2].
  Notice that the order of the output and the order of the triplets does not matter.
  https://leetcode.com/problems/3sum/
   */
  static List<List<Integer>> threeSum(int[] nums) {
    Arrays.sort(nums);
    Set<List<Integer>> result = new HashSet<>();
    for (int i = 0; i < nums.length - 2; i++) {
      int leftIdx = i + 1;
      int rightIdx = nums.length - 1;
      while (leftIdx < rightIdx) {
        int sum = nums[i] + nums[leftIdx] + nums[rightIdx];
        if (sum == 0) {
          var list = List.of(nums[i], nums[leftIdx], nums[rightIdx]);
          result.add(list);
          leftIdx++;
        } else if (sum < 0) {
          leftIdx++;
        } else {
          rightIdx--;
        }
      }
    }
    return new ArrayList<>(result);
  }

}

