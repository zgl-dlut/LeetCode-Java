package com.zgl.leetcode.java.array;

/**
 * @author zgl
 * @date 2019/11/12 下午2:20
 */
public class FindUnsortedSubarray {

	public static void main(String[] args) {
		int[] nums = {2,6,4,8,10,9,15};
		System.out.println(new FindUnsortedSubarray().findUnsortedSubarray(nums));
	}

	/**
	 * 581. Shortest Unsorted Continuous Subarray
	 *
	 * Given an integer array, you need to find one continuous subarray that if you only sort this subarray in ascending order,
	 * then the whole array will be sorted in ascending order, too.
	 *
	 * You need to find the shortest such subarray and output its length.
	 *
	 * Example 1:
	 * Input: [2, 6, 4, 8, 10, 9, 15]
	 * Output: 5
	 * Explanation: You need to sort [6, 4, 8, 10, 9] in ascending order to make the whole array sorted in ascending order.
	 */
	public int findUnsortedSubarray(int[] nums) {
		int n = nums.length;
		int foreMax = nums[0], behindMin = nums[n - 1], start = -1, end = -2;
		for (int i = 1; i < n; i++) {
			foreMax = Math.max(nums[i], foreMax);
			behindMin = Math.min(nums[n - 1 - i], behindMin);
			//找到最后一个比前面最大值小的
			if (nums[i] < foreMax) {
				end = i;
			}
			//找到最前一个比前面最小值大的
			if (nums[n - 1 - i] > behindMin) {
				start = n - 1 - i;
			}
		}
		return end - start + 1;
	}
}