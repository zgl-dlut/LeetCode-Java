package com.zgl.leetcode.java.array;

/**
 * @author zgl
 * @date 2019/11/5 下午7:50
 */
public class CountingBits {
	/**
	 * 338. Counting Bits
	 * Given a non negative integer number num.
	 * For every numbers i in the range 0 ≤ i ≤ num calculate the number of 1's in their binary representation and return them as an array.
	 *
	 * Example 1:
	 *
	 * Input: 2
	 * Output: [0,1,1]
	 * Example 2:
	 *
	 * Input: 5
	 * Output: [0,1,1,2,1,2]
	 * Follow up:
	 *
	 * It is very easy to come up with a solution with run time O(n*sizeof(integer)).
	 * But can you do it in linear time O(n) /possibly in a single pass?
	 * Space complexity should be O(n).
	 * Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
	 */
	public int[] countBits(int num) {
		int[] result = new int[num + 1];
		for (int i = 1; i <= num; i++) {
			result[i] = calculate(i);
		}
		return result;
	}

	private int calculate(int num) {
		int count = 0;
		while (num != 0) {
			count++;
			num &= num - 1;
		}
		return count;
	}

	public int[] countBits1(int num) {
		int[] result = new int[num + 1];
		int base = 1;
		for (int i = 1; i <= num; i++) {
			if (base * 2 == i) {
				base *= 2;
			}
			result[i] = result[i - base] + 1;
		}
		return result;
	}
}