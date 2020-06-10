package com.zgl.leetcode.java.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zgl
 * @date 2019/5/6 下午5:26
 */
public class Combinations {

	/**
	 * 77. Combinations
	 * Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.
	 *
	 * Example:
	 *
	 * Input: n = 4, k = 2
	 * Output:
	 * [
	 *   [2,4],
	 *   [3,4],
	 *   [2,3],
	 *   [1,2],
	 *   [1,3],
	 *   [1,4],
	 * ]
	 */
	public List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> result = new ArrayList<>();
		List<Integer> answer = new ArrayList<>(k);
		helper(n, k, 1, answer, result);
		return result;
	}

	public static void main(String[] args) {
		System.out.println(new Combinations().combine(4, 2));
	}

	private void helper(int n, int k, int start, List<Integer> answer, List<List<Integer>> result) {
		if (answer.size() == k) {
			result.add(new ArrayList<>(answer));
			System.out.println(result);
			return;
		}
		for (int i = start; i <= n; i++) {
			answer.add(i);
			helper(n, k, i + 1, answer, result);
			answer.remove(answer.size() - 1);
		}
		/*if (k == 0) {
			result.add(new ArrayList<>(answer));
			System.out.println(result);
			return;
		}
		for (int i = start; i <= n; i++) {
			answer.add(i);
			helper(n, k - 1, i + 1, answer, result);
			System.out.println(answer);
			answer.remove(answer.size() - 1);
		}*/
	}
}