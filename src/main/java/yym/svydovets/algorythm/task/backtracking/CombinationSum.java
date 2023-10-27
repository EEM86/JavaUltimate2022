package yym.svydovets.algorythm.task.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class CombinationSum {

  /*
   * Medium
   * Given an array of distinct integers candidates and a target integer target,
   * return a list of all unique combinations of candidates where the chosen numbers sum to target.
   * You may return the combinations in any order.
   * The same number may be chosen from candidates an unlimited number of times.
   * Two combinations are unique if the frequency of at least one of the chosen numbers is different.
   *
   * Example:
   * Input: candidates = [2,3,6,7], target = 7
   * Output: [[2,2,3],[7]]
   * Explanation:
   * 2 and 3 are candidates, and 2 + 2 + 3 = 7. Note that 2 can be used multiple times.
   * 7 is a candidate, and 7 = 7.
   * These are the only two combinations.
   */
  public List<List<Integer>> combinationSum(int[] candidates, int target) {
    var res = new ArrayList<List<Integer>>();
    if (candidates == null || candidates.length == 0) return res;

    var tempList = new ArrayList<Integer>();

    // optimization - remove duplicates
    var uniqueCandidatesSet = Arrays.stream(candidates).boxed().collect(Collectors.toSet());
    // return to tempList for iteration by index
    var uniqueCandidatesList = new ArrayList<>(uniqueCandidatesSet);

    // optimization - sort the array tempList
    Collections.sort(uniqueCandidatesList);
    findCombinations(res, uniqueCandidatesList, target, 0, tempList);
    return res;
  }

  private void findCombinations(List<List<Integer>> res, List<Integer> candidates,
      int target, int idx, List<Integer> list) {
    if (target == 0) {
      //add deep copy of list to res
      res.add(new ArrayList<>(list));
      return;
    }

    for (int i = idx; i < candidates.size(); i++) {
      // check if target becomes negative
      if (target - candidates.get(i) >= 0) {
        // adding element which can contribute to sum
        list.add(candidates.get(i));
        findCombinations(res, candidates, target - candidates.get(i), i, list);
        //backtracking - removing element from list
        list.remove(candidates.get(i));
      }
    }
  }
}
