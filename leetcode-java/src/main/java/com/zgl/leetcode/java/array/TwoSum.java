package com.zgl.leetcode.java.array;

/**
 * LeetCode 01
 * @author zgl
 * @date 2018/11/25 下午2:41
 */

/**
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {
	public int[] twoSum(int[] nums, int target){
		int [] result=new int[2];
		//Arrays.sort(nums);
		for(int i=0;i<nums.length;i++){
			for(int j=i+1;j<nums.length;j++){
				if(nums[i]+nums[j]==target){
					result[0]=i;
					result[1]=j;
				}
			}
		}
		return result;
	}

	public static void main(String[] args) {
		TwoSum twoSum=new TwoSum();
		int []nums= {3,2,4};
		int target=7;
		int[]result=twoSum.twoSum(nums,target);
		for(int i=0;i<result.length;i++){
			System.out.println(result[i]);
		}
	}
}
