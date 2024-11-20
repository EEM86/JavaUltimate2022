package yym.svydovets.algorithm.task.csosvita.search;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.Random;
import org.junit.jupiter.api.Test;

class HourDiffTest {

    @Test
    void hoursDiff() {
        String s = "23:59 00:00";

        final int[] arr = HourDiff.parsing(s);
        final int result = HourDiff.hoursDiff(arr);
        assertEquals(1, result);
    }

    @Test
    void hoursDiff2() {
        String s = "00:00 23:59 00:00";

        final int[] arr = HourDiff.parsing(s);
        final int result = HourDiff.hoursDiff(arr);
        assertEquals(0, result);
    }

    @Test
    void hoursDiff3() {
        String s = "01:00 23:59";
        int[] a = new int[]{2,2};

        final int[] arr = HourDiff.parsing(s);
        final int result = HourDiff.hoursDiff(arr);
        assertEquals(61, result);
    }

    @Test
    void hoursDiff4() {
        String s = "09:00 10:02";

        final int[] arr = HourDiff.parsing(s);
        final int result = HourDiff.hoursDiff(arr);
        assertEquals(62, result);
    }

    @Test
    void hoursDiff5() {
        String s = "01:05 03:10 22:55";

        final int[] arr = HourDiff.parsing(s);
        final int result = HourDiff.hoursDiff(arr);
        assertEquals(125, result);
    }

    @Test
    void hoursDiff6() {
        String s = "12:00 06:00 00:00";

        final int[] arr = HourDiff.parsing(s);
        final int result = HourDiff.hoursDiff(arr);
        assertEquals(360, result);
    }

    @Test
    void testParsing() {
        String s = "00:00 23:59";
        final int[] parsedString = HourDiff.parsing(s);
        assertEquals("[0, 1439]", Arrays.toString(parsedString));
    }
}