package yym.svydovets.algorithm.task.csosvita.trees;

import java.util.ArrayList;
import java.util.List;

/*
* You are given a nested list of integers nestedList. Each element is either an integer
* or a list whose elements may also be integers or other lists.
* The depth of an integer is the number of lists that it is inside of.
* For example, the nested list [1,[2,2],[[3],2],1] has each integer's value set to its depth.
*
* Return the sum of each integer in nestedList multiplied by its depth.
*
* Sample 0:
* [[1,1],2,[1,1]]
* Sample output 0:
* 10
* Explanation:
* Four 1's at depth 2, one 2 at depth 1. 1*2 + 1*2 + 2*1 + 1*2 + 1*2 = 10.
 */
public class NestedListWeightSum {

    public int depthSum(List<NestedInteger> nestedList) {
        return depthSum(nestedList, 1);
    }

    private int depthSum(List<NestedInteger> nestedList, int depth) {
        int sum = 0;
        for (var nested : nestedList) {
            if (nested.isInteger()) {
                sum += nested.getInteger() * depth;
                continue;
            }

            final List<NestedInteger> curList = nested.getList();
            sum += depthSum(curList, depth + 1);
        }
        return sum;
    }

    public static class NestedInteger {
        List<NestedInteger> list;
        Integer singleInt;
        public NestedInteger() {
            list = new ArrayList<>();
        }

        public NestedInteger(int value) {
            singleInt = value;
        }

        public boolean isInteger() {
            return singleInt != null;
        }

        public Integer getInteger() {
            return (list == null || list.isEmpty())
                    ? singleInt
                    : null;
        }

        public void setInteger(int value) {
            singleInt = value;
        }

        public void add(NestedInteger ni) {
            if (list == null) {
                list = new ArrayList<>();
            }
            list.add(ni);
        }

        public List<NestedInteger> getList() {
            boolean isListHolder = list != null && !list.isEmpty();
            return (singleInt == null && isListHolder)
                ? list
                : new ArrayList<>();
        }
    }

}
