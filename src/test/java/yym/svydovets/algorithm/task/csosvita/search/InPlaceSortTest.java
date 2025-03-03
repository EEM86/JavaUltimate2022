package yym.svydovets.algorithm.task.csosvita.search;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InPlaceSortTest {

    @Test
    void sort2dArrayV1() {
        int[][] arr = new int[][]{
            {5,12,17,21,23},
            {1,2,4,6,8},
            {12,14,18,19,27},
            {3,7,9,15,25},
        };
        String expected = """
            1 2 3 4 5\s
            6 7 8 9 12\s
            12 14 15 17 18\s
            19 21 23 25 27\s""";
        InPlaceSort.sort2dArray(arr);
        final String result = InPlaceSort.printArray(arr);
        assertEquals(expected, result);
    }
}