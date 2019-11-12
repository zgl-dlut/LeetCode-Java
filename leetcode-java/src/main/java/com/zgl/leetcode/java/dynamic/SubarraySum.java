package com.zgl.leetcode.java.dynamic;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zgl
 * @date 2019/11/11 下午9:10
 */
public class SubarraySum {

	public static void main(String[] args) {
		int[] nums = {1,1,1};
		System.out.println(new SubarraySum().subarraySum(nums,2));
	}

	/**
	 * 560. Subarray Sum Equals K
	 * Given an array of integers and an integer k, you need to find the total number of continuous subarrays whose sum equals to k.
	 *
	 * Example 1:
	 * Input:nums = [1,1,1], k = 2
	 * Output: 2
	 * Note:
	 * The length of the array is in range [1, 20,000].
	 * The range of numbers in the array is [-1000, 1000] and the range of the integer k is [-1e7, 1e7].
	 */
	public int subarraySum1(int[] nums, int k) {
		int n = nums.length;
		if (n == 0) {
			return 0;
		}
		int[] sum = new int[n + 1];
		for (int i = 1; i <= n; i++) {
			sum[i] = sum[i - 1] + nums[i - 1];
		}
		int result = 0;
		for (int i = 1; i <= n; i++) {
			if (sum[i] == k) {
				result++;
			}
			for (int j = i - 1; j > 0; j--) {
				if (sum[i] - sum[j] == k) {
					result++;
				}
			}
		}
		return result;
	}

	public int subarraySum(int[] nums, int k) {
		int n = nums.length;
		if (n == 0) {
			return 0;
		}
		int sum = 0, result = 0;
		Map<Integer, Integer> sumMap = new HashMap<>();
		sumMap.put(0, 1);
		for (int i = 0; i < n; i++) {
			sum += nums[i];
			if (sumMap.containsKey(sum - k)) {
				result += sumMap.get(sum - k);
			}
			sumMap.put(sum, sumMap.getOrDefault(sum, 0) + 1);
		}
		return result;
	}
}