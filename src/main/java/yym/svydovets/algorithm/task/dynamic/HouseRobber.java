package yym.svydovets.algorithm.task.dynamic;

import java.util.Arrays;

public class HouseRobber {

  public int robRecurs(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    if (nums.length == 1) return nums[0];
    return robRecurs(nums, nums.length - 1);
  }

  private int robRecurs(int[] nums, int cur) {
    if (cur < 0) return 0;
    if (cur == 0) return nums[0];
    if (cur == 1) return Math.max(nums[0], nums[cur]);
    return Math.max(nums[cur] + robRecurs(nums, cur - 2), robRecurs(nums, cur - 1));
  }

  int[] memo;
  public int robMemo(int[] nums) {
    memo = new int[nums.length + 1];
    Arrays.fill(memo, -1);
    return rob(nums, nums.length - 1);
  }

  private int rob(int[] nums, int i) {
    if (i < 0) {
      return 0;
    }
    if (memo[i] >= 0) {
      return memo[i];
    }
    int result = Math.max(rob(nums, i - 2) + nums[i], rob(nums, i - 1));
    memo[i] = result;
    return result;
  }

  public int robTopDown(int[] nums) {
    if (nums == null || nums.length == 0) return 0;
    if (nums.length == 1) return nums[0];
    int[] dp = new int[nums.length + 1];
    dp[0] = nums[0];
    dp[1] = Math.max(nums[0], nums[1]);
    for (int i = 2; i < nums.length; i++) {
      if (dp[i] > 0) return dp[i];
      dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
    }
    return dp[nums.length - 1];
  }

  public int robOptimal(int[] nums) {
    int prev = 0;
    int cur = 0;
    for (int n : nums) {
      int temp = cur;
      cur = Math.max(prev + n, cur);
      prev = temp;
    }
    return cur;
  }

}
