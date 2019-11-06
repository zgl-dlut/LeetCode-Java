package com.zgl.leetcode.java.dynamic;

import java.util.Arrays;

/**
 * @author zgl
 * @date 2019/11/4 下午8:20
 */
public class CoinChange {
	/**
	 * 322. Coin Change
	 * You are given coins of different denominations and a total amount of money amount.
	 * Write a function to compute the fewest number of coins that you need to make up that amount.
	 * If that amount of money cannot be made up by any combination of the coins, return -1.
	 *
	 * Example 1:
	 *
	 * Input: coins = [1, 2, 5], amount = 11
	 * Output: 3
	 * Explanation: 11 = 5 + 5 + 1
	 * Example 2:
	 *
	 * Input: coins = [2], amount = 3
	 * Output: -1
	 * Note:
	 * You may assume that you have an infinite number of each kind of coin.
	 */
	public int coinChange1(int[] coins, int amount) {
		int n = coins.length;
		if (n == 0) {
			return -1;
		}
		int[] dp = new int[amount + 1];
		for (int i = 1; i <= amount; i++) {
			dp[i] = Integer.MAX_VALUE - 1;
			for (int j = 0; j < n; j++) {
				if (i >= coins[j]) {
					//!!!
					dp[i] = Math.min(dp[i], dp[i - coins[j]] + 1);
				}
			}
		}
		return dp[amount] == Integer.MAX_VALUE - 1 ? -1 : dp[amount];
	}

	public int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;
		for (int coin : coins) {
			for (int value = coin; value <= amount; value++) {
				dp[value] = Math.min(dp[value], dp[value - coin] + 1);
			}
		}
		return dp[amount] > amount ? -1 : dp[amount];
	}

	public static void main(String[] args) {
		int[] coins = {5,2,1};
		System.out.println(new CoinChange().coinChangeMax(coins, 7));
	}

	public int coinChangeMax(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, -amount);
		dp[0] = 0;
		for (int coin : coins) {
			for (int i = coin; i <= amount; i++) {
				dp[i] = Math.max(dp[i], dp[i - coin] + 1);
			}
		}
		return dp[amount] < 0 ? -1 : dp[amount];
	}
}