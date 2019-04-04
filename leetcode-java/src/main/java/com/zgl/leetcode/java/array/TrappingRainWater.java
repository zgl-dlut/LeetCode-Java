package com.zgl.leetcode.java.array;

/**
 * @author zgl
 * @date 2019/4/3 下午6:01
 */
public class TrappingRainWater {
	/**
	 * 42. Trapping Rain Water
	 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
	 * compute how much water it is able to trap after raining.

	 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
	 * Output: 6
	 */
	public int trap1(int[] height) {
		int length = height.length;
		if (length < 2) {
			return 0;
		}
		int result = 0;
		for (int i = 0; i < length; i++) {
			int maxLeft = 0, maxRight = 0;
			for (int j = i; j >= 0; j--) {
				maxLeft = Math.max(maxLeft, height[j]);
			}
			for (int j = i; j <length; j++) {
				maxRight = Math.max(maxRight, height[j]);
			}
			result += Math.min(maxLeft, maxRight) - height[i];
		}
		return result;
	}

	public int trap(int[] height) {
		int length = height.length;
		if (length < 2) {
			return 0;
		}
		int result = 0, maxLeft = 0, maxRight = 0, left = 0, right = length - 1;
		while (left < right) {
			if (height[left] < height[right]) {
				if (height[left] > maxLeft) {
					maxLeft = height[left];
				} else {
					result += maxLeft - height[left];
				}
				left++;
			} else {
				if (height[right] > maxRight) {
					maxRight = height[right];
				} else {
					result += maxRight - height[right];
				}
				right--;
			}
		}
		return result;
	}
	public static void main(String[] args) {
		int[] height={0,1,0,2,1,0,1,3,2,1,2,1};
		System.out.println(new TrappingRainWater().trap(height));
	}
}