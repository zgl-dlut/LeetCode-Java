package com.zgl.leetcode.java.integer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zgl
 * @date 2019/5/23 上午11:34
 */
public class HammingDistance {

	/**
	 * 461. Hamming Distance
	 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.
	 *
	 * Given two integers x and y, calculate the Hamming distance.
	 *
	 * Note:
	 * 0 ≤ x, y < 231.
	 *
	 * Example:
	 *
	 * Input: x = 1, y = 4
	 *
	 * Output: 2
	 *
	 * Explanation:
	 * 1   (0 0 0 1)
	 * 4   (0 1 0 0)
	 *        ↑   ↑
	 *
	 * The above arrows point to positions where the corresponding bits are different.
	 */
	public int hammingDistance1(int x, int y) {
		List<Integer> binaryX = convertToBinary(x);
		List<Integer> binaryY = convertToBinary(y);
		int lengthX = binaryX.size();
		int lengthY = binaryY.size();
		for (int j = 0; j < Math.abs(lengthX - lengthY); j++) {
			if (lengthX < lengthY) {
				binaryX.add(0, 0);
			}
			if (lengthX > lengthY) {
				binaryY.add(0, 0);
			}
		}
		int result = 0, i;
		for (i = 0; i < binaryX.size(); i++) {
			if (binaryX.get(i) + binaryY.get(i) == 1) {
				result++;
			}
		}
		return result;
	}

	private List<Integer> convertToBinary(int num) {
		List<Integer> binary = new ArrayList<>();
		while (num > 0) {
			binary.add(0, num % 2);
			num /= 2;
		}
		return binary;
	}

	public int hammingDistance(int x, int y) {
		int result = x ^ y;
		int sum = 0;
		while (result != 0) {
			sum += result & 1;
			result = result >> 1;
		}
		return sum;
	}
	public static void main(String[] args) {
		System.out.println(new HammingDistance().hammingDistance(1,4));
		System.out.println(5 & 1);
	}
}