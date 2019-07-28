package com.zgl.leetcode.java.array;

/**
 * @author zgl
 * @date 2018/11/25 下午5:20
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 15. 3Sum
 * <p>
 * Given array nums = [-1, 0, 1, 2, -1, -4],
 * <p>
 * Given an array nums of n integers, are there elements a, b, c in nums such that a + b + c = 0?
 * Find all unique triplets in the array which gives the sum of zero.
 * [
 * [-1, 0, 1],
 * [-1, -1, 2]
 * ]
 */
public class ThreeSum {
	public List<List<Integer>> threeSum(int[] nums) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		int length = nums.length;
		if (length < 3) {
			return result;
		}
		for (int i = 0; i < length - 2; i++) {
			int sum = -nums[i];
			int start = i + 1;
			int end = length - 1;
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			while (start < end) {
				if (nums[start] > sum / 2) {
					break;
				}
				if (nums[start] + nums[end] == sum) {
					List<Integer> temp = new ArrayList<>();
					temp.add(nums[i]);
					temp.add(nums[start]);
					temp.add(nums[end]);
					result.add(temp);
					/**
					 * 避免重复
					 */
					while (start < end && nums[start] == nums[start + 1]) {
						start++;
					}
					while (start < end && nums[end] == nums[end - 1]) {
						end--;
					}
					start++;
					end--;
				} else if (nums[start] + nums[end] < sum) {
					start++;
				} else if (nums[start] + nums[end] > sum) {
					end--;
				}
			}

		}
		return result;
	}

	/**
	 * 16. 3Sum Closest
	 * Given an array nums of n integers and an integer target, find three integers in nums such that the sum is closest to target.
	 * Return the sum of the three integers. You may assume that each input would have exactly one solution.
	 * <p>
	 * Example:
	 * <p>
	 * Given array nums = [-1, 2, 1, -4], and target = 1.
	 * <p>
	 * The sum that is closest to the target is 2. (-1 + 2 + 1 = 2).
	 */
	public int threeSumClosest(int[] nums, int target) {
		Arrays.sort(nums);
		int length = nums.length;
		int result = nums[length - 1] + nums[length - 2] + nums[length - 3];
		int distance = Math.abs(result - target);
		int start, end, temp;
		for (int i = 0; i < length - 2; i++) {
			start = i + 1;
			end = length - 1;
			while (start < end) {
				temp = nums[i] + nums[start] + nums[end];
				if (distance > Math.abs(temp - target)) {
					distance = Math.abs(temp - target);
					result = temp;
				}
				if (temp == target) {
					return target;
				} else if (temp < target) {
					start++;
				} else {
					end--;
				}
			}
		}

		return result;
	}

	public static void main(String[] args) {
		int[] nums = {1, 1, 1, 0};
		List<List<Integer>> result = new ThreeSum().threeSum(nums);
		//System.out.println(result);
		ThreeSum mock = new ThreeSum();
		System.out.println(mock.threeSumClosest(nums, -100));
	}
}
