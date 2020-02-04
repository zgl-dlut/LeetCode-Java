package com.zgl.leetcode.java.array;

/**
 * @author zgl
 * @date 2020/2/3 下午4:10
 */
public class MinimumSizeSubarraySum {

	public static void main(String[] args) {
		int[] nums = {2,3,1,2,4,3};
		System.out.println(new MinimumSizeSubarraySum().minSubArrayLen(7, nums));
	}

	/**
	 * 209. Minimum Size Subarray Sum
	 * Given an array of n positive integers and a positive integer s,
	 * find the minimal length of a contiguous subarray of which the sum ≥ s. If there isn't one, return 0 instead.
	 *
	 * Example:
	 *
	 * Input: s = 7, nums = [2,3,1,2,4,3]
	 * Output: 2
	 * Explanation: the subarray [4,3] has the minimal length under the problem constraint.
	 * Follow up:
	 * If you have figured out the O(n) solution, try coding another solution of which the time complexity is O(n log n).
	 */
	public int minSubArrayLen(int s, int[] nums) {
		int n = nums.length;
		if (n == 0) {
			return 0;
		}
		//定义滑动窗口
		int left = 0, right = -1, result = n + 1, sum = 0;
		while (left < n) {
			if (sum < s && right + 1 < n) {
				sum += nums[++right];
			} else {
				sum -= nums[left++];
			}
			if (sum >= s) {
				result = Math.min(result, right - left + 1);
			}
		}
		return result == n + 1 ? 0 : result;
	}
}