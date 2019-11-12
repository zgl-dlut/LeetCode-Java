package com.zgl.leetcode.java.array;

/**
 * @author zgl
 * @date 2019/11/11 下午7:08
 */
public class TargetSum {

	/**
	 * 494. Target Sum
	 * You are given a list of non-negative integers, a1, a2, ..., an, and a target, S.
	 * Now you have 2 symbols + and -. For each integer, you should choose one from + and - as its new symbol.
	 *
	 * Find out how many ways to assign symbols to make sum of integers equal to target S.
	 *
	 * Example 1:
	 * Input: nums is [1, 1, 1, 1, 1], S is 3.
	 * Output: 5
	 * Explanation:
	 *
	 * -1+1+1+1+1 = 3
	 * +1-1+1+1+1 = 3
	 * +1+1-1+1+1 = 3
	 * +1+1+1-1+1 = 3
	 * +1+1+1+1-1 = 3
	 *
	 * There are 5 ways to assign symbols to make the sum of nums be target 3.
	 */
	public int result = 0;

	public static void main(String[] args) {
		int[] nums = {1,1,1,1,1};
		System.out.println(new TargetSum().findTargetSumWays(nums, 3));
	}

	public int findTargetSumWays1(int[] nums, int S) {
		if (nums == null || nums.length == 0) {
			return result;
		}
		dfs(nums, S, 0, 0);
		return result;
	}

	private void dfs(int[] nums, int target, int pos, int sum) {
		if (pos == nums.length) {
			if (target == sum) {
				result++;
			}
			return;
		}
		dfs(nums, target, pos + 1, sum - nums[pos]);
		dfs(nums, target, pos + 1, sum + nums[pos]);
	}

	/**
	 * 因此: sum(1,3,5) - sum(2,4) = target
	 * sum(1,3,5) - sum(2,4) + sum(1,3,5) + sum(2,4) = target + sum(1,3,5) + sum(2,4)
	 * 2sum(1,3,5) = target + sum(1,3,5) + sum(2,4)
	 * 2sum(P) = target + sum(nums)
	 * sum(P) = (target + sum(nums)) / 2
	 * 求出数组元素和等于(target + sum(nums)) / 2的次数
	 *
	 */
	public int findTargetSumWays(int[] nums, int S) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int sum = 0;
		for (int num : nums) {
			sum += num;
		}
		if (sum < S || (S + sum) % 2 != 0) {
			return 0;
		}
		sum = (S + sum) / 2;
		int[] dp = new int[sum + 1];
		dp[0] = 1;
		for (int num : nums) {
			for (int i = sum; i >= num; i--) {
				dp[i] += dp[i - num];
			}
		}
		return dp[sum];
	}
}