package com.zgl.leetcode.java.array;

import java.util.*;

/**
 * @author zgl
 * @date 2020/1/10 上午10:59
 */
public class ContainsDuplicate {
	public static void main(String[] args) {
		ContainsDuplicate containsDuplicate = new ContainsDuplicate();
		int[] nums = {1,2,3,1,2,3};
		System.out.println(containsDuplicate.containsNearbyDuplicate1(nums, 2));
	}

	/**
	 * 217. Contains Duplicate
	 * Given an array of integers, find if the array contains any duplicates.
	 *
	 * Your function should return true if any value appears at least twice in the array, and it should return false if every element is distinct.
	 *
	 * Example 1:
	 *
	 * Input: [1,2,3,1]
	 * Output: true
	 * Example 2:
	 *
	 * Input: [1,2,3,4]
	 * Output: false
	 * Example 3:
	 *
	 * Input: [1,1,1,3,3,4,3,2,4,2]
	 * Output: true
	 */
	public boolean containsDuplicate(int[] nums) {
		Map<Integer, Integer> countMap = new HashMap<>();
		for (int i : nums) {
			countMap.put(i, countMap.getOrDefault(i, 0) + 1);
			if (countMap.get(i) > 1) {
				return true;
			}
		}
		return false;
	}

	/**
	 * 219. Contains Duplicate II
	 * Given an array of integers and an integer k, find out whether there are two distinct indices i and j in the array such that nums[i] = nums[j] and the absolute difference between i and j is at most k.
	 *
	 * Example 1:
	 *
	 * Input: nums = [1,2,3,1], k = 3
	 * Output: true
	 * Example 2:
	 *
	 * Input: nums = [1,0,1,1], k = 1
	 * Output: true
	 * Example 3:
	 *
	 * Input: nums = [1,2,3,1,2,3], k = 2
	 * Output: false
	 */
	public boolean containsNearbyDuplicate1(int[] nums, int k) {
		Map<Integer, List<Integer>> countListMap = new HashMap<>();
		int n = nums.length;
		for (int i = 0; i < n; i++) {
			if (!countListMap.containsKey(nums[i])) {
				countListMap.put(nums[i], new ArrayList<>());
			}
			countListMap.get(nums[i]).add(i);
		}
		for (Map.Entry<Integer, List<Integer>> entry : countListMap.entrySet()) {
			List<Integer> countList = entry.getValue();
			if (countList.size() <= 1) {
				continue;
			}
			for (int i = 1; i < countList.size(); i++) {
				if (countList.get(i) - countList.get(i - 1) <= k) {
					return true;
				}
			}
		}
		return false;
	}

	public boolean containsNearbyDuplicate(int[] nums, int k) {
		/**
		 * set中最多只有k + 1个元素,如果加入失败,说明有重复的元素,返回true,如果加入成功且长度大于K + 1,移除最开始的元素
		 */
		Set<Integer> set = new HashSet<>();
		for (int i = 0; i < nums.length; i++) {
			if (!set.add(nums[i])) {
				return true;
			}
			if (set.size() == k + 1) {
				set.remove(nums[i - k]);
			}
		}
		return false;
	}
}