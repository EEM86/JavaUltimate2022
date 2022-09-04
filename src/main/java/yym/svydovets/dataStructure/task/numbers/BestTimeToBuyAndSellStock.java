package yym.svydovets.dataStructure.task.numbers;

public class BestTimeToBuyAndSellStock {

  public static void main(String[] args) {
    var prices = new int[] {7,1,5,3,6,4};
    System.out.println(maxProfitOptimal(prices));

  }

  /*
  You are given an array prices where prices[i] is the price of a given stock on the ith day.
  You want to maximize your profit by choosing a single day to buy one stock and choosing
  a different day in the future to sell that stock.
  Return the maximum profit you can achieve from this transaction. If you cannot achieve any profit, return 0.
  Example 1:
  Input: prices = [7,1,5,3,6,4]
  Output: 5
  Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
  Note that buying on day 2 and selling on day 1 is not allowed because you must buy before you sell.

  */
  static int maxProfit(int[] prices) {
    int max = 0;
    int left = 0, right = 1;

    while (right < prices.length) {
      if (prices[right] > prices[left]) {
        int profit = prices[right] - prices[left];
        max = Math.max(max, profit);
      } else {
        left = right;
      }
      right++;
    }

    return max;
  }

  static int maxProfitOptimal(int[] prices) {
    int min = Integer.MAX_VALUE;
    int ans = Integer.MIN_VALUE;
    for (int val : prices) {
      min = Math.min(min, val);
      ans = Math.max(ans, val - min);
    }
    return ans;
  }

}
