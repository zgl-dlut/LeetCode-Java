package com.zgl.leetcode.java.dynamic;

/**
 * @author zgl
 * @date 2019/5/18 下午5:04
 */
public class MaximumProductSubarray {

	/**
	 * 152. Maximum Product Subarray
	 * Given an integer array nums, find the contiguous subarray within an array
	 * (containing at least one number) which has the largest product.
	 *
	 * Example 1:
	 *
	 * Input: [2,3,-2,4]
	 * Output: 6
	 * Explanation: [2,3] has the largest product 6.
	 * Example 2:
	 *
	 * Input: [-2,0,-1]
	 * Output: 0
	 * Explanation: The result cannot be 2, because [-2,-1] is not a subarray.
	 */
	public int maxProduct(int[] nums) {
		int[] dpMax = new int[nums.length];
		int[] dpMin = new int[nums.length];
		dpMax[0] = dpMin[0] = nums[0];
		int result = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int min = dpMin[i - 1] * nums[i];
			int max = dpMax[i - 1] * nums[i];
			dpMin[i] = Math.min(Math.min(max, min), nums[i]);
			dpMax[i] = Math.max(Math.max(max, min), nums[i]);
			result = Math.max(dpMax[i], result);
		}
		return result;
	}

	public int maxProduct1(int[] nums) {
		int dpMin = nums[0], dpMax = nums[0], result = nums[0];
		for (int i = 1; i < nums.length; i++) {
			int min = dpMin * nums[i];
			int max = dpMax * nums[i];
			dpMin = Math.min(Math.min(min, max), nums[i]);
			dpMax = Math.max(Math.max(min, max), nums[i]);
			result = Math.max(result, dpMax);
		}
		return result;
	}
	public static void main(String[] args) {
		int[] nums = {0,2};
		System.out.println(new MaximumProductSubarray().maxProduct(nums));
 	}
}