package yym.svydovets.algorithm.task.csosvita.heapify;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class GoogleCalendarTest {

    @Test
    void formatCalendar() {
        int d = 28;
        var day = "Monday";
        String expected = """
            .1 .2 .3 .4 .5 .6 .7
            .8 .9 10 11 12 13 14
            15 16 17 18 19 20 21
            22 23 24 25 26 27 28""";
        final String result = GoogleCalendar.formatCalendar(d, day);
        System.out.println(result);
        assertEquals(expected, result);
    }

    @Test
    void formatCalendar2() {
        int d = 30;
        var day = "Saturday";
        String expected = """
            .. .. .. .. .. .1 .2
            .3 .4 .5 .6 .7 .8 .9
            10 11 12 13 14 15 16
            17 18 19 20 21 22 23
            24 25 26 27 28 29 30""";
        final String result = GoogleCalendar.formatCalendar(d, day);
        System.out.println(result);
        assertEquals(expected, result);
    }
}