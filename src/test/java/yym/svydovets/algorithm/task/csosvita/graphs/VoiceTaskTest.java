package yym.svydovets.algorithm.task.csosvita.graphs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class VoiceTaskTest {

    @Test
    void getMinCommunicationDistance1() {
        int[][] people = new int[][]{
            {-2000, 3000},
            {-2000, 3000}
        };
        final VoiceTask solution = new VoiceTask(people);
        final double result = solution.findMinimumVoiceNeeded();
        assertEquals(0.0, result, 1e-6);
    }

    @Test
    void getMinCommunicationDistance2() {
        int[][] people = new int[][]{
            {3, 2},
            {3, 3},
            {3, 4},
            {3, 3},
            {3, 9},
            {3, 8},
            {3, 1}
        };
        final VoiceTask solution = new VoiceTask(people);
        final double result = solution.findMinimumVoiceNeeded();
        System.out.println(result);
        assertEquals(4.0, result, 1e-6);
    }

    @Test
    void getMinCommunicationDistance3() {
        int[][] people = new int[][]{
            {5, 0},
            {0, 5},
            {-5, 0},
            {0, -5},
        };
        final VoiceTask solution = new VoiceTask(people);
        final double result = solution.findMinimumVoiceNeeded();
        assertEquals(7.0710678118654755, result, 1e-6);
    }

}