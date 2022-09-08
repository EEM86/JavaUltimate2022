package yym.svydovets.dataStructure.task.numbers;

import java.util.Arrays;

import org.apache.commons.lang3.NotImplementedException;

public class TrappingRainWater {

    public static void main(String[] args) {
        int[] height = new int[]{0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println(trap(height));
    }

    /*
    HARD
    Given n non-negative integers representing an elevation map where the width of each bar is 1,
    compute how much water it can trap after raining.
    Input: height = [0,1,0,2,1,0,1,3,2,1,2,1] ; 5,5,1,7,1,1,5,2,7,6
    Output: 6                                 ; 9
    Explanation: The above elevation map (black section) is represented by array [0,1,0,2,1,0,1,3,2,1,2,1].
    In this case, 6 units of rain water (blue section) are being trapped.
    https://leetcode.com/problems/trapping-rain-water/
     */
    static int trap(int[] height) {
        throw new NotImplementedException();
    }

}
