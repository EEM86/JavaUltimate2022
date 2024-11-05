package yym.svydovets.algorithm.task.csosvita.brute_force;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.Scanner;
import org.junit.jupiter.api.Test;
import yym.svydovets.algorithm.task.csosvita.brute_force.CourseChoose;

class CourseChooseTest {

    @Test
    void course() {
        int[][] courses = new int[][]{{0,0,0,1}, {0,0,1,0}, {0,1,1,1}, {1,1,1,1}, {0,0,0,0}, {1,0,0,1}};
        final String result = CourseChoose.course(6, 4, courses);
        assertEquals("2\n1 3", result);
    }
}