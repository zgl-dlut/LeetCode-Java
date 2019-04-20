package com.zgl.leetcode.java.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zgl
 * @date 2019/4/19 下午5:37
 */
public class SpiralMatrix {

	/**
	 * 54. Spiral Matrix
	 * Given a matrix of m x n elements (m rows, n columns),
	 * return all elements of the matrix in spiral order.
	 *
	 * Example 1:
	 *
	 * Input:
	 * [
	 *  [ 1, 2, 3 ],
	 *  [ 4, 5, 6 ],
	 *  [ 7, 8, 9 ]
	 * ]
	 * Output: [1,2,3,6,9,8,7,4,5]
	 * Example 2:
	 *
	 * Input:
	 * [
	 *   [1, 2, 3, 4],
	 *   [5, 6, 7, 8],
	 *   [9,10,11,12]
	 * ]
	 * Output: [1,2,3,4,8,12,11,10,9,5,6,7]
	 */
	public List<Integer> spiralOrder(int[][] matrix) {
		List<Integer> result = new ArrayList<>();
		if (matrix == null || matrix.length == 0){
			return result;
		}
		int width = matrix.length;
		int length = matrix[0].length;
		int left = 0, right = length - 1, top = 0, bottom = width - 1;
		while (result.size() < length * width) {
			for (int i = left; i <= right; i++) {
				result.add(matrix[top][i]);
			}
			top++;
			if (result.size() < length * width) {
				for (int i = top; i <= bottom; i++) {
					result.add(matrix[i][right]);
				}
			}
			right--;
			if (result.size() < length * width) {
				for (int i = right; i >= left; i--) {
					result.add(matrix[bottom][i]);
				}
			}
			bottom--;
			if (result.size() < length * width) {
				for (int i = bottom; i >= top; i--) {
					result.add(matrix[i][left]);
				}
			}
			left++;
		}
		return result;
	}

	public static void main(String[] args) {
		int[][] matrix = {/*{1,2,3,4},{5,6,7,8},{9,10,11,12}*/};
		System.out.println(new SpiralMatrix().spiralOrder(matrix));
	}
}