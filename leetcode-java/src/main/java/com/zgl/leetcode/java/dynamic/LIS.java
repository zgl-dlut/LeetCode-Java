package com.zgl.leetcode.java.dynamic;

import java.util.Arrays;

/**
 * 最长递增子序列
 *
 * @author zgl
 * @date 2018/12/8 下午5:01
 */
public class LIS {
	public int lengthOfLIS(int[] numbers) {
		int[] dp = new int[numbers.length];
		Arrays.fill(dp, 1);
		int result = 1;
		/**
		 * dp[i]表示以i为结尾的最长递增序列长度
		 *
		 * if(numbers[i]>numbers[j])
		 * dp[i]=Math.max(dp[j]+1,dp[i])
		 *
		 * result表示遍历当前元素的最大递增长度
		 */
		for (int i = 1; i < numbers.length; i++) {
			for (int j = 0; j < i; j++) {
				if (numbers[i] > numbers[j]) {
					dp[i] = Math.max(dp[j] + 1, dp[i]);
				}
				result = Math.max(dp[i - 1], dp[i]);
			}
		}
		for (int i : dp) {
			System.out.print(i + " ");
		}
		System.out.println();
		return result;
	}

	public static void main(String[] args) {
		LIS mock = new LIS();
		int[] numbers = {1, 3, 5, 2, 4, 6, 7, 8};
		System.out.println(mock.lengthOfLIS(numbers));
	}
}
