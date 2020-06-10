package com.zgl.leetcode.java.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zgl
 * @date 2019/7/1 上午11:07
 */
public class GrayCode {
	public static void main(String[] args) {
		System.out.println(new GrayCode().grayCode(3));
	}

	/**
	 * 89. Gray Code
	 * 在一组数的编码中，若任意两个相邻的代码只有一位二进制数不同，则称这种编码为格雷码（Gray Code）
	 * Example 1:
	 *
	 * Input: 2
	 * Output: [0,1,3,2]
	 * Explanation:
	 * 00 - 0
	 * 01 - 1
	 * 11 - 3
	 * 10 - 2
	 *
	 * For a given n, a gray code sequence may not be uniquely defined.
	 * For example, [0,2,3,1] is also a valid gray code sequence.
	 *
	 * 00 - 0
	 * 10 - 2
	 * 11 - 3
	 * 01 - 1
	 */
	public List<Integer> grayCode(int n) {
		if (n < 1) {
			List<Integer> result = new ArrayList<>();
			result.add(0);
			return result;
		}
		List<Integer> result = grayCode(n - 1);
		int size = result.size();
		int add = 1 << (n - 1);
		for (int i = size - 1; i >= 0; i--) {
			result.add(result.get(i) + add);
		}
		return result;
	}
}