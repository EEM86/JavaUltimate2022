package yym.svydovets.algorithm.task;

import org.apache.commons.lang3.NotImplementedException;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Duplicates {

  public static void main(String[] args) {
    var arr = new int[] {1, 2, 3, 1};
    var start = System.nanoTime();
    final boolean result = containsDuplicate(arr);
    final long time = System.nanoTime() - start;
    System.out.println("Time: " + time);
    System.out.println(result);
  }

  /*
  Easy
  Given an integer array nums, return true if any value appears at least twice in the array,
  and return false if every element is distinct.
  Example 1:
  Input: nums = [1,2,3,1]
  Output: true
  https://leetcode.com/problems/contains-duplicate/
   */
  static boolean containsDuplicate(int[] nums) {
    throw new NotImplementedException();
  }

}
