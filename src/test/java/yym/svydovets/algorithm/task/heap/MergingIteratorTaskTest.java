package yym.svydovets.algorithm.task.heap;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import org.junit.jupiter.api.Test;
import yym.svydovets.algorithm.task.heap.MergingIteratorTask.MergingIterator;

class MergingIteratorTaskTest {

    @Test
    void test() {
        List<Iterator<Integer>> iterators = Arrays.asList(
            Arrays.asList(2, 5, 9).iterator(),
            Arrays.asList(-2, -1, 0, 1, 2).iterator(),
            Arrays.asList(4, 10).iterator());
        MergingIterator itr = new MergingIterator(iterators);

        assertTrue(itr.hasNext());
        assertEquals(-2, itr.next());
        assertEquals(-1, itr.next());
        assertEquals(0, itr.next());
        assertEquals(1, itr.next());
        assertEquals(2, itr.next());
        assertEquals(2, itr.next());
        assertEquals(4, itr.next());
        assertEquals(5, itr.next());
        assertEquals(9, itr.next());
        assertEquals(10, itr.next());
        assertFalse(itr.hasNext());
    }

}