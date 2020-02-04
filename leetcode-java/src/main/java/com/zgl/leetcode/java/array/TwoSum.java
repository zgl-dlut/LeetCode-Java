package com.zgl.leetcode.java.array;

/**
 * LeetCode 01
 * @author zgl
 * @date 2018/11/25 下午2:41
 */

import java.util.HashMap;
import java.util.Map;

/**
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {
	public int[] twoSum1(int[] nums, int target) {
		int[] result = new int[2];
		for (int i = 0; i < nums.length - 1; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[i] + nums[j] == target) {
					result[0] = i;
					result[1] = j;
					break;
				}
			}
		}
		return result;
	}

	public int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> hashMap = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			if (hashMap.containsKey(target - nums[i])) {
				return new int[]{hashMap.get(target - nums[i]), i};
			}else {
				hashMap.put(nums[i], i);
			}
		}
		return null;
	}

	/**
	 * 167. Two Sum II - Input array is sorted
	 * Given an array of integers that is already sorted in ascending order, find two numbers such that they add up to a specific target number.
	 *
	 * The function twoSum should return indices of the two numbers such that they add up to the target, where index1 must be less than index2.
	 *
	 * Note:
	 *
	 * Your returned answers (both index1 and index2) are not zero-based.
	 * You may assume that each input would have exactly one solution and you may not use the same element twice.
	 * Example:
	 *
	 * Input: numbers = [2,7,11,15], target = 9
	 * Output: [1,2]
	 * Explanation: The sum of 2 and 7 is 9. Therefore index1 = 1, index2 = 2.
	 */
	public int[] twoSum2(int[] numbers, int target) {
		int[] result = new int[2];
		int left = 0, right = numbers.length - 1;
		while (left < right) {
			if (numbers[left] + numbers[right] == target) {
				result[0] = left + 1;
				result[1] = right + 1;
				break;
			} else if (numbers[left] + numbers[right] > target) {
				right--;
			} else {
				left++;
			}
		}
		return result;
	}

	public static void main(String[] args) {
		TwoSum twoSum = new TwoSum();
		int[] nums = {3, 2, 4};
		int target = 7;
		int[] result = twoSum.twoSum(nums, target);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i]);
		}
	}
}
