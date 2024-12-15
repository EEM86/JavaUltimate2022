package yym.svydovets.algorithm.task.csosvita.data_structures;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.Collectors;
import org.junit.jupiter.api.Test;

class StockSpanTest {

    @Test
    void getSpans1() {
        int[] arr = new int[]{100, 80, 60, 70, 60, 75, 85};

        final int[] spans = StockSpan.getSpans(arr);
        String result = Arrays.stream(spans)
            .mapToObj(String::valueOf)
            .collect(Collectors.joining(" "));
        assertEquals("1 1 1 2 1 4 6", result);
    }

    @Test
    void getSpans2() {
        int[] arr = new int[]{7,2,1,2,3};

        final int[] spans = StockSpan.getSpans(arr);
        String result = Arrays.stream(spans)
            .mapToObj(String::valueOf)
            .collect(Collectors.joining(" "));
        assertEquals("1 1 1 3 4", result);
    }

    @Test
    void getSpans3() {
        int[] arr = new int[]{7,34,1,2,8};

        final int[] spans = StockSpan.getSpans(arr);
        String result = Arrays.stream(spans)
            .mapToObj(String::valueOf)
            .collect(Collectors.joining(" "));
        assertEquals("1 2 1 2 3", result);
    }
}