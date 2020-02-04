package com.zgl.leetcode.java.array;

/**
 * @author zgl
 * @date 2020/2/3 下午2:31
 */
public class RotateArray {
	public static void main(String[] args) {
		int[] nums = {1,2,3,4,5,6,7};
		new RotateArray().rotate(nums, 3);
		for (int num : nums) {
			System.out.print(num + " ");
		}
	}

	/**
	 * 189. Rotate Array
	 * Given an array, rotate the array to the right by k steps, where k is non-negative.
	 *
	 * Example 1:
	 *
	 * Input: [1,2,3,4,5,6,7] and k = 3
	 * Output: [5,6,7,1,2,3,4]
	 * Explanation:
	 * rotate 1 steps to the right: [7,1,2,3,4,5,6]
	 * rotate 2 steps to the right: [6,7,1,2,3,4,5]
	 * rotate 3 steps to the right: [5,6,7,1,2,3,4]
	 * Example 2:
	 *
	 * Input: [-1,-100,3,99] and k = 2
	 * Output: [3,99,-1,-100]
	 * Explanation:
	 * rotate 1 steps to the right: [99,-1,-100,3]
	 * rotate 2 steps to the right: [3,99,-1,-100]
	 * Note:
	 *
	 * Try to come up as many solutions as you can,
	 * there are at least 3 different ways to solve this problem.
	 * Could you do it in-place with O(1) extra space?
	 */
	public void rotate1(int[] nums, int k) {
		int count = 1;
		while (count++ <= k % nums.length) {
			subRotate(nums);
		}
	}

	private void subRotate(int[] nums) {
		int n = nums.length;
		int temp = nums[n - 1];
		for (int i = n - 2; i >= 0; i--) {
			nums[i + 1] = nums[i];
		}
		nums[0] = temp;
	}

	public void rotate(int[] nums, int k) {
		int n = nums.length;
		int finalK = k % n;
		reverse(nums, 0, n - finalK - 1);
		reverse(nums, n - finalK, n - 1);
		reverse(nums, 0, n - 1);
	}

	private void reverse(int[] nums, int left, int right) {
		while (left < right) {
			int temp = nums[left];
			nums[left++] = nums[right];
			nums[right--] = temp;
		}
	}
}