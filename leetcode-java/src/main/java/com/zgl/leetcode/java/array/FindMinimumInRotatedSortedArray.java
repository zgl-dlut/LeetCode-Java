package com.zgl.leetcode.java.array;

/**
 * @author zgl
 * @date 2020/1/9 下午3:54
 */
public class FindMinimumInRotatedSortedArray {
	public static void main(String[] args) {
		FindMinimumInRotatedSortedArray array = new FindMinimumInRotatedSortedArray();
		int[] nums = {4,5,6,7,0,1,2,2,2,2,2,2,2,2,2};
		System.out.println(array.findMin1(nums));
	}

	/**
	 * 153. Find Minimum in Rotated Sorted Array
	 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
	 *
	 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
	 *
	 * Find the minimum element.
	 *
	 * You may assume no duplicate exists in the array.
	 *
	 * Example 1:
	 *
	 * Input: [3,4,5,1,2]
	 * Output: 1
	 * Example 2:
	 *
	 * Input: [4,5,6,7,0,1,2]
	 * Output: 0
	 */
	public int findMin1(int[] nums) {
		int length = nums.length;
		int left = 0, right = length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			/**
			 * 折断点在左侧
			 */
			if (nums[mid] < nums[right]) {
				right = mid;
				/**
				 * 折断点在右侧
				 */
			} else if (nums[mid] > nums[right]) {
				left = mid + 1;
			} else {
				return nums[mid];
			}
		}
		return nums[left];
	}

	/**
	 * 154. Find Minimum in Rotated Sorted Array II
	 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
	 *
	 * (i.e.,  [0,1,2,4,5,6,7] might become  [4,5,6,7,0,1,2]).
	 *
	 * Find the minimum element.
	 *
	 * The array may contain duplicates.
	 *
	 * Example 1:
	 *
	 * Input: [1,3,5]
	 * Output: 1
	 * Example 2:
	 *
	 * Input: [2,2,2,0,1]
	 * Output: 0
	 */
	public int findMin(int[] nums) {
		int length = nums.length;
		int left = 0, right = length - 1;
		while (left <= right) {
			int mid = (left + right) / 2;
			if (nums[mid] < nums[right]) {
				right = mid;
			} else if (nums[mid] > nums[right]) {
				left = mid + 1;
			} else {
				right--;
			}
		}
		return nums[left];
	}
}