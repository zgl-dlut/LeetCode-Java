package com.zgl.leetcode.java.dynamic;

/**
 * @author zgl
 * @date 2019/5/15 下午3:44
 */
public class BuyAndSellStock {

	/**
	 * 121. Best Time to Buy and Sell Stock
	 * <p>
	 * Example 1:
	 * <p>
	 * Input: [7,1,5,3,6,4]
	 * Output: 5
	 * Explanation: Buy on day 2 (price = 1) and sell on day 5 (price = 6), profit = 6-1 = 5.
	 * Not 7-1 = 6, as selling price needs to be larger than buying price.
	 * Example 2:
	 * <p>
	 * Input: [7,6,4,3,1]
	 * Output: 0
	 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
	 */

	public int maxProfit2(int[] prices) {
		int result = 0;
		if (prices.length == 0) {
			return result;
		}
		int minPrice = prices[0];
		for (int i = 1; i < prices.length; i++) {
			minPrice = Math.min(minPrice, prices[i]);
			result = Math.max(result, prices[i] - minPrice);
		}
		return result;
	}

	public int maxProfi1(int[] prices) {
		if (prices.length == 0) {
			return 0;
		}
		int[] dp = new int[prices.length];
		int minPrice = prices[0];
		for (int i = 1; i < prices.length; i++) {
			minPrice = Math.min(minPrice, prices[i]);
			dp[i] = Math.max(dp[i - 1], prices[i] - minPrice);
		}
		return dp[prices.length - 1];
	}

	/**
	 * 122. Best Time to Buy and Sell Stock II
	 * <p>
	 * Example 1:
	 * <p>
	 * Input: [7,1,5,3,6,4]
	 * Output: 7
	 * Explanation: Buy on day 2 (price = 1) and sell on day 3 (price = 5), profit = 5-1 = 4.
	 * Then buy on day 4 (price = 3) and sell on day 5 (price = 6), profit = 6-3 = 3.
	 * Example 2:
	 * <p>
	 * Input: [1,2,3,4,5]
	 * Output: 4
	 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
	 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
	 * engaging multiple transactions at the same time. You must sell before buying again.
	 * Example 3:
	 * <p>
	 * Input: [7,6,4,3,1]
	 * Output: 0
	 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
	 */
	public int maxProfit3(int[] prices) {
		int result = 0;
		if (prices.length == 0) {
			return result;
		}
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1]) {
				result += prices[i] - prices[i - 1];
			}
		}
		return result;
	}

	/**
	 * 123. Best Time to Buy and Sell Stock III
	 * <p>
	 * Example 1:
	 * <p>
	 * Input: [3,3,5,0,0,3,1,4]
	 * Output: 6
	 * Explanation: Buy on day 4 (price = 0) and sell on day 6 (price = 3), profit = 3-0 = 3.
	 * Then buy on day 7 (price = 1) and sell on day 8 (price = 4), profit = 4-1 = 3.
	 * Example 2:
	 * <p>
	 * Input: [1,2,3,4,5]
	 * Output: 4
	 * Explanation: Buy on day 1 (price = 1) and sell on day 5 (price = 5), profit = 5-1 = 4.
	 * Note that you cannot buy on day 1, buy on day 2 and sell them later, as you are
	 * engaging multiple transactions at the same time. You must sell before buying again.
	 * Example 3:
	 * <p>
	 * Input: [7,6,4,3,1]
	 * Output: 0
	 * Explanation: In this case, no transaction is done, i.e. max profit = 0.
	 */
	public int maxProfit(int[] prices) {
		//将原来的price[0..n-1]分割为price[0..j]和price[j..n-1]，分别求两段的最大profit。
		if (prices.length < 2) {
			return 0;
		}
		int length = prices.length;
		int[] left = new int[length];
		int[] right = new int[length];
		int leftMin = prices[0];
		int rightMax = prices[length - 1];
		for (int i = 1; i < length; i++) {
			left[i] = Math.max(left[i - 1], prices[i] - leftMin);
			leftMin = Math.min(prices[i], leftMin);
			right[length - i - 1] = Math.max(right[length - i], rightMax - prices[length - i - 1]);
			rightMax = Math.max(prices[length - i - 1], rightMax);
		}
		int result = 0;
		for (int i = 0; i < length; i++) {
			result = Math.max(result, left[i] + right[i]);
		}
		return result;
	}


	public static void main(String[] args) {
		int[] prices = {3,3,5,0,0,3,1,4};
		System.out.println(new BuyAndSellStock().maxProfit(prices));
	}
}