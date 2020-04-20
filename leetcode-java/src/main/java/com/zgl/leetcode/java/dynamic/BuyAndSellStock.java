package com.zgl.leetcode.java.dynamic;

import java.time.LocalDate;
import java.time.ZoneOffset;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

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

	public static void main(String[] args) {
		int[] prices = {1, 2, 3, 0, 2};
		System.out.println(new BuyAndSellStock().maxProfit(prices));
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
	public int maxProfit4(int[] prices) {
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

	/**
	 * 309. Best Time to Buy and Sell Stock with Cooldown
	 * Say you have an array for which the ith element is the price of a given stock on day i.
	 * <p>
	 * Design an algorithm to find the maximum profit. You may complete as many transactions as you like
	 * (ie, buy one and sell one share of the stock multiple times) with the following restrictions:
	 * <p>
	 * You may not engage in multiple transactions at the same time (ie, you must sell the stock before you buy again).
	 * After you sell your stock, you cannot buy stock on next day. (ie, cooldown 1 day)
	 * Example:
	 * <p>
	 * Input: [1,2,3,0,2]
	 * Output: 3
	 * Explanation: transactions = [buy, sell, cooldown, buy, sell]
	 */
	public int maxProfit(int[] prices) {
		int n = prices.length;
		if (n == 0) {
			return 0;
		}
		int[] buys = new int[n + 1];
		int[] sells = new int[n + 1];
		buys[1] = -prices[0];
		for (int i = 2; i <= n; i++) {
			//在第i天买一支股票还能剩下的利润＝第(i-2)天销售能够剩余的利润－第i天股票的价钱．
			buys[i] = Math.max(buys[i - 1], sells[i - 2] - prices[i - 1]);
			//在第i天卖一支股票总的利润＝第(i-1)天买股票剩下的最大利润＋当前股票的价格．
			sells[i] = Math.max(sells[i - 1], buys[i - 1] + prices[i - 1]);
		}
		return sells[n];
	}
}