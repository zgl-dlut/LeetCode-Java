package com.zgl.leetcode.java.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zgl
 * @date 2019/4/2 下午1:58
 */
public class CombinationSum {

	/**
	 * 39. Combination Sum
	 * Given a set of candidate numbers (candidates) (without duplicates) and a target number (target),
	 * find all unique combinations in candidates where the candidate numbers sums to target.
	 * <p>
	 * The same repeated number may be chosen from candidates unlimited number of times.
	 * <p>
	 * Note:
	 * <p>
	 * All numbers (including target) will be positive integers.
	 * The solution set must not contain duplicate combinations.
	 * Example 1:
	 * <p>
	 * Input: candidates = [2,3,6,7], target = 7,
	 * A solution set is:
	 * [
	 * [7],
	 * [2,2,3]
	 * ]
	 * Example 2:
	 * <p>
	 * Input: candidates = [2,3,5], target = 8,
	 * A solution set is:
	 * [
	 * [2,2,2,2],
	 * [2,3,3],
	 * [3,5]
	 * ]
	 */
	public List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> answer = new ArrayList<>(candidates.length);
		Arrays.sort(candidates);
		helper(candidates, 0, target, result, answer);
		return result;
	}

	private void helper(int[] candidates, int pos, int remain, List<List<Integer>> result, List<Integer> answer) {
		if (remain < 0) {
			return;
		} else if (remain == 0) {
			result.add(new ArrayList<>(answer));
		} else {
			for (int i = pos; i < candidates.length; i++) {
				answer.add(candidates[i]);
				helper(candidates, i, remain - candidates[i], result, answer);
				answer.remove(answer.size() - 1);
			}
		}
	}

	private void helper2(int[] candidates, int pos, int remain, List<List<Integer>> result, List<Integer> answer) {
		if (remain < 0) {
			return;
		} else if (remain == 0) {
			result.add(new ArrayList<>(answer));
		} else {
			for (int i = pos; i < candidates.length; i++) {
				if (i > pos && candidates[i] == candidates[i - 1]) {
					continue;
				}
				answer.add(candidates[i]);
				helper2(candidates, i + 1, remain - candidates[i], result, answer);
				answer.remove(answer.size() - 1);
			}
		}
	}

	private void helper3(int[] candidates, int pos, int remain, int num, List<List<Integer>> result, List<Integer> answer) {
		if (remain > 0 && num > 0) {
			for (int i = pos; i < 9; i++) {
				answer.add(candidates[i]);
				helper3(candidates, i + 1, remain - candidates[i], num - 1, result, answer);
				answer.remove(answer.size() - 1);
			}
		} else if (remain == 0 && num == 0) {
			result.add(new ArrayList<>(answer));
		} else {
			return;
		}
	}
	/**
	 * 40. Combination Sum II
	 * Given a collection of candidate numbers (candidates) and a target number (target),
	 * find all unique combinations in candidates where the candidate numbers sums to target.
	 * <p>
	 * Each number in candidates may only be used once in the combination.
	 * <p>
	 * Note:
	 * <p>
	 * All numbers (including target) will be positive integers.
	 * The solution set must not contain duplicate combinations.
	 * Example 1:
	 * <p>
	 * Input: candidates = [10,1,2,7,6,1,5], target = 8,
	 * A solution set is:
	 * [
	 * [1, 7],
	 * [1, 2, 5],
	 * [2, 6],
	 * [1, 1, 6]
	 * ]
	 * Example 2:
	 * <p>
	 * Input: candidates = [2,5,2,1,2], target = 5,
	 * A solution set is:
	 * [
	 * [1,2,2],
	 * [5]
	 * ]
	 */
	public List<List<Integer>> combinationSum2(int[] candidates, int target) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> answer = new ArrayList<>(candidates.length);
		Arrays.sort(candidates);
		helper2(candidates, 0, target, result, answer);
		return result;
	}

	/**
	 * 216. Combination Sum III
	 * Find all possible combinations of k numbers that add up to a number n,
	 * given that only numbers from 1 to 9 can be used and each combination should be a unique set of numbers.
	 *
	 * Note:
	 *
	 * All numbers will be positive integers.
	 * The solution set must not contain duplicate combinations.
	 * Example 1:
	 *
	 * Input: k = 3, n = 7
	 * Output: [[1,2,4]]
	 * Example 2:
	 *
	 * Input: k = 3, n = 9
	 * Output: [[1,2,6], [1,3,5], [2,3,4]]
	 */
	public List<List<Integer>> combinationSum3(int k, int n) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> answer = new ArrayList<>(9);
		int[] candidates = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		helper3(candidates, 0, n, k, result, answer);
		return result;
	}



	public static void main(String[] args) {
		int[] candidates = {2,5,2,1,2};
		System.out.println(new CombinationSum().combinationSum3(3, 9));
	}
}
