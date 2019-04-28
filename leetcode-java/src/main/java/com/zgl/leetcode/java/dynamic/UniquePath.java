package com.zgl.leetcode.java.dynamic;

/**
 * @author zgl
 * @date 2019/4/26 上午11:35
 */
public class UniquePath {

	/**
	 * 62. Unique Paths
	 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
	 *
	 * The robot can only move either down or right at any point in time.
	 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
	 * Example 1:
	 *
	 * Input: m = 3, n = 2
	 * Output: 3
	 * Explanation:
	 * From the top-left corner, there are a total of 3 ways to reach the bottom-right corner:
	 * 1. Right -> Right -> Down
	 * 2. Right -> Down -> Right
	 * 3. Down -> Right -> Right
	 * Example 2:
	 *
	 * Input: m = 7, n = 3
	 * Output: 28
	 */
	public int uniquePaths(int m, int n) {
		/**
		 * 对于格点(i,j)。由于只能从上格点(i-1,j)或左格点(i,j-1)到达，并且两者路径是不重复的
		 *
		 * 因此dp[i][j] = dp[i-1][j]+dp[i][j-1]
		 */
		int[][] dp = new int[m][n];
		for (int i = 0; i < n; i++) {
			dp[0][i] = 1;
		}
		for (int i = 0; i < m; i++) {
			dp[i][0] = 1;
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[m - 1][n - 1];
	}

	/**
	 * 63. Unique Paths II
	 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
	 *
	 * The robot can only move either down or right at any point in time.
	 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
	 *
	 * Now consider if some obstacles are added to the grids. How many unique paths would there be?
	 *
	 * An obstacle and empty space is marked as 1 and 0 respectively in the grid.
	 *
	 * Note: m and n will be at most 100.
	 *
	 * Example 1:
	 *
	 * Input:
	 * [
	 *   [0,0,0],
	 *   [0,1,0],
	 *   [0,0,0]
	 * ]
	 * Output: 2
	 * Explanation:
	 * There is one obstacle in the middle of the 3x3 grid above.
	 * There are two ways to reach the bottom-right corner:
	 * 1. Right -> Right -> Down -> Down
	 * 2. Down -> Down -> Right -> Right
	 */
	public int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int m = obstacleGrid.length;
		int n = obstacleGrid[0].length;
		int[][] dp = new int[m][n];
		dp[0][0] = obstacleGrid[0][0] == 1 ? 0 : 1;
		for (int i = 1; i < m; i++) {
			dp[i][0] = obstacleGrid[i][0] == 1 ? 0 : dp[i - 1][0];
		}
		for (int i = 1; i < n; i++) {
			dp[0][i] = obstacleGrid[0][i] == 1 ? 0 : dp[0][i - 1];
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = obstacleGrid[i][j] == 1 ? 0 : dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[m - 1][n - 1];
	}

	/**
	 * 64. Minimum Path Sum
	 * Given a m x n grid filled with non-negative numbers,
	 * find a path from top left to bottom right which minimizes the sum of all numbers along its path.
	 *
	 * Note: You can only move either down or right at any point in time.
	 *
	 * Example:
	 *
	 * Input:
	 * [
	 *   [1,3,1],
	 *   [1,5,1],
	 *   [4,2,1]
	 * ]
	 * Output: 7
	 * Explanation: Because the path 1→3→1→1→1 minimizes the sum.
	 */
	public int minPathSum(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int[][] dp = new int[m][n];
		dp[0][0] = grid[0][0];
		for (int i = 1; i < m; i++) {
			dp[i][0] = grid[i][0] + dp[i - 1][0];
		}
		for (int i = 1; i < n; i++) {
			dp[0][i] = grid[0][i] + dp[0][i - 1];
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				dp[i][j] = grid[i][j] + Math.min(dp[i - 1][j], dp[i][j - 1]);
			}
		}
		return dp[m - 1][n - 1];
	}

	/**
	 * O(n)空间复杂度
	 */
	public int minPathSum1(int[][] grid){
	 	int m = grid.length;
	 	int n = grid[0].length;
	 	int[] dp = new int[m];
	 	dp[0] = grid[0][0];
	 	for (int i = 1; i < m; i++){
	 		dp[i] = grid[i][0] + dp[i - 1];
	    }
	    for (int j = 1; j < n; j++){
	 		for (int i = 0; i < m; i++){
	 			dp[i] = (i == 0 ? dp[i] : Math.min(dp[i], dp[i - 1])) + grid[i][j];
		    }
	    }
	    return dp[m - 1];
	}
}
