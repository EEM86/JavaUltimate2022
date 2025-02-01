package yym.svydovets.algorithm.task.csosvita.graphs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class IsWordExistTaskTest {

    @Test
    void isWordExist1() {
        var words = new Character[][]{
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'},
        };
        final int result = IsWordExistTask.isWordExist(words, "ABCCED");
        assertEquals(1, result);
    }

    @Test
    void isWordExist2() {
        var words = new Character[][]{
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'},
        };
        final int result = IsWordExistTask.isWordExist(words, "SEE");
        assertEquals(1, result);
    }

    @Test
    void isWordExist3() {
        var words = new Character[][]{
            {'A','B','C','E'},
            {'S','F','C','S'},
            {'A','D','E','E'},
        };
        final int result = IsWordExistTask.isWordExist(words, "SEA");
        assertEquals(0, result);
    }
}