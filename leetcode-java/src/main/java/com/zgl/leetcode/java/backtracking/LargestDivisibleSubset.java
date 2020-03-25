package com.zgl.leetcode.java.backtracking;

import java.util.*;

/**
 * @author zgl
 * @date 2020/3/24 上午11:32
 */
public class LargestDivisibleSubset {
	/**
	 * 368. Largest Divisible Subset
	 * Given a set of distinct positive integers, find the largest subset such that every pair (Si, Sj) of elements in this subset satisfies:
	 *
	 * Si % Sj = 0 or Sj % Si = 0.
	 *
	 * If there are multiple solutions, return any subset is fine.
	 *
	 * Example 1:
	 *
	 * Input: [1,2,3]
	 * Output: [1,2] (of course, [1,3] will also be ok)
	 * Example 2:
	 *
	 * Input: [1,2,4,8]
	 * Output: [1,2,4,8]
	 */
	private int MAX = 1;
	private List<Integer> result = new ArrayList<>();

	public static void main(String[] args) {
		int[] nums = {3,4,16,8};
		System.out.println(new LargestDivisibleSubset().largestDivisibleSubset(nums));
	}

	//超时
	public List<Integer> largestDivisibleSubset1(int[] nums) {
		Arrays.sort(nums);
		boolean[] used = new boolean[nums.length];
		helper(nums, 0, new ArrayList<>(), used);
		return result;
	}

	private void helper(int[] nums, int start, List<Integer> temp, boolean[] used) {
		MAX = Math.max(MAX, temp.size());
		if (result.size() < MAX) {
			result = new ArrayList<>(temp);
		}
		for (int i = start; i < nums.length; i++) {
			if (!used[i]) {
				if (temp.isEmpty() || nums[i] % temp.get(temp.size() - 1) == 0) {
					temp.add(nums[i]);
					used[i] = true;
					helper(nums, i + 1, temp, used);
					used[i] = false;
					temp.remove(temp.size() - 1);
				}
			}
		}
	}

	public List<Integer> largestDivisibleSubset(int[] nums) {
		int[] dp = new int[nums.length];
		Map<Integer, Integer> map = new HashMap<>();
		int max = -1, idx = -1;
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < i; j++) {
				if (nums[i] % nums[j] == 0) {
					if (dp[i] < dp[j] + 1) {
						dp[i] = dp[j] + 1;
						map.put(i, j);
					}
				}
			}
			if (dp[i] > max) {
				max = dp[i];
				idx = i;
			}
		}
		List<Integer> result = new ArrayList<>();
		if (idx > -1) {
			result.add(nums[idx]);
		}
		while (map.containsKey(idx)) {
			idx = map.get(idx);
			result.add(nums[idx]);
		}
		return result;
	}
}