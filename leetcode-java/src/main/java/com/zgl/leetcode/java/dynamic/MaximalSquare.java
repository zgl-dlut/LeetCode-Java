package com.zgl.leetcode.java.dynamic;

/**
 * @author zgl
 * @date 2019/5/21 上午10:27
 */
public class MaximalSquare {

	/**
	 * 221. Maximal Square
	 *
	 * Given a 2D binary matrix filled with 0's and 1's, find the largest square containing only 1's and return its area.
	 *
	 * Example:
	 *
	 * Input:
	 *
	 * 1 0 1 0 0
	 * 1 0 1 1 1
	 * 1 1 1 1 1
	 * 1 0 0 1 0
	 *
	 * Output: 4
	 */
	public int maximalSquare(char[][] matrix) {

		int m = matrix.length;
		if (m == 0){
			return 0;
		}
		int n = matrix[0].length;
		int[][] dp = new int[m][n];
		int result = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == '1') {
					if (i == 0 || j == 0) {
						dp[i][j] = 1;
					}else {
						dp[i][j] = Math.min(dp[i - 1][j - 1], Math.min(dp[i][j - 1], dp[i - 1][j])) + 1;
					}
					result = Math.max(result, dp[i][j]);
				}
			}
		}
		return result * result;
	}
}