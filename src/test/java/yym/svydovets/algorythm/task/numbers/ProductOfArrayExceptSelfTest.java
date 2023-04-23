package yym.svydovets.algorythm.task.numbers;

import org.junit.jupiter.api.Test;
import yym.svydovets.algorythm.task.numbers.ProductOfArrayExceptSelf;

import static org.junit.jupiter.api.Assertions.*;

class ProductOfArrayExceptSelfTest {

  @Test
  void testProductExceptSelf_v1() {
    int[] input = new int[]{1,2,3,4};
    int[] expected = new int[]{24,12,8,6};

    int[] actual = ProductOfArrayExceptSelf.productExceptSelf(input);

    assertArrayEquals(expected, actual);
  }

  @Test
  void testProductExceptSelf_v2() {
    int[] input = new int[]{-1,1,0,-3,3};
    int[] expected = new int[]{0,0,9,0,0};

    int[] actual = ProductOfArrayExceptSelf.productExceptSelf(input);

    assertArrayEquals(expected, actual);
  }

}