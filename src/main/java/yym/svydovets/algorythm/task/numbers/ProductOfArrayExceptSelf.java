package yym.svydovets.algorythm.task.numbers;

import java.util.Arrays;

public class ProductOfArrayExceptSelf {

  public static void main(String[] args) {
    var nums = new int[]{1,2,3,4};
    System.out.println(Arrays.toString(productExceptSelf(nums)));
  }

  /*
  Given an integer array nums, return an array answer such that answer[i] is equal to the
  product of all the elements of nums except nums[i].
  The product of any prefix or suffix of nums is guaranteed to fit in a 32-bit integer.
  You must write an algorithm that runs in O(n) time and without using the division operation.
  Example :
  Input: nums = [1,2,3,4]
  Output: [24,12,8,6]
  https://leetcode.com/problems/product-of-array-except-self/
   */
  static int[] productExceptSelf(int[] nums) {
    final int n = nums.length;
    var res = new int[n];
    var prefix = 1;
    for (int i = 0; i < n; i++) {
      res[i] = prefix;
      prefix *= nums[i];
    }
    var postfix = 1;
    for (int i = n - 1; i >= 0; i--) {
      res[i] *= postfix;
      postfix *= nums[i];
    }
    return res;
  }

  static int[] productExceptSelfSite(int[] nums) {
    int[] left = new int[nums.length];
    int[] right = new int[nums.length];
    int curr = 1;
    for(int i = 0; i < nums.length; i++) {
      left[i] = curr;
      curr *= nums[i];
    }
    curr = 1;
    for(int i = nums.length - 1; i >= 0; i--) {
      right[i] = curr;
      curr *= nums[i];
    }
    int[] result = new int[nums.length];
    for (int i = 0; i < nums.length; i++) {
      result[i] = left[i] * right[i];
    }

    return result;
  }

}
