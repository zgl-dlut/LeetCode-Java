package com.zgl.leetcode.java.dynamic;

import java.util.Arrays;

/**
 * @author zgl
 * @date 2019/4/20 下午2:19
 */
public class JumpGame {

	/**
	 * 55. Jump Game
	 *
	 * Given an array of non-negative integers, you are initially positioned at the first index of the array.
	 *
	 * Each element in the array represents your maximum jump length at that position.
	 *
	 * Determine if you are able to reach the last index.
	 *
	 * Example 1:
	 *
	 * Input: [2,3,1,1,4]
	 * Output: true
	 * Explanation: Jump 1 step from index 0 to 1, then 3 steps to the last index.
	 * Example 2:
	 *
	 * Input: [3,2,1,0,4]
	 * Output: false
	 * Explanation: You will always arrive at index 3 no matter what. Its maximum
	 *              jump length is 0, which makes it impossible to reach the last index.
	 */
	public boolean canJump(int[] nums) {
		int length = nums.length;
		/**
		 * dp[i]表示前面跳到第i位置时最远还可以多跳多少。
		 * 可以得到递推式：dp[i]=max( dp[i - 1], nums[i - 1] )
		 */
		int[] dp = new int[length];
		Arrays.fill(dp, 0);
		for (int i = 1; i < length; i++) {
			dp[i] = Math.max(dp[i - 1], nums[i - 1]) - 1;
			System.out.println("i =" + i + " " + dp[i]);
			if (dp[i] < 0) {
				return false;
			}
		}
		return dp[length - 1] >= 0;
	}

	public static void main(String[] args) {
		int[] nums = {2,1,0,0,0};
		boolean res = new JumpGame().canJump(nums);
		System.out.println(res);
	}
}