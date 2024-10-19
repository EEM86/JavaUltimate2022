package yym.svydovets.algorithm.task;

import org.apache.commons.lang3.NotImplementedException;

/**
 * Majority Vote is an algorithm to find the majority of elements.
 * Imagine the group of developers where each developer has the lovely programming language.
 * It can be 17 people that love c++, java and python. If they are in a same room, they start
 * to fight each other with simultaneously nocking out each other. In the end, there should be
 * at least one person with his favorite language, all others were "nocked out".
 *
 * The idea is to have a count and a candidate. During iteration over the elements
 * if count is 0, the candidate is a current element and the count++
 * if the current element is the current candidate, the count++
 * if the current element differs from the current candidate, the count--
 */
public class MajorityVote {

    /*
     * Given an array nums of size n, return the majority element.
     * The majority element is the element that appears more than ⌊n / 2⌋ times.
     * You may assume that the majority element always exists in the array.
     *
     * Example 1:
     * Input: nums = [3,2,3]
     * Output: 3
     *
     * Example 2:
     * Input: nums = [2,2,1,1,1,2,2]
     * Output: 2
     */
    public int majorityElement(int[] nums) {
        throw new NotImplementedException();
    }

}
