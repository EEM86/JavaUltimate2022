package yym.svydovets.algorithm.task.csosvita;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PresentsTest {

    @Test
    void presents() {
        int a = 10;
        int b = 25;
        int c = 15;
        int d = 40;

        final int presents = Presents.presentsV2(a, b, c, d);
        assertEquals(3, presents);
    }
}