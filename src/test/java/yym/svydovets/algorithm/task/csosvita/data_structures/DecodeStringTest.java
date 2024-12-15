package yym.svydovets.algorithm.task.csosvita.data_structures;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DecodeStringTest {

    @Test
    void decodeString1() {
        String encoded = "10[k]";
        final String result = DecodeString.decode(encoded);
        assertEquals("kkkkkkkkkk", result);
    }

    @Test
    void decodeString2() {
        String encoded = "3[a]2[bc]";
        final String result = DecodeString.decode(encoded);
        assertEquals("aaabcbc", result);
    }

    @Test
    void decodeString3() {
        String encoded = "3[a2[c]]";
        final String result = DecodeString.decode(encoded);
        assertEquals("accaccacc", result);
    }


}