package yym.svydovets.algorithm.task;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class MajorityVoteTest {

    @Test
    void majorityElementV1() {
        int[] initial = new int[]{3, 2, 3};
        int expected = 3;

        final int actual = MajorityVote.majorityElement(initial);

        assertEquals(expected, actual);
    }

    @Test
    void majorityElementV2() {
        int[] initial = new int[]{2,2,1,1,1,2,2};
        int expected = 2;

        final int actual = MajorityVote.majorityElement(initial);

        assertEquals(expected, actual);
    }
}