package yym.svydovets.algorithm.task.csosvita.graphs;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Set;
import org.junit.jupiter.api.Test;
import yym.svydovets.algorithm.task.csosvita.graphs.WordTransformationTask;

class WordTransformationTaskTest {

    @Test
    void testTransformation1() {
        String start = "hit";
        String end = "cog";
        final Set<String> dict = Set.of("hot", "dot", "dog", "lot", "log", "cog");
        final WordTransformationTask tf = new WordTransformationTask(start, dict, end);
        final int result = tf.findShortestTransformations();
        assertEquals(5, result);
    }

    @Test
    void testTransformation2() {
        String start = "hit";
        String end = "cog";
        final Set<String> dict = Set.of("hot", "dot", "dog", "lot", "log");
        final WordTransformationTask tf = new WordTransformationTask(start, dict, end);
        final int result = tf.findShortestTransformations();
        assertEquals(0, result);
    }

}