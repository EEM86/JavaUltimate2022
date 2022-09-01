package yym.svydovets.dataStructure.task.numbers;

import org.apache.commons.lang3.NotImplementedException;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

  public static void main(String[] args) {
    var nums = new int[] {2, 7, 11, 15};
    var target = 9;
    System.out.println(Arrays.toString(twoSum(nums, target)));
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
    throw new NotImplementedException();
  }

}
