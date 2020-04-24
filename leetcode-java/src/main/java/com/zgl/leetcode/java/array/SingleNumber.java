package com.zgl.leetcode.java.array;

import java.util.Arrays;

/**
 * @author zgl
 * @date 2019/5/16 下午2:13
 */
public class SingleNumber {

	/**
	 * 136. Single Number
	 * Given a non-empty array of integers, every element appears twice except for one. Find that single one.
	 *
	 * Note:
	 *
	 * Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?
	 *
	 * Example 1:
	 *
	 * Input: [2,2,1]
	 * Output: 1
	 * Example 2:
	 *
	 * Input: [4,1,2,1,2]
	 * Output: 4
	 */
	public int singleNumber(int[] nums) {
		//异或: a ^ b = b ^ a, 0 ^ a = a, a ^ a = 0
		int result = 0;
		for (int i = 0; i < nums.length; i++){
			result = result ^ nums[i];
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = {4,1,2,1,2};
		System.out.println(new SingleNumber().singleNumber(nums));
	}
}