package yym.svydovets.dataStructure.task.numbers;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;

import static org.junit.jupiter.api.Assertions.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class AsteroidCollisionTest {

  @Test
  @Order(1)
  public void testAsteroidsCollisionUsingStack_shouldCollapseTwoAsteroids() {
    int[] initial = new int[]{10,2,-5};
    int[] expected = new int[]{10};

    var actual = AsteroidCollision.asteroidCollisionUsingStack(initial);

    assertArrayEquals(expected, actual);
  }

  @Test
  @Order(2)
  public void testAsteroidsCollisionUsingStack_shouldCollapseOneAsteroid() {
    int[] initial = new int[]{5, 10, -5};
    int[] expected = new int[]{5, 10};

    var actual = AsteroidCollision.asteroidCollisionUsingStack(initial);

    assertArrayEquals(expected, actual);
  }

  @Test
  @Order(3)
  public void testAsteroidsCollisionUsingStack_shouldCollapseOnePositiveAsteroid() {
    int[] initial = new int[]{-2, -2, 1, -2};
    int[] expected = new int[]{-2, -2, -2};

    var actual = AsteroidCollision.asteroidCollisionUsingStack(initial);

    assertArrayEquals(expected, actual);
  }

  @Test
  @Order(4)
  public void testAsteroidsCollisionOptimal_shouldCollapseTwoAsteroids() {
    int[] initial = new int[]{10,2,-5};
    int[] expected = new int[]{10};

    var actual = AsteroidCollision.asteroidCollisionOptimal(initial);

    assertArrayEquals(expected, actual);
  }

  @Test
  @Order(5)
  public void testAsteroidsCollisionOptimal_shouldCollapseOneAsteroid() {
    int[] initial = new int[]{5, 10, -5};
    int[] expected = new int[]{5, 10};

    var actual = AsteroidCollision.asteroidCollisionOptimal(initial);

    assertArrayEquals(expected, actual);
  }

  @Test
  @Order(6)
  public void testAsteroidsCollisionOptimal_shouldCollapseOnePositiveAsteroid() {
    int[] initial = new int[]{-2, -2, 1, -2};
    int[] expected = new int[]{-2, -2, -2};

    var actual = AsteroidCollision.asteroidCollisionOptimal(initial);

    assertArrayEquals(expected, actual);
  }

}