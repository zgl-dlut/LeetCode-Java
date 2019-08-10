package com.zgl.leetcode.java.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zgl
 * @date 2019/5/7 上午11:07
 */
public class Subsets {

	/**
	 * 78. Subsets
	 * Given a set of distinct integers, nums,
	 * return all possible subsets (the power set).
	 *
	 * Note: The solution set must not contain duplicate subsets.
	 *
	 * Example:
	 *
	 * Input: nums = [1,2,3]
	 * Output:
	 * [
	 *   [3],
	 *   [1],
	 *   [2],
	 *   [1,2,3],
	 *   [1,3],
	 *   [2,3],
	 *   [1,2],
	 *   []
	 * ]
	 */
	public List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> answer = new ArrayList<>();
		backtracking(nums, 0, answer, result);
		return result;
	}

	public static void main(String[] args) {
		int[] nums = {1,2,3};
		new Subsets().subsets(nums);
	}
	/**
	 * 90. Subsets II
	 * Given a collection of integers that might contain duplicates, nums,
	 * return all possible subsets (the power set).
	 *
	 * Note: The solution set must not contain duplicate subsets.
	 *
	 * Example:
	 *
	 * Input: [1,2,2]
	 * Output:
	 * [
	 *   [2],
	 *   [1],
	 *   [1,2,2],
	 *   [2,2],
	 *   [1,2],
	 *   []
	 * ]
	 */
	public List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> answer = new ArrayList<>();
		Arrays.sort(nums);
		helper(nums, answer, result, 0);
		return result;
	}

	private void helper(int[] nums, List<Integer> answer, List<List<Integer>> result, int start) {
		result.add(new ArrayList<>(answer));
		for (int i = start; i < nums.length; i++) {
			if (i > start && nums[i] == nums[i - 1]) {
				continue;
			}
			answer.add(nums[i]);
			helper(nums, answer, result, i + 1);
			answer.remove(answer.size() - 1);
		}
	}

	private void backtracking(int[] nums, int start, List<Integer> answer, List<List<Integer>> result) {
		result.add(new ArrayList<>(answer));
		System.out.println(answer);
		for (int i = start; i < nums.length; i++) {
			answer.add(nums[i]);
			backtracking(nums, i + 1, answer, result);
			answer.remove(answer.size() - 1);
			System.out.println(answer);
		}
	}
}