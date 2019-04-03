package com.zgl.leetcode.java.array;

/**
 * @author zgl
 * @date 2018/12/27 下午2:41
 */
public class ContainerWithMostWater {
	/**
	 * 11. Container With Most Water
	 *
	 * Given n non-negative integers a1, a2, ..., an , where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.
	 *
	 * Note: You may not slant the container and n is at least 2.
	 * Example:
	 *
	 * Input: [1,8,6,2,5,4,8,3,7]
	 * Output: 49
	 */
	public int maxArea(int[] height) {
		int left=0,right=height.length-1;
		int max=Math.min(height[left],height[right])*(right-left);
		while(left<right){
			if(height[left]<height[right]){
				max=Math.max(max,height[left]*(right-left));
				left++;
			}else {
				max=Math.max(max,height[right]*(right-left));
				right--;
			}
		}
		return max;
	}

	public static void main(String[] args) {
		ContainerWithMostWater mock=new ContainerWithMostWater();
		int[]height={1,8,6,2,5,4,8,3,7};
		System.out.println(mock.maxArea(height));
	}
}
