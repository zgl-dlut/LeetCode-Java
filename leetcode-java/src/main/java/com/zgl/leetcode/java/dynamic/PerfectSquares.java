package com.zgl.leetcode.java.dynamic;

import java.util.Arrays;

/**
 * @author zgl
 * @date 2019/5/21 下午6:01
 */
public class PerfectSquares {

	/**
	 * 279. Perfect Squares
	 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
	 *
	 * Example 1:
	 *
	 * Input: n = 12
	 * Output: 3
	 * Explanation: 12 = 4 + 4 + 4.
	 * Example 2:
	 *
	 * Input: n = 13
	 * Output: 2
	 * Explanation: 13 = 4 + 9.
	 */
	public int numSquares(int n) {

		/**
		 * dp[i]表示第i个数至少有多少个完全平方数的和组成
		 */
		int[] dp = new int[n + 1];
		Arrays.fill(dp, Integer.MAX_VALUE);
		dp[0] = 0;
		for (int i = 1; i <= n; i++) {
			int min = Integer.MAX_VALUE;
			int j = 1;
			while (i - j * j >= 0) {
				min = Math.min(min, dp[i - j * j]);
				j++;
			}
			dp[i] = min + 1;
		}
		return dp[n];
	}

	public static void main(String[] args) {
		System.out.println(new PerfectSquares().numSquares(11));
	}
}