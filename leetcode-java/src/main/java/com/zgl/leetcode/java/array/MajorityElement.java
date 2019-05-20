package com.zgl.leetcode.java.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @author zgl
 * @date 2019/5/19 上午11:50
 */
public class MajorityElement {

	/**
	 * 169. Majority Element
	 * Given an array of size n, find the majority element. The majority element is the element that appears more than ⌊ n/2 ⌋ times.
	 *
	 * You may assume that the array is non-empty and the majority element always exist in the array.
	 *
	 * Example 1:
	 *
	 * Input: [3,2,3]
	 * Output: 3
	 * Example 2:
	 *
	 * Input: [2,2,1,1,1,2,2]
	 * Output: 2
	 */
	public int majorityElement1(int[] nums) {
		/*int length = nums.length;
		if (length <= 2){
			return nums[0];
		}
		Arrays.sort(nums);
		return nums[length / 2] == nums[length / 2 - 1] ? nums[length / 2] : nums[length / 2 + 1];*/
		Arrays.sort(nums);
		return nums[nums.length / 2];
	}

	public int majorityElement(int[] nums){
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++){
			int count = map.getOrDefault(nums[i], 0);
			if(count == nums.length / 2){
				return nums[i];
			}else {
				map.put(nums[i], count + 1);
			}
		}
		return 0;
	}
	public static void main(String[] args) {
		int[] nums = {2,2};
		System.out.println(new MajorityElement().majorityElement1(nums));
	}
}