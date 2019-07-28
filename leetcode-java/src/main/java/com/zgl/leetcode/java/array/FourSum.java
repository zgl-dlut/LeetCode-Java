package com.zgl.leetcode.java.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zgl
 * @date 2018/12/28 下午3:56
 */
public class FourSum {
	public static void main(String[] args) {
		FourSum mock = new FourSum();
		int[] nums = {-3,-2,-1,0,0,1,2,3};
		int target = 0;
		System.out.println(mock.fourSum(nums, target));
	}

	/**
	 * 18. 4Sum
	 * Given an array nums of n integers and an integer target, are there elements a, b, c, and d in nums such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.
	 * <p>
	 * Note:
	 * <p>
	 * The solution set must not contain duplicate quadruplets.
	 * <p>
	 * Example:
	 * <p>
	 * Given array nums = [1, 0, -1, 0, -2, 2], and target = 0.
	 * <p>
	 * A solution set is:
	 * [
	 * [-1,  0, 0, 1],
	 * [-2, -1, 1, 2],
	 * [-2,  0, 0, 2]
	 * ]
	 */
	public List<List<Integer>> fourSum1(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		if (nums.length < 4) {
			return result;
		}
		Arrays.sort(nums);
		int start, end;
		for (int i = 0; i < nums.length - 3; i++) {
			if (i > 0 && nums[i] == nums[i - 1]) {
				continue;
			}
			for (int j = i + 1; j < nums.length - 2; j++) {
				if (j != i + 1 && nums[j] == nums[j - 1]) {
					continue;
				}
				start = j + 1;
				end = nums.length - 1;
				while (start < end) {
					if (nums[i] + nums[j] + nums[start] + nums[end] == target) {
						List<Integer> temp = new ArrayList<>();
						temp.add(nums[i]);
						temp.add(nums[j]);
						temp.add(nums[start]);
						temp.add(nums[end]);
						result.add(temp);
						while (start < end && nums[start] == nums[start + 1]) {
							start++;
						}
						while (start < end && nums[end] == nums[end - 1]) {
							end--;
						}
						start++;
						end--;
					} else if (nums[i] + nums[j] + nums[start] + nums[end] < target) {
						start++;
					} else {
						end--;
					}
				}
			}
		}
		return result;
	}

	public List<List<Integer>> fourSum(int[] nums, int target) {
		List<List<Integer>> result = new ArrayList<>();
		Arrays.sort(nums);
		int length = nums.length;
		for (int i = 0; i < length - 3; i++) {
			if (i == 0 || (i > 0 && nums[i] != nums[i - 1])) {
				for (int j = i + 1; j < length - 2; j++) {
					if (j == i + 1 || (j > i + 1 && nums[j] != nums[j - 1])) {
						int remain = target - nums[j] - nums[i];
						int left = j + 1, right = length - 1;
						while (left < right) {
							if (nums[left] + nums[right] == remain) {
								List<Integer> answer = new ArrayList<>();
								answer.add(nums[i]);
								answer.add(nums[j]);
								answer.add(nums[left]);
								answer.add(nums[right]);
								result.add(answer);
								while (left < right && nums[left] == nums[left + 1]) {
									left++;
								}
								while (left < right && nums[right] == nums[right - 1]) {
									right--;
								}
								left++;
								right--;
							} else if (nums[left] + nums[right] < remain) {
								left++;
							} else {
								right--;
							}
						}
					}
				}
			}
		}
		return result;
	}
}
