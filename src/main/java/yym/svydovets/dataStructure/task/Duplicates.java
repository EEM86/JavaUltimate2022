package yym.svydovets.dataStructure.task;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Duplicates {

  public static void main(String[] args) {
    var arr = new int[] {1, 2, 3, 4};
    var start = System.nanoTime();
    final boolean result = containsDuplicateOptimal(arr);
    final long time = System.nanoTime() - start;
    System.out.println("Time: " + time);
    System.out.println(result);
  }

  /*
  Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
  Example 1:
  Input: nums = [1,2,3,1]
  Output: true
  https://leetcode.com/problems/contains-duplicate/
   */
  static boolean containsDuplicate(int[] nums) {
    for (int i = 0; i < nums.length; i++) {
      for (int j = i; j < nums.length - 1; j++) {
        if (nums[i] == nums[j + 1]) {
          return true;
        }
      }
    }
    return false;
  }

  static boolean containsDuplicateOptimal(int[] nums) {
    final Set<Integer> set = new HashSet<>();
    for (int num : nums) {
      if (!set.add(num)) {
        return true;
      }
    }
    return false;
  }

}
