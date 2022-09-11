package yym.svydovets.dataStructure.task.numbers;

import java.util.Arrays;
import java.util.Stack;

import org.apache.commons.lang3.NotImplementedException;

public class AsteroidCollision {

  public static void main(String[] args) {
    int[] arr = new int[]{5, 10, -5};
//    int[] arr = new int[]{-2,-2,1,-2};
    System.out.println(Arrays.toString(asteroidCollisionOptimal(arr)));
  }
  /*
  We are given an array asteroids of integers representing asteroids in a row.
  For each asteroid, the absolute value represents its size, and the sign represents its direction (positive meaning right, negative meaning left). Each asteroid moves at the same speed.
  Find out the state of the asteroids after all collisions. If two asteroids meet, the smaller one will explode. If both are the same size, both will explode. Two asteroids moving in the same direction will never meet.

  Example 1:
  Input: asteroids = [5,10,-5]
  Output: [5,10]
  Explanation: The 10 and -5 collide resulting in 10. The 5 and 10 never collide.
  https://leetcode.com/problems/asteroid-collision/
   */
  static int[] asteroidCollisionUsingStack(int[] asteroids) {
    throw new NotImplementedException();
  }

  static int[] asteroidCollisionOptimal(int[] asteroids) {
    throw new NotImplementedException();
  }

}
