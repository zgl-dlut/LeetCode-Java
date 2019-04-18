package com.zgl.leetcode.java.dynamic;

/**
 * 最大子序列和
 *
 * @author zgl
 * @date 2019/4/18 下午10:50
 */
public class MaximumSubarray {
	/**
	 * 53. Maximum Subarray
	 * Given an integer array nums, find the contiguous subarray
	 * (containing at least one number) which has the largest sum and return its sum.
	 *
	 * Example:
	 *
	 * Input: [-2,1,-3,4,-1,2,1,-5,4],
	 * Output: 6
	 * Explanation: [4,-1,2,1] has the largest sum = 6.
	 * Follow up:
	 *
	 * If you have figured out the O(n) solution,
	 * try coding another solution using the divide and conquer approach, which is more subtle.
	 */
	public int maxSubArray(int[] nums) {
		int max = nums[0];
		/**
		 * dp表示便利到i的最大子序列和
		 */
		int dp = nums[0];
		for (int i = 1; i < nums.length; i++) {
			dp = nums[i] + Math.max(dp, 0);
			max = Math.max(dp, max);
		}
		return max;
	}
}