package yym.svydovets.algorithm.task.csosvita.two_pointers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PeretynTest {

    @Test
    void peretyn() {
        int n = 4;
        int[] a = new int[]{1, 2, 2, 1};
        int m = 2;
        int[] b = new int[]{2,2};

        final String peretyn = Peretyn.peretyn(n, a, m, b);
        assertEquals("2 2", peretyn);
    }

    @Test
    void peretyn2() {
        int n = 3;
        int[] a = new int[]{4, 9, 5};
        int m = 5;
        int[] b = new int[]{9,4,9,9,4};

        final String peretyn = Peretyn.peretyn(n, a, m, b);
        assertEquals("4 9", peretyn);
    }

    @Test
    void peretyn3() {
        int n = 4;
        int[] a = new int[]{-2, -7, 0, 3};
        int m = 6;
        int[] b = new int[]{7,4,0,0,-2, -7};

        final String peretyn = Peretyn.peretyn(n, a, m, b);
        assertEquals("-7 -2 0", peretyn);
    }

    @Test
    void peretyn4() {
        int n = 2;
        int[] a = new int[]{-2, -4};
        int m = 2;
        int[] b = new int[]{4, 2};

        final String peretyn = Peretyn.peretyn(n, a, m, b);
        assertEquals("-1", peretyn);
    }
}