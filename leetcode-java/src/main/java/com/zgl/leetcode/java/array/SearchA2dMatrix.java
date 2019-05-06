package com.zgl.leetcode.java.array;

/**
 * @author zgl
 * @date 2019/5/6 下午3:12
 */
public class SearchA2dMatrix {

	/**
	 * 74. Search a 2D Matrix
	 * Write an efficient algorithm that searches for a value in an m x n matrix.
	 * This matrix has the following properties:
	 *
	 * Integers in each row are sorted from left to right.
	 * The first integer of each row is greater than the last integer of the previous row.
	 * Example 1:
	 *
	 * Input:
	 * matrix = [
	 *   [1,   3,  5,  7],
	 *   [10, 11, 16, 20],
	 *   [23, 30, 34, 50]
	 * ]
	 * target = 3
	 * Output: true
	 * Example 2:
	 *
	 * Input:
	 * matrix = [
	 *   [1,   3,  5,  7],
	 *   [10, 11, 16, 20],
	 *   [23, 30, 34, 50]
	 * ]
	 * target = 13
	 * Output: false
	 */
	public boolean searchMatrix(int[][] matrix, int target) {
		int m = matrix.length;
		if (m == 0){
			return false;
		}
		int n = matrix[0].length;
		if (n == 0){
			return false;
		}
		if (target < matrix[0][0] || target > matrix[m - 1][n - 1]) {
			return false;
		}
		int tag = 0;
		while (tag < m) {
			int current = matrix[tag][0];
			if (current > target) {
				break;
			}
			tag++;
		}
		int left = 0, right = n - 1;
		while (left <= right) {
			int middle = (left + right) / 2;
			if (matrix[tag - 1][middle] == target) {
				return true;
			} else if (matrix[tag - 1][middle] > target) {
				right = middle - 1;
			} else {
				left = middle + 1;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		int[][] matrix = {{1}};
		System.out.println(new SearchA2dMatrix().searchMatrix(matrix, 1));
	}
}