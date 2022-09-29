package yym.svydovets.dataStructure.task.numbers;

import org.apache.commons.lang3.NotImplementedException;

public class BestTimeToBuyAndSellStock {

  public static void main(String[] args) {
    var prices = new int[] {7,6,4,3,1};
    System.out.println(maxProfit(prices));

  }

  /*
  You are given an array prices where prices[i] is the price of a given stock on the ith day.
  You want to maximize your profit by choosing a single day to buy one stock and choosing
  a different day in the future to sell that stock.
  Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
  Example 1:
  Input: prices = [7,1,5,3,6,4] ; [7,6,4,3,1]
  Output: 5                     ; 1
  Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
  Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.
  https://leetcode.com/problems/best-time-to-buy-and-sell-stock/
  */
  static int maxProfit(int[] prices) {
    throw new NotImplementedException();
  }

}
