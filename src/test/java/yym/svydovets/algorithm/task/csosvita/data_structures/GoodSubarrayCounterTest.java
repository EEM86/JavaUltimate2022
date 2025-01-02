package yym.svydovets.algorithm.task.csosvita.data_structures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GoodSubarrayCounterTest {

    @Test
    void test1() {
        long[] arr = new long[]{2,6,4,3,6,8,9};
        int k = 3;
        final long result = GoodSubarrayCounter.countGoodSubarrays(arr, k);
        System.out.println(result);
    }

    @Test
    void test2() {
        long[] arr = new long[]{2,6,4,3};
        int k = 3;
        final long result = GoodSubarrayCounter.countGoodSubarrays(arr, k);
        System.out.println(result);
    }

    @Test
    void test3() {
        long[] arr = new long[]{2,6,4,3,6,8,9};
        int k = 3;
        final int result = SegmentsNew.countSegments(arr, k);
        System.out.println(result);
    }

    @Test
    void test4() {
        long[] arr = new long[]{2,6,4,3};
        int k = 3;
        final int result = SegmentsNew.countSegments(arr, k);
        System.out.println(result);
    }

}