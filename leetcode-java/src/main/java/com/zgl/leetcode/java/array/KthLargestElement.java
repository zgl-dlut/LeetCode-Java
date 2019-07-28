package com.zgl.leetcode.java.array;

import java.util.*;

/**
 * @author zgl
 * @date 2019/5/20 下午3:07
 */
public class KthLargestElement {

	/**
	 * 215. Kth Largest Element in an Array
	 *
	 * Find the kth largest element in an unsorted array. Note that it is the kth largest element in the sorted order,
	 * not the kth distinct element.
	 *
	 * Example 1:
	 *
	 * Input: [3,2,1,5,6,4] and k = 2
	 * Output: 5
	 * Example 2:
	 *
	 * Input: [3,2,3,1,2,4,5,5,6] and k = 4
	 * Output: 4
	 * Note:
	 * You may assume k is always valid, 1 ≤ k ≤ array's length.
	 */
	public int findKthLargest1(int[] nums, int k) {
		Arrays.sort(nums);
		return nums[nums.length - k];
	}

	/*public int findKthLargest(int[] nums, int k) {
		return selectQuickSort(nums, 0, nums.length - 1, k);
	}

	private int selectQuickSort(int[] nums, int left, int right, int k) {
		int position = partition(nums, left, right);
		*//**
		 * 第k大数字的下标是nums.length - k
		 *//*
		if (position == nums.length - k) {
			return nums[position];
		} else if (position < nums.length - k) {
			return selectQuickSort(nums, position + 1, right, k);
		} else {
			return selectQuickSort(nums, left, position - 1, k);
		}
	}

	*/	public static void main(String[] args) {
		int[] nums = {7,6,5,4,3,2,1};
		System.out.println(new KthLargestElement().findKthLargest(nums, 2));
	}

/**
	 * 返回值左边比他小,右边比他大
	 *//*
	private int partition(int[] nums, int left, int right) {
		int pivot = nums[left];
		while (left < right) {
			while (nums[right] >= pivot && left < right) {
				right--;
			}
			nums[left] = nums[right];
			while (nums[left] <= pivot && left < right) {
				left++;
			}
			nums[right] = nums[left];
			nums[left] = pivot;
		}
		return left;
	}*/

	public int findKthLargest(int[] nums, int k) {
		return quickSort(nums, k, 0, nums.length - 1);
	}

	private int quickSort(int[] nums, int k, int left, int right) {
		int pos = partition(nums, left, right);
		if(pos == nums.length - k) {
			return nums[nums.length - k];
		}else if(pos < nums.length - k) {
			return quickSort(nums, k, pos + 1, right);
		}else {
			return quickSort(nums, k, left, pos - 1);
		}
	}

	private int partition(int[] nums, int left, int right) {
		int pivot = nums[left];
		while(left < right) {
			while(left < right && nums[right] >= nums[left]) {
				right--;
			}
			nums[left] = nums[right];
			while(left < right && nums[left] <= nums[right]) {
				left++;
			}
			nums[right] = nums[left];
		}
		nums[left] = pivot;
		return left;
	}
}