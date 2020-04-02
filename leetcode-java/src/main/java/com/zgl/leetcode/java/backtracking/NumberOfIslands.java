package com.zgl.leetcode.java.backtracking;

/**
 * @author zgl
 * @date 2019/11/3 下午3:16
 */
public class NumberOfIslands {
	/**
	 * 200. Number of Islands
	 * 矩阵连续区域
	 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
	 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
	 * You may assume all four edges of the grid are all surrounded by water.
	 * <p>
	 * Example 1:
	 * <p>
	 * Input:
	 * 11110
	 * 11010
	 * 11000
	 * 00000
	 * <p>
	 * Output: 1
	 * Example 2:
	 * <p>
	 * Input:
	 * 11000
	 * 11000
	 * 00100
	 * 00011
	 * <p>
	 * Output: 3
	 */
	public int numIslands(char[][] grid) {
		int m = grid.length;
		if (m == 0) {
			return 0;
		}
		int n = grid[0].length;
		int count = 0;
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (grid[i][j] == '1') {
					count++;
					dfs(grid, i, j);
				}
			}
		}
		return count;
	}

	private void dfs(char[][] grid, int i, int j) {
		boolean flag = i < 0 || j < 0 || i >= grid.length
				|| j >= grid[0].length || grid[i][j] != '1';
		if (!flag) {
			grid[i][j] = 'z';
			dfs(grid, i + 1, j);
			dfs(grid, i - 1, j);
			dfs(grid, i, j + 1);
			dfs(grid, i, j - 1);
		}
	}
}