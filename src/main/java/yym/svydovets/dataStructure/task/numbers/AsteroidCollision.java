package yym.svydovets.dataStructure.task.numbers;

import java.util.Arrays;
import java.util.Stack;
import java.util.function.Function;
import java.util.function.IntFunction;

public class AsteroidCollision {

  public static void main(String[] args) {
    int[] arr = new int[]{-2,-2,1,-2};
    System.out.println(Arrays.toString(asteroidCollision(arr)));
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
  static int[] asteroidCollision(int[] asteroids) {
    var stack = new Stack<Integer>();

    for (int i = 0; i < asteroids.length; i++) {
      while (!stack.isEmpty() && asteroids[i] < 0 && stack.peek() > 0) {
        var diff = asteroids[i] + stack.peek();
        if (diff < 0) {
          stack.pop();
        } else if (diff > 0) {
          asteroids[i] = 0;
        } else {
          asteroids[i] = 0;
          stack.pop();
        }
      }
      if (asteroids[i] != 0) {
        stack.add(asteroids[i]);
      }
    }
    return stack.stream().mapToInt(a->a).toArray();
  }

  static int[] asteroidCollisionOptimal(int[] asteroids) {
    // -1 3 2 -3
    if (asteroids.length == 0) return new int[]{};
    int left = 0;
    int right = 1;

    while (right < asteroids.length) {
      if (left >= 0 && asteroids[left] > 0 && asteroids[right] < 0) {
        if (asteroids[left] + asteroids[right] == 0) {
          left--;
          right++;
        } else if (asteroids[left] + asteroids[right] > 0) {
          right++;
        } else {
          left--;
        }
      } else {
        left++;
        asteroids[left] = asteroids[right];
        right++;
      }
    }

    int[] res = new int[left + 1];
    for (int i = 0; i < left + 1; i++) {
      res[i] = asteroids[i];
    }
    return res;
  }

}
