package yym.svydovets.dataStructure.task.numbers;

import org.apache.commons.lang3.NotImplementedException;

import java.util.Arrays;
import java.util.stream.Collectors;

public class LongestConsequtiveSequence {

  public static void main(String[] args) {
    var nums = new int[]{100,4,200,1,3,2};
    System.out.println(longestConsecutive(nums));
  }

  /*
  Given an unsorted array of integers nums, return the length of the longest consecutive elements sequence.
  You must write an algorithm that runs in O(n) time.
  Example 1:
  Input: nums = [100,4,200,1,3,2] ; 0,3,7,2,5,8,4,6,0,1
  Output: 4                       ; 9
  Explanation: The longest consecutive elements sequence is [1, 2, 3, 4]. Therefore its length is 4.
  https://leetcode.com/problems/longest-consecutive-sequence/
   */
  static int longestConsecutive(int[] nums) {
    throw new NotImplementedException();
  }

}
