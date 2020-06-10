package com.zgl.leetcode.java.array;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zgl
 * @date 2019/11/11 上午11:27
 */
public class FindDisappearedNumbers {
	public static void main(String[] args) {
		int[] nums = {4,3,2,7,8,2,3,1};
		System.out.println(new FindDisappearedNumbers().findDisappearedNumbers(nums));
	}

	/**
	 * 448. Find All Numbers Disappeared in an Array
	 * Given an array of integers where 1 ≤ a[i] ≤ n (n = size of array), some elements appear twice and others appear once.
	 *
	 * Find all the elements of [1, n] inclusive that do not appear in this array.
	 *
	 * Could you do it without extra space and in O(n) runtime? You may assume the returned list does not count as extra space.
	 *
	 * Example:
	 *
	 * Input:
	 * [4,3,2,7,8,2,3,1]
	 *
	 * Output:
	 * [5,6]
	 */
	public List<Integer> findDisappearedNumbers1(int[] nums) {
		int[] temp = new int[nums.length + 1];
		for (int i = 1; i <= nums.length; i++) {
			temp[nums[i - 1]] = nums[i - 1];
		}
		List<Integer> result = new ArrayList<>();
		for (int i = 1; i <= nums.length; i++) {
			if (temp[i] == 0) {
				result.add(i);
			}
		}
		return result;
	}

	public List<Integer> findDisappearedNumbers(int[] nums) {
		for (int i = 0; i < nums.length; i++) {
			while (nums[nums[i] - 1] != nums[i]) {
				int temp = nums[nums[i] - 1];
				nums[nums[i] - 1] = nums[i];
				nums[i] = temp;
			}
		}
		List<Integer> result = new ArrayList<>();
		for (int i = 0; i < nums.length; i++) {
			if (nums[i] != i + 1) {
				result.add(i + 1);
			}
		}
		return result;
	}
}