package com.zgl.leetcode.java.dynamic;

/**
 * @author zgl
 * @date 2019/12/20 上午11:00
 */
public class UglyNumber {

	public static void main(String[] args) {
		System.out.println(new UglyNumber().isUgly(14));
	}

	/**
	 * 263. Ugly Number
	 * Write a program to check whether a given number is an ugly number.
	 *
	 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
	 *
	 * Example 1:
	 *
	 * Input: 6
	 * Output: true
	 * Explanation: 6 = 2 × 3
	 * Example 2:
	 *
	 * Input: 8
	 * Output: true
	 * Explanation: 8 = 2 × 2 × 2
	 * Example 3:
	 *
	 * Input: 14
	 * Output: false
	 * Explanation: 14 is not ugly since it includes another prime factor 7.
	 */
	public boolean isUgly(int num) {
		while (num >= 2) {
			if (num % 2 == 0) {
				num /= 2;
			} else if (num % 3 == 0) {
				num /= 3;
			} else if (num % 5 == 0) {
				num /= 5;
			} else {
				return false;
			}
		}
		return num == 1;
	}

	/**
	 * 264. Ugly Number II
	 * Write a program to find the n-th ugly number.
	 *
	 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
	 *
	 * Example:
	 *
	 * Input: n = 10
	 * Output: 12
	 * Explanation: 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
	 * Note:
	 *
	 * 1 is typically treated as an ugly number.
	 * n does not exceed 1690.
	 */
	public int nthUglyNumber(int n) {
		/**
		 * (1) 1x2,✅  2x2,✅ 2x2, 3x2✅, 3x2, 4x2✅, 5x2✅...
		 * (2) 1x3,  1x3,✅ 2x3,✅ 2x3, 2x3, 3x3✅, 3x3...
		 * (3) 1x5,  1x5, 1x5,✅ 1x5, 2x5, 2x5, 2x5.✅..
		 * 每次从当前列表中取出的最小的加入序列
		 */
		int[] dp = new int[n];
		dp[0] = 1;
		int f2 = 2, f3 = 3, f5 = 5;
		int idx2 = 0, idx3 = 0, idx5 = 0;
		for (int i = 1; i < n; i++) {
			int min = Math.min(Math.min(f2, f3), f5);
			dp[i] = min;
			if (min == f2) {
				f2 = 2 * dp[++idx2];
			}
			if (min == f3) {
				f3 = 3 * dp[++idx3];
			}
			if (min == f5) {
				f5 = 5 * dp[++idx5];
			}
		}
		return dp[n - 1];
	}
}