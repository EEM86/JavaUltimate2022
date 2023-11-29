package yym.svydovets.algorithm.task.dynamic;

import org.apache.commons.lang3.NotImplementedException;

public class HouseRobber {

  /*
   * Medium
   * You are a professional robber planning to rob houses along a street.
   * Each house has a certain amount of money stashed, the only constraint
   * stopping you from robbing each of them is that adjacent houses have security
   * systems connected, and it will automatically contact the police
   * if two adjacent houses were broken into on the same night.
   *
   * Given an integer array nums representing the amount of money of each house,
   * return the maximum amount of money you can rob tonight without alerting the police.
   *
   * Input: nums = [1,2,3,1]
   * Output: 4
   * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
   * Total amount you can rob = 1 + 3 = 4.
   */
  public int robRecurs(int[] nums) {
    throw new NotImplementedException();
  }

  public int robMemo(int[] nums) {
    throw new NotImplementedException();
  }

  public int robTopDown(int[] nums) {
    throw new NotImplementedException();
  }

  public int robOptimal(int[] nums) {
    throw new NotImplementedException();
  }

  /*
   * Medium
   * You are a professional robber planning to rob houses along a street.
   * Each house has a certain amount of money stashed.
   * All houses at this place are arranged in a circle.
   * That means the first house is the neighbor of the last one.
   * Meanwhile, adjacent houses have a security system connected,
   * and it will automatically contact the police if two adjacent houses were broken into on the same night.
   *
   * Given an integer array nums representing the amount of money of each house,
   * return the maximum amount of money you can rob tonight without alerting the police.
   *
   * Input: nums = [2,3,2]
   * Output: 3
   * Explanation: You cannot rob house 1 (money = 2) and then rob house 3 (money = 2),
   * because they are adjacent houses.
   */
  public int robV2(int[] nums) {
    throw new NotImplementedException();
  }

}
