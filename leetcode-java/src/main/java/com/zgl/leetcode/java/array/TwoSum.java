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
