package com.zgl.leetcode.java.array;

/**
 * @author zgl
 * @date 2019/6/26 下午2:39
 */
public class PlusOne {

	/**
	 * 66. Plus One
	 * Example 1:
	 *
	 * Input: [1,2,3]
	 * Output: [1,2,4]
	 * Explanation: The array represents the integer 123.
	 * Example 2:
	 *
	 * Input: [4,3,2,1]
	 * Output: [4,3,2,2]
	 * Explanation: The array represents the integer 4321.
	 */
	public int[] plusOne(int[] digits) {
		int length = digits.length;
		for (int i = length - 1; i >= 0; i--) {
			if (digits[i] < 9) {
				digits[i]++;
				return digits;
			} else {
				digits[i] = 0;
			}
		}
		int[] newDigits = new int[length + 1];
		newDigits[0] = 1;
		return newDigits;
	}
}