package com.zgl.leetcode.java.array;

/**
 * @author zgl
 * @date 2019/4/30 下午2:44
 */
public class SetMatrixZeroes {

	/**
	 * 73. Set Matrix Zeroes
	 * Given a m x n matrix, if an element is 0,
	 * set its entire row and column to 0. Do it in-place.
	 * <p>
	 * Example 1:
	 * <p>
	 * Input:
	 * [
	 * [1,1,1],
	 * [1,0,1],
	 * [1,1,1]
	 * ]
	 * Output:
	 * [
	 * [1,0,1],
	 * [0,0,0],
	 * [1,0,1]
	 * ]
	 * Example 2:
	 * <p>
	 * Input:
	 * [
	 * [0,1,2,0],
	 * [3,4,5,2],
	 * [1,3,1,5]
	 * ]
	 * Output:
	 * [
	 * [0,0,0,0],
	 * [0,4,5,0],
	 * [0,3,1,0]
	 * ]
	 */
	public void setZeroes(int[][] matrix) {

		int m = matrix.length;
		int n = matrix[0].length;
		boolean row0Tag = false, column0Tag = false;
		for (int i = 0; i < n; i++) {
			if (matrix[0][i] == 0) {
				row0Tag = true;
			}
		}
		for (int i = 0; i < m; i++) {
			if (matrix[i][0] == 0) {
				column0Tag = true;
			}
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][j] == 0) {
					matrix[i][0] = 0;
					matrix[0][j] = 0;
				}
			}
		}
		for (int i = 1; i < m; i++) {
			for (int j = 1; j < n; j++) {
				if (matrix[i][0] == 0 || matrix[0][j] == 0) {
					matrix[i][j] = 0;
				}
			}
		}
		if (row0Tag) {
			for (int i = 0; i < n; i++) {
				matrix[0][i] = 0;
			}
		}
		if (column0Tag) {
			for (int i = 0; i < m; i++) {
				matrix[i][0] = 0;
			}
		}
	}

	/**
	 * O(m*n)
	 */
	public void setZeroes1(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int[][] copy = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				copy[i][j] = matrix[i][j];
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (matrix[i][j] == 0) {
					for (int k = 0; k < n; k++) {
						copy[i][k] = 0;
					}
					break;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (matrix[j][i] == 0) {
					for (int k = 0; k < m; k++) {
						copy[k][i] = 0;
					}
					break;
				}
			}
		}
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				matrix[i][j] = copy[i][j];
			}
		}
	}
}