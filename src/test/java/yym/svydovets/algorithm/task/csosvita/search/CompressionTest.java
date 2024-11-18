package yym.svydovets.algorithm.task.csosvita.search;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class CompressionTest {

    @Test
    void compress() {
        String s = "AABBBCCCC";

        final String result = Compression.compress(s);
        assertEquals("A2B3C4", result);
    }

    @Test
    void compress2() {
        String s = "A";

        final String result = Compression.compress(s);
        assertEquals("A1", result);
    }

    @Test
    void compress3() {
        String s = "AAAAA";

        final String result = Compression.compress(s);
        assertEquals("A5", result);
    }

    @Test
    void compress4() {
        String s = "AAZ";

        final String result = Compression.compress(s);
        assertEquals("A2Z1", result);
    }

    @Test
    void compress5() {
        String s = "XXB";

        final String result = Compression.compress(s);
        assertEquals("X2B1", result);
    }

    @Test
    void compress6() {
        String s = "PSEW";

        final String result = Compression.compress(s);
        assertEquals("P1S1E1W1", result);
    }
}