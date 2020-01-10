package com.zgl.leetcode.java.array;

/**
 * @author zgl
 * @date 2020/1/10 上午10:21
 */
public class PeakElement {
	public static void main(String[] args) {
		PeakElement peakElement = new PeakElement();
		int[] nums = {1,2,3,4,5};
		System.out.println(peakElement.findPeakElement(nums));
	}

	/**
	 * 162. Find Peak Element
	 * A peak element is an element that is greater than its neighbors.
	 *
	 * Given an input array nums, where nums[i] ≠ nums[i+1], find a peak element and return its index.
	 *
	 * The array may contain multiple peaks, in that case return the index to any one of the peaks is fine.
	 *
	 * You may imagine that nums[-1] = nums[n] = -∞.
	 *
	 * Example 1:
	 *
	 * Input: nums = [1,2,3,1]
	 * Output: 2
	 * Explanation: 3 is a peak element and your function should return the index number 2.
	 * Example 2:
	 *
	 * Input: nums = [1,2,1,3,5,6,4]
	 * Output: 1 or 5
	 * Explanation: Your function can return either index number 1 where the peak element is 2,
	 *              or index number 5 where the peak element is 6.
	 */
	public int findPeakElement(int[] nums) {
		int n = nums.length;
		if (n == 1) {
			return 0;
		}
		if (nums[0] > nums[1]) {
			return 0;
		}
		for (int i = 1; i < n; i++) {
			if (nums[i] > nums[i - 1] && (i + 1 == n || nums[i] > nums[i + 1])) {
				return i;
			}
		}
		return -1;
	}
}