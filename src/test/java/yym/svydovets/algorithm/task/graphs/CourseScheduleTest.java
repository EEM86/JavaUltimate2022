package yym.svydovets.algorithm.task.graphs;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CourseScheduleTest {

  CourseSchedule service;

  @BeforeEach
  void setUp() {
    service = new CourseSchedule();
  }

  @Test
  void canFinish_v1() {
    int numCourses = 2;
    int[][] prerequisites = { {1, 0} };

    final boolean result = service.canFinish(numCourses, prerequisites);

    assertTrue(result);
  }

  @Test
  void canFinish_v2() {
    int numCourses = 2;
    int[][] prerequisites = { {1, 0}, {0, 1} };

    final boolean result = service.canFinish(numCourses, prerequisites);

    assertFalse(result);
  }
}