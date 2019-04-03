package com.zgl.leetcode.java.array;

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

	private void helper1(int[] candidates, int pos, int remain, List<List<Integer>> result, List<Integer> answer) {
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
				helper1(candidates, i + 1, remain - candidates[i], result, answer);
				answer.remove(answer.size() - 1);
			}
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
		helper1(candidates, 0, target, result, answer);
		return result;
	}



	public static void main(String[] args) {
		int[] candidates = {2,5,2,1,2};
		System.out.println(new CombinationSum().combinationSum2(candidates, 7));
	}
}
