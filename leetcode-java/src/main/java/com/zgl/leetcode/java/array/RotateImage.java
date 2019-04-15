package com.zgl.leetcode.java.array;

/**
 * @author zgl
 * @date 2019/4/15 下午3:05
 */
public class RotateImage {
	/**
	 * 48. Rotate Image
	 * You are given an n x n 2D matrix representing an image.
	 * <p>
	 * Rotate the image by 90 degrees (clockwise).
	 * <p>
	 * Note:
	 * <p>
	 * You have to rotate the image in-place, which means you have to modify the input 2D matrix directly. DO NOT allocate another 2D matrix and do the rotation.
	 * <p>
	 * Example 1:
	 * <p>
	 * Given input matrix =
	 * [
	 * [1,2,3],
	 * [4,5,6],
	 * [7,8,9]
	 * ],
	 * <p>
	 * rotate the input matrix in-place such that it becomes:
	 * [
	 * [7,4,1],
	 * [8,5,2],
	 * [9,6,3]
	 * ]
	 */
	public void rotate(int[][] matrix) {
		int n = matrix.length;
		int i, j, temp;
		for (i = 0; i < n / 2; i++) {
			for (j = i; j < n - i - 1; j++) {
				temp = matrix[i][j];
				matrix[i][j] = matrix[n - 1 - j][i];
				matrix[n - 1 - j][i] = matrix[n - i - 1][n - j - 1];
				matrix[n - i - 1][n - j - 1] = matrix[j][n - i - 1];
				matrix[j][n - i - 1] = temp;
			}
		}
	}
}