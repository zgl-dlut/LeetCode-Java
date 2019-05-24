package com.zgl.leetcode.java.dynamic;

/**
 * @author zgl
 * @date 2019/5/24 上午11:00
 */
public class HouseRobber {

	/**
	 * 198. House Robber
	 * You are a professional robber planning to rob houses along a street.
	 * Each house has a certain amount of money stashed, the only constraint stopping
	 * you from robbing each of them is that adjacent houses have security system
	 * connected and it will automatically contact the police if two adjacent houses were broken into on the same night.
	 *
	 * Given a list of non-negative integers representing the amount of money of each house,
	 * determine the maximum amount of money you can rob tonight without alerting the police.
	 *
	 * Example 1:
	 *
	 * Input: [1,2,3,1]
	 * Output: 4
	 * Explanation: Rob house 1 (money = 1) and then rob house 3 (money = 3).
	 *              Total amount you can rob = 1 + 3 = 4.
	 * Example 2:
	 *
	 * Input: [2,7,9,3,1]
	 * Output: 12
	 * Explanation: Rob house 1 (money = 2), rob house 3 (money = 9) and rob house 5 (money = 1).
	 *              Total amount you can rob = 2 + 9 + 1 = 12.
	 */
	public int rob(int[] nums) {
		int length = nums.length;
		if (length == 0) {
			return 0;
		}
		if (length == 1) {
			return nums[0];
		}
		/**
		 * dp[i] = max(dp[i-1], dp[i-2] + nums[i])
		 */
		int[] dp = new int[length];
		dp[0] = nums[0];
		dp[1] = Math.max(nums[0], nums[1]);
		int result = dp[1];
		for (int i = 2; i < length; i++) {
			dp[i] = Math.max(dp[i - 1], nums[i] + dp[i - 2]);
			result = Math.max(dp[i], result);
		}
		return result;
	}

	public static void main(String[] args) {
		int[] nums = {2,1,1,2};
		System.out.println(new HouseRobber().rob(nums));
	}
}