package com.zgl.leetcode.java.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zgl
 * @date 2019/8/17 下午11:26
 */
public class Nqueens {
	public static void main(String[] args) {
		System.out.println(new Nqueens().solveNQueens(4));
	}

	/**
	 * 51. N-Queens
	 * Given an integer n, return all distinct solutions to the n-queens puzzle.
	 *
	 * Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.
	 *
	 * Example:
	 *
	 * Input: 4
	 * Output: [
	 *  [".Q..",  // Solution 1
	 *   "...Q",
	 *   "Q...",
	 *   "..Q."],
	 *
	 *  ["..Q.",  // Solution 2
	 *   "Q...",
	 *   "...Q",
	 *   ".Q.."]
	 * ]
	 * Explanation: There exist two distinct solutions to the 4-queens puzzle as shown above.
	 */
	public List<List<String>> solveNQueens(int n) {
		List<List<String>> result = new ArrayList<>();
		if(n <= 0) {
			return result;
		}
		//每个一位数组的元素存储每一行的皇后位置,所以不用担心多个皇后同一行的问题
		int[] position = new int[n];
		backtracking(n, 0, position, result);
		return result;
	}

	private void backtracking(int n, int row, int[] position, List<List<String>> result) {
		//组装结果
		if (row == n) {
			List<String> answer = new ArrayList<>();
			for(int i = 0; i < n; i++) {
				StringBuilder sb = new StringBuilder();
				for(int j = 0; j < n; j++) {
					//position[i]存放第i行的皇后位置,判断条件为(j == position[i])
					sb.append(j == position[i] ? "Q" : ".");
				}
				answer.add(sb.toString());
			}
			result.add(answer);
		}else {
			for(int i = 0; i < n; i++) {
				position[row] = i;
				if (valid(row, position)) {
					backtracking(n, row + 1, position, result);
				}
			}
		}
	}

	private boolean valid(int row, int[] position) {
		for(int i = 0; i < row; i++) {
			//存在第i行的皇后和row行的皇后在同一个列 || 同一对角线
			if(position[i] == position[row] || Math.abs(position[i] - position[row]) == row - i) {
				return false;
			}
		}
		return true;
	}
}