package yym.svydovets.algorithm.task.csosvita.two_pointers;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SensorsTest {

    @Test
    void testCountSensors1() {
        int[] arr = new int[]{1, 6, 12, 13};
        int n = 4;

        final long result = Sensors.countSensors(arr, n);
        assertEquals(5, result);
    }

    @Test
    void testCountSensors2() {
        int[] arr = new int[]{1, 3, 5, 8};
        int n = 4;

        final long result = Sensors.countSensors(arr, n);
        assertEquals(2, result);
    }

    @Test
    void testCountSensors3() {
        int[] arr = new int[]{1, 3, 6, 8};
        int n = 4;

        final long result = Sensors.countSensors(arr, n);
        assertEquals(3, result);
    }

    @Test
    void testCountSensors4() {
        int[] arr = new int[]{0, 1, 4, 7, 8, 9, 10};
        int n = 3;

        final long result = Sensors.countSensors(arr, n);
        assertEquals(12, result);
    }

}