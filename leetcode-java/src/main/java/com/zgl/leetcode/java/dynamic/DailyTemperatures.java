package com.zgl.leetcode.java.dynamic;

import java.util.Stack;

/**
 * @author zgl
 * @date 2019/11/12 下午9:17
 */
public class DailyTemperatures {
	public static void main(String[] args) {
		int[] T = {73, 74, 75, 71, 69, 72, 76, 73};
		new DailyTemperatures().dailyTemperatures(T);
	}

	/**
	 * 739. Daily Temperatures
	 * Given a list of daily temperatures T, return a list such that, for each day in the input,
	 * tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible,put 0 instead.
	 *
	 * For example, given the list of temperatures T = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].
	 */
	public int[] dailyTemperatures1(int[] T) {
		int n = T.length;
		int[] dp = new int[n];
		if (n == 0) {
			return dp;
		}
		for (int i = 0; i < n; i++) {
			dp[i] = 0;
			for (int j = i + 1; j < n; j++) {
				if (T[j] > T[i]) {
					dp[i] = j - i;
					break;
				}
			}
		}
		return dp;
	}

	public int[] dailyTemperatures(int[] T) {
		Stack<Integer> stack = new Stack<>();
		int[] result = new int[T.length];
		for (int i = 0; i < T.length; i++) {
			while (!stack.isEmpty() && T[i] > T[stack.peek()]) {
				int index = stack.pop();
				result[index] = i - index;
			}
			stack.push(i);
		}
		return result;
	}
}