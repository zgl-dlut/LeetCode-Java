package com.zgl.leetcode.java.array;

import java.util.Arrays;

/**
 * @author zgl
 * @date 2019/11/7 下午3:39
 */
public class PartitionEqualSubsetSum {
	public static void main(String[] args) {
		int[] nums = {1,5,11,5};
		new PartitionEqualSubsetSum().canPartition(nums);
	}

	/**
	 * 416. Partition Equal Subset Sum
	 * Given a non-empty array containing only positive integers,
	 * find if the array can be partitioned into two subsets such that the sum of elements in both subsets is equal.
	 *
	 * Note:
	 *
	 * Each of the array element will not exceed 100.
	 * The array size will not exceed 200.
	 *
	 *
	 * Example 1:
	 *
	 * Input: [1, 5, 11, 5]
	 *
	 * Output: true
	 *
	 * Explanation: The array can be partitioned as [1, 5, 5] and [11].
	 *
	 *
	 * Example 2:
	 *
	 * Input: [1, 2, 3, 5]
	 *
	 * Output: false
	 *
	 * Explanation: The array cannot be partitioned into equal sum subsets.
	 */
	public boolean canPartition1(int[] nums) {
		if (nums.length == 0) {
			return false;
		}
		Arrays.sort(nums);
		int half = 0;
		for (int num : nums) {
			half += num;
		}
		if (half % 2 != 0) {
			return false;
		}
		half /= 2;
		boolean[] dp = new boolean[half + 1];
		dp[0] = true;
		for (int i = 1; i < nums.length; i++) {
			for (int j = half; j - nums[i - 1] >= 0; j--) {
				dp[j] = dp[j] || dp[j - nums[i - 1]];
			}
		}
		return dp[half];
	}

	public boolean canPartition(int[] nums) {
		if (nums.length == 0) {
			return false;
		}
		int half = 0;
		for (int num : nums) {
			half += num;
		}
		if (half % 2 != 0) {
			return false;
		}
		half /= 2;
		return dfs(nums, half, 0);
	}

	public boolean dfs(int[] nums, int sum, int index) {
		if (sum == 0) {
			return true;
		}
		if (index >= nums.length || sum < 0) {
			return false;
		}
		if (dfs(nums, sum - nums[index], index + 1)) {
			return true;
		}
		int start = index + 1;
		while (start < nums.length && nums[start] == nums[index]) {
			start++;
		}
		return dfs(nums, sum, start);
	}
}