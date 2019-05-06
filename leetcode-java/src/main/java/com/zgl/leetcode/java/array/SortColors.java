package com.zgl.leetcode.java.array;

/**
 * @author zgl
 * @date 2019/5/6 下午4:43
 */
public class SortColors {

	/**
	 * 75. Sort Colors
	 * Given an array with n objects colored red, white or blue,
	 * sort them in-place so that objects of the same color are adjacent,
	 * with the colors in the order red, white and blue.
	 * <p>
	 * Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.
	 * <p>
	 * Note: You are not suppose to use the library's sort function for this problem.
	 * <p>
	 * Example:
	 * <p>
	 * Input: [2,0,2,1,1,0]
	 * Output: [0,0,1,1,2,2]
	 * Follow up:
	 * <p>
	 * A rather straight forward solution is a two-pass algorithm using counting sort.
	 * First, iterate the array counting number of 0's, 1's, and 2's,
	 * then overwrite array with total number of 0's, then 1's and followed by 2's.
	 * Could you come up with a one-pass algorithm using only constant space?
	 */
	public void sortColors(int[] nums) {
		int left = 0;
		int right = nums.length - 1;
		int tag = 0;
		while (tag <= right) {
			if (nums[tag] == 0) {
				swap(nums, tag, left);
				left++;
				tag++;
			} else if (nums[tag] == 1) {
				tag++;
			} else {
				swap(nums, tag, right);
				right--;
			}
		}
	}

	private void swap(int[] nums, int a, int b) {
		int temp;
		temp = nums[a];
		nums[a] = nums[b];
		nums[b] = temp;
	}
}