package yym.svydovets.dataStructure.task.numbers;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BestTimeToBuyAndSellStockTest {

  @Test
  public void testBestTimeToSell_v1() {
    int[] initial = new int[]{7,1,5,3,6,4};
    int expected = 5;

    int actual = BestTimeToBuyAndSellStock.maxProfit(initial);

    assertEquals(expected, actual);
  }

  @Test
  public void testBestTimeToSell_v2() {
    int[] initial = new int[]{7,6,4,3,1};
    int expected = 0;

    int actual = BestTimeToBuyAndSellStock.maxProfit(initial);

    assertEquals(expected, actual);
  }

}