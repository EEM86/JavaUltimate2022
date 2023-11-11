package yym.svydovets.algorithm.task.numbers;

public class ContainerWithMostWater {

  public static void main(String[] args) {
    var height = new int[] {1, 8, 6, 2, 5, 4, 8, 3, 7};
    System.out.println(maxArea(height));
  }

  /*
  You are given an integer array height of length n. There are n vertical lines drawn such that the two endpoints
  of the ith line are (i, 0) and (i, height[i]).
  Find two lines that together with the x-axis form a container, such that the container contains the most water.
  Return the maximum amount of water a container can store.
  Notice that you may not slant the container.
  Example:
  Input: height = [1,8,6,2,5,4,8,3,7]
  Output: 49
  Explanation: The above vertical lines are represented by array [1,8,6,2,5,4,8,3,7].
  In this case, the max area of water (blue section) the container can contain is 49.
  https://leetcode.com/problems/container-with-most-water/
   */
  static int maxArea(int[] height) {
    int max = 0, leftIdx = 0;
    int rightIdx = height.length - 1;

    while (leftIdx < rightIdx) {
      int area = (rightIdx - leftIdx) * Math.min(height[leftIdx], height[rightIdx]);
      max = Math.max(max, area);

      if (height[leftIdx] > height[rightIdx]) {
        rightIdx--;
      } else {
        leftIdx++;
      }
    }
    return max;
  }

}
