package com.zgl.leetcode.java.array;

/**
 * @author zgl
 * @date 2019/5/22 上午10:25
 */
public class FindDuplicateNumber {

	/**
	 * 287. Find the Duplicate Number
	 * Given an array nums containing n + 1 integers where each integer is between 1 and n (inclusive),
	 * prove that at least one duplicate number must exist.
	 * Assume that there is only one duplicate number, find the duplicate one.
	 *
	 * Example 1:
	 *
	 * Input: [1,3,4,2,2]
	 * Output: 2
	 * Example 2:
	 *
	 * Input: [3,1,3,4,2]
	 * Output: 3
	 * Note:
	 *
	 * You must not modify the array (assume the array is read only).
	 * You must use only constant, O(1) extra space.
	 * Your runtime complexity should be less than O(n2).
	 * There is only one duplicate number in the array, but it could be repeated more than once.
	 */
	//遍历数组，若数组中小于等于n / 2的数字个数超过n / 2，则可以确定[1, n /2]范围内一定有解，
	//否则可以确定解落在(n / 2, n]范围内。
	public int findDuplicate(int[] nums) {
		int n = nums.length;
		int left = 1, right = n - 1, count;
		while (left <= right) {
			int mid = left + (right - left) / 2;
			count = 0;
			for (int num : nums) {
				if (num <= mid) {
					count++;
				}
			}
			if (count > mid) {
				right = mid - 1;
			} else {
				left = mid + 1;
			}
		}
		return left;
	}

	public static void main(String[] args) {
		int[] nums = {1,3,4,2,2};
		System.out.println(new FindDuplicateNumber().findDuplicate(nums));
	}
}