package com.zgl.leetcode.java.integer;

/**
 * @author zgl
 * @date 2019/4/29 下午5:33
 */
public class Sqrt {

	/**
	 * 69. Sqrt(x)
	 * Implement int sqrt(int x).
	 *
	 * Compute and return the square root of x, where x is guaranteed to be a non-negative integer.
	 *
	 * Since the return type is an integer,
	 * the decimal digits are truncated and only the integer part of the result is returned.
	 *
	 * Example 1:
	 *
	 * Input: 4
	 * Output: 2
	 * Example 2:
	 *
	 * Input: 8
	 * Output: 2
	 * Explanation: The square root of 8 is 2.82842..., and since
	 *              the decimal part is truncated, 2 is returned.
	 */
	public int mySqrt(int x) {
		if (x <= 1) {
			return x;
		}
		int left = 1, right = x, mid;
		while (left <= right) {
			mid = left + (right - left) / 2;
			if (x / mid >= mid) {
				left = mid + 1;
			} else {
				right = mid - 1;
			}
		}
		return right;
	}

	public static void main(String[] args) {
		System.out.println(new Sqrt().mySqrt(15));
	}
}