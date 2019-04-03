package com.zgl.leetcode.java.array;

/**
 * @author zgl
 * @date 2019/1/3 下午7:17
 */
public class SearchInRotatedSortedArray {
	/**
	 * 33. Search in Rotated Sorted Array
	 * Suppose an array sorted in ascending order is rotated at some pivot unknown to you beforehand.
	 * <p>
	 * (i.e., [0,1,2,4,5,6,7] might become [4,5,6,7,0,1,2]).
	 * <p>
	 * You are given a target value to search. If found in the array return its index, otherwise return -1.
	 * <p>
	 * You may assume no duplicate exists in the array.
	 * <p>
	 * Your algorithm's runtime complexity must be in the order of O(log n).
	 * <p>
	 * Example 1:
	 * <p>
	 * Input: nums = [4,5,6,7,0,1,2], target = 0
	 * Output: 4
	 * Example 2:
	 * <p>
	 * Input: nums = [4,5,6,7,0,1,2], target = 3
	 * Output: -1
	 */
	public int search(int[] nums, int target) {
		int left=0,right=nums.length-1,mid;
		while(left<=right){
			mid=left+(right-left)/2;
			if(nums[mid]==target){
				return mid;
			}
			if(nums[left]<=nums[mid]){
				if(target>=nums[left]&&target<=nums[mid]){
					right=mid-1;
				}else {
					left=mid+1;
				}
			}else {
				if(target>=nums[mid]&&target<=nums[right]){
					left=mid+1;
				}else {
					right=mid-1;
				}
			}
		}
		return -1;
	}
}
