package com.zgl.leetcode.java.array;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zgl
 * @date 2018/11/25 下午8:00
 */
public class SearchInsertPosition {
	/**
	 * 35. Search Insert Position
	 * Given a sorted array and a target value, return the index if the target is found.
	 * If not, return the index where it would be if it were inserted in order.
	 * <p>
	 * Example 1:
	 * Input: [1,3,5,6], 5
	 * Output: 2
	 * <p>
	 * Example 2:
	 * Input: [1,3,5,6], 2
	 * Output: 1
	 * <p>
	 * Example 3:
	 * Input: [1,3,5,6], 7
	 * Output: 4
	 * <p>
	 * Example 4:
	 * Input: [1,3,5,6], 0
	 * Output: 0
	 */
	public int searchInsert(int[] nums, int target) {
		int length = nums.length;
		if (target < nums[0]) {
			return 0;
		}
		if (target > nums[length - 1]) {
			return length;
		}
		int start = 0;
		int end = length - 1;
		int mid ;
		while (start <= end) {
			mid=(start+end)/2;
			if (target == nums[mid]) {
				return mid;
			} else if (target < nums[mid]) {
				end = mid - 1;
			} else {
				start = mid + 1;
			}
		}
		return start;
	}

	/**
	 * 34. Find First and Last Position of Element in Sorted Array
	 * Given an array of integers nums sorted in ascending order, find the starting and ending position of a given target value.
	 *
	 * Your algorithm's runtime complexity must be in the order of O(log n).
	 *
	 * If the target is not found in the array, return [-1, -1].
	 *
	 * Example 1:
	 *
	 * Input: nums = [5,7,7,8,8,10], target = 8
	 * Output: [3,4]
	 * Example 2:
	 *
	 * Input: nums = [5,7,7,8,8,10], target = 6
	 * Output: [-1,-1]
	 */
	public int[] searchRange(int[] nums, int target) {
		/*int left=0,right=nums.length-1,mid;
		int[]result={-1,-1};
		while (left<=right){
			mid=left+(right-left)/2;
			if(nums[mid]==target){
				left=mid;
				right=mid;
				while (left>=0&&nums[left]==target){
					left--;
				}
				while (right<nums.length&&nums[right]==target){
					right++;
				}
				result[0]=left+1;
				result[1]=right-1;
				break;
			}else if(nums[mid]<target){
				left=mid+1;
			}else {
				right=mid-1;
			}
		}
		return result;*/
		int n = nums.length;
		Map<Integer, List<Integer>> countMap = new HashMap<>();
		for(int i = 0; i < n; i++) {
			if(!countMap.containsKey(nums[i])) {
				countMap.put(nums[i], new ArrayList<>());
			}
			countMap.get(nums[i]).add(i);
		}
		int[] result = new int[]{-1, -1};
		if(countMap.containsKey(target)) {
			List<Integer> list = countMap.get(target);
			result[0] = list.get(0);
			result[1] = list.get(list.size() - 1);
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(LocalDate.now().toString().substring(0,10));
		System.out.println(LocalTime.now().toString().substring(0,5));
	}
}
