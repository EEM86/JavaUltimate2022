package yym.svydovets.algorythm.task.graphs;

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

  @Test
  void canFinish_v3() {
    int numCourses = 5;
    int[][] prerequisites = { {0, 1}, {0, 2}, {1, 3}, {1, 4}, {3, 4} };

    final boolean result = service.canFinish(numCourses, prerequisites);

    assertTrue(result);
  }

  @Test
  void canFinish_v4() {
    int numCourses = 2;
    int[][] prerequisites = { {1, 0} };

    final boolean result = service.canFinish(numCourses, prerequisites);

    assertTrue(result);
  }

  @Test
  void canFinish_v5() {
    int numCourses = 2;
    int[][] prerequisites = { {1, 0}, {0, 1} };

    final boolean result = service.canFinishBfs(numCourses, prerequisites);

    assertFalse(result);
  }

  @Test
  void canFinish_v6() {
    int numCourses = 5;
    int[][] prerequisites = { {0, 1}, {0, 2}, {1, 3}, {1, 4}, {3, 4} };

    final boolean result = service.canFinishBfs(numCourses, prerequisites);

    assertTrue(result);
  }
}