package yym.svydovets.algorithm.task.b_search;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CocoEatsBananasTest {

    @Test
    void minEatingSpeed() {
        final int result = CocoEatsBananas.minEatingSpeed(new int[]{2, 2}, 2);
        assertEquals(2, result);
    }

    @Test
    void minEatingSpeed2() {
        int[] arr = new int[]{30,11,23,4,20};
        int h = 6;
        final int result = CocoEatsBananas.minEatingSpeed(arr, h);
        assertEquals(23, result);
    }

    @Test
    void minEatingSpeed3() {
        int[] arr = new int[]{30,11,23,4,20};
        int h = 5;
        final int result = CocoEatsBananas.minEatingSpeed(arr, h);
        assertEquals(30, result);
    }

    @Test
    void minEatingSpeed4() {
        int[] arr = new int[]{3,6,7,11};
        int h = 8;
        final int result = CocoEatsBananas.minEatingSpeed(arr, h);
        assertEquals(4, result);
    }
}