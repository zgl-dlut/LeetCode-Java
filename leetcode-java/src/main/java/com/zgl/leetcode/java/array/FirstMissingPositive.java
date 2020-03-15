package com.zgl.leetcode.java.array;

import java.util.Arrays;

/**
 * @author zgl
 * @date 2019/4/3 下午4:17
 */
public class FirstMissingPositive {

	/**
	 * 41. First Missing Positive
	 * Given an unsorted integer array, find the smallest missing positive integer.
	 *
	 * Example 1:
	 *
	 * Input: [1,2,0]
	 * Output: 3
	 * Example 2:
	 *
	 * Input: [3,4,-1,1]
	 * Output: 2
	 * Example 3:
	 *
	 * Input: [7,8,9,11,12]
	 * Output: 1
	 * Note:
	 *
	 * Your algorithm should run in O(n) time and uses constant extra space.
	 */
	public int firstMissingPositive(int[] nums) {
		int length = nums.length;
		if (length == 0) {
			return 1;
		}
		/**
		 * 假设数组的大小为n，我们遍历整个数组，如果当前元素i在1-n之间那么就将当前元素和数组第i-1个元素交换。如果当前元素是复数或者大于n那么就不处理。
		 * 这样遍历完所有的元素之后，原始数组当中出现在1-n之间的元素都被放在了对应的0~n-1的位置里。
		 * 再次遍历数组，找到第一个不满足v[i]==i+1的位置，那么i+1就是最小的未出现的正整数
		 * 比如nums[i] == 2,那么需要将数组中的位置2-1放入2也就是nums[nums[i] - 1] = 2;
		 */
		for (int i = 0; i < length; i++) {
			if (nums[i] > 0) {
				while (nums[i] > 0 && nums[i] <= length && nums[i] != nums[nums[i] - 1]) {
					int temp = nums[nums[i] - 1];
					nums[nums[i] - 1] = nums[i];
					nums[i] = temp;
				}
			}
		}
		for (int i = 0; i < length; i++) {
			if (nums[i] != i + 1) {
				return i + 1;
			}
		}
		return length + 1;
	}

	static int i = 1;
	static {
		i = 2;
	}
	public static void main(String[] args) {
		int[] nums = {3,4,-1,1};
		int result = new FirstMissingPositive().firstMissingPositive(nums);
		System.out.println(result);
		//System.out.println(FirstMissingPositive.i);
	}
}