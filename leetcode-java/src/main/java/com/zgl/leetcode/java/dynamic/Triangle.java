package com.zgl.leetcode.java.dynamic;

import java.util.Arrays;
import java.util.List;

/**
 * @author zgl
 * @date 2019/9/20 下午7:28
 */
public class Triangle {

	/**
	 * 120. Triangle
	 *
	 * Given a triangle, find the minimum path sum from top to bottom. Each step you may move to adjacent numbers on the row below.
	 *
	 * For example, given the following triangle
	 *
	 * [
	 *      [2],
	 *     [3,4],
	 *    [6,5,7],
	 *   [4,1,8,3]
	 * ]
	 * The minimum path sum from top to bottom is 11 (i.e., 2 + 3 + 5 + 1 = 11).
	 *
	 * Note:
	 *
	 * Bonus point if you are able to do this using only O(n) extra space, where n is the total number of rows in the triangle.
	 */
	public int minimumTotal1(List<List<Integer>> triangle) {
		int n = triangle.size();
		int[][] dp = new int[n][n];
		dp[0][0] = triangle.get(0).get(0);
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				if (j == 0) {
					dp[i][j] = triangle.get(i).get(j) + dp[i - 1][j];
				} else if(j == i) {
					dp[i][j] = triangle.get(i).get(j) + dp[i - 1][j - 1];
				} else {
					dp[i][j] = triangle.get(i).get(j) + Math.min(dp[i - 1][j], dp[i - 1][j - 1]);
				}
			}
		}
		int[] last = dp[n - 1];
		int result = last[0];
		for (int i : last) {
			result = Math.min(i, result);
		}
		return result;
	}
}