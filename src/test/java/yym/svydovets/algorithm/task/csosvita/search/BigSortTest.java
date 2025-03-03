package yym.svydovets.algorithm.task.csosvita.search;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import yym.svydovets.algorithm.task.csosvita.sort.BigSort.Result;

class BigSortTest {

    @Test
    void testBigSorting1() {
        var unsorted = new ArrayList<String>();
        unsorted.add("1");
        unsorted.add("200");
        unsorted.add("150");
        unsorted.add("3");
        final List<String> result = Result.bigSorting(unsorted);

        assertEquals("1", result.get(0));
        assertEquals("3", result.get(1));
        assertEquals("150", result.get(2));
        assertEquals("200", result.get(3));
    }

    @Test
    void testBigSorting2() {
        var unsorted = new ArrayList<String>();
        unsorted.add("31415926535897932384626433832795");
        unsorted.add("1");
        unsorted.add("3");
        unsorted.add("10");
        unsorted.add("3");
        unsorted.add("5");
        final List<String> result = Result.bigSorting(unsorted);

        assertEquals("1", result.get(0));
        assertEquals("3", result.get(1));
        assertEquals("3", result.get(2));
        assertEquals("5", result.get(3));
        assertEquals("10", result.get(4));
        assertEquals("31415926535897932384626433832795", result.get(5));
    }

    @Test
    void testBigSorting3() {
        var unsorted = new ArrayList<String>();
        unsorted.add("1");
        unsorted.add("2");
        unsorted.add("100");
        unsorted.add("12303479849857341718340192371");
        unsorted.add("3084193741082937");
        unsorted.add("3084193741082938");
        unsorted.add("111");
        unsorted.add("200");
        final List<String> result = Result.bigSorting(unsorted);

        assertEquals("1", result.get(0));
        assertEquals("2", result.get(1));
        assertEquals("100", result.get(2));
        assertEquals("111", result.get(3));
        assertEquals("200", result.get(4));
        assertEquals("3084193741082937", result.get(5));
        assertEquals("3084193741082938", result.get(6));
        assertEquals("12303479849857341718340192371", result.get(7));
    }

}