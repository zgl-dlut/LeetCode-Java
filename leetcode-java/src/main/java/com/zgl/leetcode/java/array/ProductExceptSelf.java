package com.zgl.leetcode.java.array;

/**
 * @author zgl
 * @date 2019/11/3 下午4:59
 */
public class ProductExceptSelf {
	public static void main(String[] args) {
		int[] nums = {1, 2, 3, 4};
		int[] result = new ProductExceptSelf().productExceptSelf1(nums);
		for (int i = 0; i < result.length; i++) {
			System.out.println(result[i] + " ");
		}
	}

	/**
	 * 238. Product of Array Except Self
	 * Given an array nums of n integers where n > 1,  return an array output
	 * such that output[i] is equal to the product of all the elements of nums except nums[i].
	 *
	 * Example:
	 *
	 * Input:  [1,2,3,4]
	 * Output: [24,12,8,6]
	 * Note: Please solve it without division and in O(n).
	 *
	 * Follow up:
	 * Could you solve it with constant space complexity?
	 * (The output array does not count as extra space for the purpose of space complexity analysis.)
	 */
	public int[] productExceptSelf(int[] nums) {
		//构造两个数组
		int n = nums.length;
		//{1,a1,a1*a2,a1*a2*a3}
		int[] a = new int[n];
		//{a2*a3*a4,a3*a4,a4,1}
		int[] b = new int[n];
		a[0] = 1;
		for (int i = 1; i < n; i++) {
			a[i] = nums[i - 1] * a[i - 1];
		}
		b[n - 1] = 1;
		for (int i = n - 2; i >= 0; i--) {
			b[i] = nums[i + 1] * b[i + 1];
		}
		int[] result = new int[n];
		for (int i = 0; i < n; i++) {
			result[i] = a[i] * b[i];
		}
		return result;
	}

	public int[] productExceptSelf1(int[] nums) {
		int n = nums.length;
		int a = 1, b = 1;
		int[] result = new int[n];
		result[0] = result[n - 1] = 1;
		for (int i = 1; i < n; i++) {
			result[i] = nums[i - 1] * a;
			a *= nums[i - 1];
		}
		for (int i = n - 2; i >=0; i--) {
			result[i] *= nums[i + 1] * b;
			b *= nums[i + 1];
		}
		return result;
	}
}