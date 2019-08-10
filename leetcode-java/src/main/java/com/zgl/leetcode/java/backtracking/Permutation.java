package com.zgl.leetcode.java.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author zgl
 * @date 2019/4/4 下午4:32
 */
public class Permutation {

	/**
	 * 46. Permutations
	 * Given a collection of distinct integers, return all possible permutations.
	 * <p>
	 * Example:
	 * <p>
	 * Input: [1,2,3]
	 * Output:
	 * [
	 * [1,2,3],
	 * [1,3,2],
	 * [2,1,3],
	 * [2,3,1],
	 * [3,1,2],
	 * [3,2,1]
	 * ]
	 */
	public List<List<Integer>> permute1(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		dfs(res, nums, 0);
		return res;
	}

	private void dfs(List<List<Integer>> res, int[] nums, int cur) {
		if (cur == nums.length) {
			List<Integer> temp = new ArrayList<>();
			for (Integer item : nums) {
				temp.add(item);
			}
			res.add(temp);
		} else {
			for (int i = cur; i < nums.length; i++) {
				swap(nums, cur, i);
				dfs(res, nums, cur + 1);
				swap(nums, cur, i);
			}
		}
	}

	private void swap(int[] arr, int a, int b) {
		int temp = arr[a];
		arr[a] = arr[b];
		arr[b] = temp;
	}

	public List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		List<List<Integer>> newResult;
		List<Integer> item;
		result.add(Collections.singletonList(nums[0]));
		for (int i = 1; i < nums.length; i++) {
			newResult = new ArrayList<>();
			for (List<Integer> temp : result) {
				int size = temp.size() + 1;
				for (int j = 0; j < size; j++) {
					item = new ArrayList<>(temp);
					item.add(j, nums[i]);
					newResult.add(item);
				}
			}
			result = newResult;
		}
		return result;
	}

	public List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> list = new ArrayList<>();
		/**
		 * 初始化均为false
		 */
		boolean[] used = new boolean[nums.length];
		Arrays.sort(nums);
		dfs(nums, used, list, res);
		return res;
	}

	/*
		private void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res) {
			if (list.size() == nums.length) {
				res.add(new ArrayList<>(list));
				return;
			}
			for (int i = 0; i < nums.length; i++) {
				if (!used[i]) {
					used[i] = true;
					list.add(nums[i]);
					dfs(nums, used, list, res);
					used[i] = false;
					list.remove(list.size() - 1);
				}
			}
		}
	*/
	private void dfs(int[] nums, boolean[] used, List<Integer> list, List<List<Integer>> res) {
		if (list.size() == nums.length) {
			res.add(new ArrayList<>(list));
			System.out.println(res);
			return;
		}
		for (int i = 0; i < nums.length; i++) {
			if (used[i]) {
				continue;
			}
			if (i > 0 && nums[i] == nums[i - 1] && !used[i - 1]) {
				continue;
			}
			used[i] = true;
			list.add(nums[i]);
			dfs(nums, used, list, res);
			used[i] = false;
			list.remove(list.size() - 1);
		}
	}

	public static void main(String[] args) {
		int[] nums = {1, 2, 3};
		/*new Permutation().permuteUnique(nums);
		List<Integer> temp = Arrays.asList(1, 2, 3);
		List<Integer> list = new ArrayList<>(temp);
		list.add(0, 9);
		System.out.println(list);*/
		new Permutation().permute3(nums);
	}

	public List<List<Integer>> permute3(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		boolean[] used = new boolean[nums.length];
		backtracking(nums, used, new ArrayList<>(), result);
		return result;
	}

	private void backtracking(int[] nums, boolean[] used, List<Integer> answer, List<List<Integer>> result) {
		if(answer.size() == nums.length) {
			result.add(new ArrayList<>(answer));
		}
		for(int i = 0; i < nums.length; i++) {
			if(!used[i]) {
				used[i] = true;
				answer.add(nums[i]);
				System.out.println(answer);
				backtracking(nums, used, answer, result);
				used[i] = false;
				answer.remove(answer.size() - 1);
				System.out.println(answer);
			}
		}
	}
}