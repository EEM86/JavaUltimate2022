package yym.svydovets.algorythm.task.numbers;

import org.junit.jupiter.api.Test;
import yym.svydovets.algorythm.task.numbers.ProductOfArrayExceptSelf;

import static org.junit.jupiter.api.Assertions.*;

class ProductOfArrayExceptSelfTest {

  @Test
  void testProductExceptSelf() {
    int[] input = new int[]{1,2,3,4};
    int[] expected = new int[]{24,12,8,6};

    int[] actual = ProductOfArrayExceptSelf.productExceptSelf(input);

    assertArrayEquals(expected, actual);
  }

}