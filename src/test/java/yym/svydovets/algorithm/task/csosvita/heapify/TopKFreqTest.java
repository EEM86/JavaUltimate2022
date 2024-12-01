package yym.svydovets.algorithm.task.csosvita.heapify;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import yym.svydovets.algorithm.task.csosvita.heapify.TopKFreq.TopKHelper;

class TopKFreqTest {

    @Test
    void topKFreq() {
        String s = "aaabbc";
        final String result = TopKFreq.findTopK(s, 3);
        System.out.println(result);
        assertEquals("c", result);
    }

    @Test
    void topKFreq2() {
        String s = "aaabb";
        final String result = TopKFreq.findTopK(s, 1);
        System.out.println(result);
        assertEquals("a", result);
    }

    @Test
    void topKFreq3() {
        String s = "aaabbbc";
        final String result = TopKFreq.findTopK(s, 3);
        System.out.println(result);
        assertEquals("NONE", result);
    }

    @Test
    void topKFreq4() {
        String s = "aaabcd";
        final String result = TopKFreq.findTopK(s, 2);
        System.out.println(result);
        assertEquals("b", result);
    }

    @Test
    void topKFreq5() {
        final TopKHelper[] tasks = new TopKHelper[4];
        tasks[0] = new TopKHelper("aaabbc", 3, 6);
        tasks[1] = new TopKHelper("aaabb", 1, 5);
        tasks[2] = new TopKHelper("aaabbbcc", 3, 8);
        tasks[3] = new TopKHelper("aabcd", 2, 5);

        String expected = """
            c
            a
            NONE
            b""";

        final String result = TopKFreq.topKFreq(tasks);
        assertEquals(expected, result);
    }
}