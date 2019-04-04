package com.zgl.leetcode.java.array;

import java.util.Arrays;

/**
 * @author zgl
 * @date 2019/4/3 下午4:17
 */
public class FirstMissingPositive {

	/**
	 * 41. First Missing Positive
	 * Given an unsorted integer array, find the smallest missing positive integer.
	 *
	 * Example 1:
	 *
	 * Input: [1,2,0]
	 * Output: 3
	 * Example 2:
	 *
	 * Input: [3,4,-1,1]
	 * Output: 2
	 * Example 3:
	 *
	 * Input: [7,8,9,11,12]
	 * Output: 1
	 * Note:
	 *
	 * Your algorithm should run in O(n) time and uses constant extra space.
	 */
	public int firstMissingPositive(int[] nums) {
		int length = nums.length;
		if (length == 0) {
			return 1;
		}
		for (int i = 0; i < length; i++) {
			if (nums[i] > 0) {
				while (nums[i] > 0 && nums[i] <= length && nums[i] != nums[nums[i] - 1]) {
					int temp = nums[nums[i] - 1];
					nums[nums[i] - 1] = nums[i];
					nums[i] = temp;
				}
			}
		}
		for (int i = 0; i < length; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}
		return length + 1;
	}



	public static void main(String[] args) {
		int[] nums = {3,4,-1,1};
		int result = new FirstMissingPositive().firstMissingPositive(nums);
		System.out.println(result);
	}
}