package com.zgl.leetcode.java.array;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zgl
 * @date 2019/5/22 下午4:19
 */
public class topK {

	public static void main(String[] args) {
		int[] nums = {1,2,2,2,3,3,3};
		System.out.println(new topK().topKFrequent1(nums, 2));
	}

	/**
	 * 347. Top K Frequent Elements
	 * Given a non-empty array of integers, return the k most frequent elements.
	 *
	 * Example 1:
	 *
	 * Input: nums = [1,1,1,2,2,3], k = 2
	 * Output: [1,2]
	 * Example 2:
	 *
	 * Input: nums = [1], k = 1
	 * Output: [1]
	 * Note:
	 *
	 * You may assume k is always valid, 1 ≤ k ≤ number of unique elements.
	 * Your algorithm's time complexity must be better than O(n log n), where n is the array's size.
	 */
	public List<Integer> topKFrequent1(int[] nums, int k) {

		int length = nums.length;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < length; i++) {
			map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
		}
		List<Integer>[] array = new ArrayList[length + 1];
		/*for (int key : map.keySet()) {
			int count = map.get(key);
			if (array[count] == null) {
				array[count] = new ArrayList<>();
			}
			array[count].add(key);
		}*/
		for(Map.Entry entry : map.entrySet()) {
			if (array[(Integer)entry.getValue()] == null) {
				array[(Integer)entry.getValue()] = new ArrayList<>();
			}
			array[(Integer)entry.getValue()].add((Integer)entry.getKey());
		}
		List<Integer> result = new ArrayList<>();
		for (int i = length; i >= 0 && result.size() < k; i--) {
			if (array[i] != null) {
				result.addAll(array[i]);
			}
		}
		return result;
	}
	@SuppressWarnings("unchecked")
	public List<Integer> topKFrequent(int[] nums, int k) {
		int length = nums.length;
		Map<Integer, Integer> map = new HashMap<>();
		for (int i : nums) {
			map.put(i, map.getOrDefault(i, 0) + 1);
		}
		List<Integer>[] countListArray = new ArrayList[length + 1];
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (countListArray[entry.getValue()] == null) {
				countListArray[entry.getValue()] = new ArrayList<>();
			}
			countListArray[entry.getValue()].add(entry.getKey());
		}
		List<Integer> result = new ArrayList<>();
		for (int i = length; i >= 0 && result.size() < k; i--) {
			if (countListArray[i] != null) {
				result.addAll(countListArray[i]);
			}
		}
		return result;
	}

}