package yym.svydovets.algorithm.task.csosvita.two_pointers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class RequestsTest {

    @Test
    void test1() {
        int[] arr = new int[]{1,1,0,1,1,1};
        int n = 6;

        final int res = Requests.longestSeq(arr, n);
        assertEquals(3, res);
    }

    @Test
    void test2() {
        int[] arr = new int[]{1,0,1,1,0,1};
        int n = 6;

        final int res = Requests.longestSeq(arr, n);
        assertEquals(2, res);
    }

    @Test
    void test3() {
        int[] arr = new int[]{0,0,0,0,0,0};
        int n = 6;

        final int res = Requests.longestSeq(arr, n);
        assertEquals(0, res);
    }

    @Test
    void test4() {
        int[] arr = new int[]{1,0,0,0,0,1};
        int n = 6;

        final int res = Requests.longestSeq(arr, n);
        assertEquals(1, res);
    }

    @Test
    void test5() {
        int[] arr = new int[]{1,1,1,1,1,1};
        int n = 6;

        final int res = Requests.longestSeq(arr, n);
        assertEquals(6, res);
    }

    @Test
    void test6() {
        int[] arr = new int[]{0,1,1,1,1,0};
        int n = 6;

        final int res = Requests.longestSeq(arr, n);
        assertEquals(4, res);
    }

    @Test
    void test7() {
        int[] arr = new int[]{0,1,1,1,0,1,1,0};
        int n = 8;

        final int res = Requests.longestSeq(arr, n);
        assertEquals(3, res);
    }

    @Test
    void test8() {
        int[] arr = new int[]{1, 1, 0, 1, 1, 1, 0, 1, 1};
        int n = arr.length;

        final int res = Requests.longestSeq(arr, n);
        assertEquals(3, res);
    }

}