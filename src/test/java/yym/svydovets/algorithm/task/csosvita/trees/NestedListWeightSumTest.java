package yym.svydovets.algorithm.task.csosvita.trees;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import yym.svydovets.algorithm.task.csosvita.trees.NestedListWeightSum.NestedInteger;

class NestedListWeightSumTest {

    @Test
    void depthSum() {
        List<NestedInteger> nestedInteger = new ArrayList<>(3);
        final NestedInteger first = new NestedInteger();
        first.add(new NestedInteger(1));
        first.add(new NestedInteger(1));
        final NestedInteger second = new NestedInteger(2);
        final NestedInteger third = new NestedInteger();
        third.add(new NestedInteger(1));
        third.add(new NestedInteger(1));
        nestedInteger.add(first);
        nestedInteger.add(second);
        nestedInteger.add(third);

        final NestedListWeightSum service = new NestedListWeightSum();

        final int result = service.depthSum(nestedInteger);
        assertEquals(10, result);
    }

    @Test
    void depthSum2() {
        List<NestedInteger> nestedInteger = new ArrayList<>(3);
        final NestedInteger first = new NestedInteger(1);
        final NestedInteger third = new NestedInteger();
        third.add(new NestedInteger(6));
        final NestedInteger second = new NestedInteger();
        second.add(new NestedInteger(4));
        second.add(third);
        nestedInteger.add(first);
        nestedInteger.add(second);

        final NestedListWeightSum service = new NestedListWeightSum();

        final int result = service.depthSum(nestedInteger);
        assertEquals(27, result);
    }
}