package yym.svydovets.dataStructure.task.numbers;

import java.util.Arrays;

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] height = new int[]{5,5,1,7,1,1,5,2,7,6};
        System.out.println(trapOptimal(height));
    }

    /*
    HARD
    Given n non-negative integers representing an elevation map where the width of each bar is 1,
    compute how much water it can trap after raining.
    Input: height = [0,1,0,2,1,0,1,3,2,1,2,1]
    Output: 6
    Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
    In this case, 6 units of rain water (blue section) are being trapped.
    https://leetcode.com/problems/trapping-rain-water/
     */
    static int trap(int[] height) {
        int maxLeftBorder = height[0], maxRightBorder = height[height.length - 1];
        int left = 0, right = height.length - 1;
        int result = 0;
        while (left < right) {
            if (maxLeftBorder <= maxRightBorder) {
                left++;
                if (maxLeftBorder < height[left]) {
                    maxLeftBorder = height[left];
                }
                int waterAmount = maxLeftBorder - height[left]; // 5,5,1,7,1,1,5,2,7,6
                if (waterAmount > 0) {
                    result += waterAmount;
                }
            } else {
                right--;
                if (maxRightBorder < height[right]) {
                    maxRightBorder = height[right];
                }
                int waterAmount = maxRightBorder - height[right];
                if (waterAmount > 0) {
                    result += waterAmount;
                }
            }
        }
        return result;
    }

    // O(n) + O(1) space
    static int trapOptimal(int[] heights) {

        if (heights.length == 0) return 0;

        int l = 0, r = heights.length - 1;
        int leftMax = heights[l], rightMax = heights[r];
        int res = 0;

        while (l < r) {
            if (leftMax < rightMax) {
                l++;
                leftMax = Math.max(leftMax, heights[l]);
                res += leftMax - heights[l];
            } else {
                r--;
                rightMax = Math.max(rightMax, heights[r]);
                res += rightMax - heights[r];
            }
        }
        return res;
    }

}
