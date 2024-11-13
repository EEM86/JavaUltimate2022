package yym.svydovets.algorithm.task.csosvita.two_pointers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class ZirTest {

    @Test
    void zir1() {
        int n = 2;
        int[] nArr = new int[]{3,4};
        int m = 3;
        int[] mArr = new int[]{1,2,3};

        final String res = Zir.zir(n, nArr, m, mArr);
        assertEquals("3 3", res);
    }

    @Test
    void zir2() {
        int n = 2;
        int[] nArr = new int[]{4,5};
        int m = 3;
        int[] mArr = new int[]{1,2,3};

        final String res = Zir.zir(n, nArr, m, mArr);
        assertEquals("4 3", res);
    }

    @Test
    void zir3() {
        int n = 5;
        int[] nArr = new int[]{1,2,3,4,5};
        int m = 5;
        int[] mArr = new int[]{1,2,3,4,5};

        final String res = Zir.zir(n, nArr, m, mArr);
        assertEquals("1 1", res);
    }
}