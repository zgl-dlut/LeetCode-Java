package com.zgl.leetcode.java.array;

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

	public static void main(String[] args) {
		int[] nums={1,2,3};
		new Permutation().permute(nums);
		List<Integer>temp=Arrays.asList(1,2,3);
		List<Integer>list= new ArrayList<>(temp);
		list.add(0,9);
		System.out.println(list);
	}
}