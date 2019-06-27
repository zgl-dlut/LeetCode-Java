package com.zgl.leetcode.java.array;

/**
 * @author zgl
 * @date 2019/6/18 下午4:01
 */
public class RemoveDuplicates {

	public static void main(String[] args) {
		int[] nums = {0,0,1,1,1,2,2,3,3,4};
		System.out.println(new RemoveDuplicates().removeDuplicates(nums));
	}

	/**
	 * 26. Remove Duplicates from Sorted Array
	 * Given a sorted array nums, remove the duplicates in-place such that each element appear only once and return the new length.
	 *
	 * Do not allocate extra space for another array, you must do this by modifying the input array in-place with O(1) extra memory.
	 *
	 * Example 1:
	 *
	 * Given nums = [1,1,2],
	 *
	 * Your function should return length = 2, with the first two elements of nums being 1 and 2 respectively.
	 *
	 * It doesn't matter what you leave beyond the returned length.
	 * Example 2:
	 *
	 * Given nums = [0,0,1,1,1,2,2,3,3,4],
	 *
	 * Your function should return length = 5, with the first five elements of nums being modified to 0, 1, 2, 3, and 4 respectively.
	 *
	 * It doesn't matter what values are set beyond the returned length.
	 */
	public int removeDuplicates1(int[] nums) {
		if (nums == null || nums.length == 0) {
			return 0;
		}
		int index = 0;
		for (int i = 1; i < nums.length; i++) {
			if (nums[i] != nums[index]) {
				nums[++index] = nums[i];
			}
		}
		return index + 1;
	}

	/**
	 * 80. Remove Duplicates from Sorted Array II
	 * Example 1:
	 *
	 * Given nums = [1,1,1,2,2,3],
	 *
	 * Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3 respectively.
	 *
	 * It doesn't matter what you leave beyond the returned length.
	 * Example 2:
	 *
	 * Given nums = [0,0,1,1,1,1,2,3,3],
	 *
	 * Your function should return length = 7, with the first seven elements of nums being modified to 0, 0, 1, 1, 2, 3 and 3 respectively.
	 *
	 * It doesn't matter what values are set beyond the returned length.
	 */
	public int removeDuplicates(int[] nums) {
		int length = nums.length;
		if (length <= 2) {
			return length;
		}
		int count = 1, index = 0;
		for (int i = 1; i < length; i++) {
			if (nums[i] != nums[i - 1]) {
				count = 1;
				nums[++index] = nums[i];
			} else {
				if (count < 2) {
					nums[++index] = nums[i];
					count++;
				}
			}
		}
		return index + 1;
	}
}