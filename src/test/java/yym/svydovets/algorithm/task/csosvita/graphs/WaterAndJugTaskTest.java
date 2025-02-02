package yym.svydovets.algorithm.task.csosvita.graphs;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class WaterAndJugTaskTest {

    @Test
    void waysToRichTarget1() {
        final WaterAndJugTask service = new WaterAndJugTask(3, 5, 4);
        final int result = service.waysToRichTarget();
        assertEquals(1, result);
    }

    @Test
    void waysToRichTarget2() {
        final WaterAndJugTask service = new WaterAndJugTask(2, 6, 5);
        final int result = service.waysToRichTarget();
        assertEquals(0, result);
    }

    @Test
    void waysToRichTarget3() {
        final WaterAndJugTask service = new WaterAndJugTask(1, 2, 3);
        final int result = service.waysToRichTarget();
        assertEquals(1, result);
    }
}