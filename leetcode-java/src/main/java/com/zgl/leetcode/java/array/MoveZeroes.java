package com.zgl.leetcode.java.array;

/**
 * @author zgl
 * @date 2019/11/3 下午6:05
 */
public class MoveZeroes {
	public static void main(String[] args) {
		int[] nums = {0,1,0,3,12};
		new MoveZeroes().moveZeroes(nums);
		for (int i : nums) {
			System.out.print(i + "");
		}
	}

	/**
	 * 283. Move Zeroes
	 * Given an array nums, write a function to move all 0's to the end of it
	 * while maintaining the relative order of the non-zero elements.
	 *
	 * Example:
	 *
	 * Input: [0,1,0,3,12]
	 * Output: [1,3,12,0,0]
	 * Note:
	 *
	 * You must do this in-place without making a copy of the array.
	 * Minimize the total number of operations.
	 */
	public void moveZeroes(int[] nums) {
		int n = nums.length;
		if (n == 0) {
			return;
		}
		int count = 0;
		for (int i = 0; i < n; i++) {
			if (nums[i] == 0) {
				count++;
			} else {
				nums[i - count] = nums[i];
			}
		}
		for (int i = n - count; i < n; i++) {
			nums[i] = 0;
		}
	}

	public void moveZeroes1(int[] nums) {
		int n = nums.length;
		if (n == 0) {
			return;
		}
		int index = 0;
		for (int i = 0; i < n; i++) {
			if (nums[i] != 0) {
				swap(nums, index, i);
				index++;
			}
		}
	}

	private void swap(int[] nums, int from, int to) {
		if (from == to) {
			return;
		}
		int temp = nums[from];
		nums[from] = nums[to];
		nums[to] = temp;
	}
}