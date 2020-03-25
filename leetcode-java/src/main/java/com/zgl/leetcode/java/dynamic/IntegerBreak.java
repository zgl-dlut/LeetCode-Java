package com.zgl.leetcode.java.dynamic;

import java.util.Arrays;

/**
 * @author zgl
 * @date 2020/3/24 上午10:29
 */
public class IntegerBreak {

	/**
	 * 343. Integer Break
	 * Given a positive integer n, break it into the sum of at least two positive integers and maximize the product of those integers. Return the maximum product you can get.
	 *
	 * Example 1:
	 *
	 * Input: 2
	 * Output: 1
	 * Explanation: 2 = 1 + 1, 1 × 1 = 1.
	 * Example 2:
	 *
	 * Input: 10
	 * Output: 36
	 * Explanation: 10 = 3 + 3 + 4, 3 × 3 × 4 = 36.
	 * Note: You may assume that n is not less than 2 and not larger than 58.
	 */
	public int integerBreak(int n) {
		int[] dp = new int[n + 1];
		Arrays.fill(dp, 1);
		for (int i = 3; i <= n; i++) {
			for (int j = 1; j < i; j++) {
				//j * (i - j)拆分两个数字,j * dp[i - j]拆分多个数字
				dp[i] = Math.max(dp[i], Math.max(j * (i - j), j * dp[i - j]));
			}
		}
		return dp[n];
	}

}