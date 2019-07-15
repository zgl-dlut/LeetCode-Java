package com.zgl.leetcode.java.integer;

/**
 * @author zgl
 * @date 2019/7/15 下午4:16
 */
public class SqrtNum2 {

	public static void main(String[] args) {
		System.out.println(new SqrtNum2().getSqrtNum2());
		System.out.println(Math.sqrt(2));
	}

	/**
	 * 二分法求解根号2
	 */
	public double getSqrtNum2() {
		double left = 1, right = 2;
		while (left <= right) {
			double mid = (left + right) / 2;
			if (errorRange(mid)) {
				return mid;
			}
			if (mid * mid < 2) {
				left = mid;
			}else {
				right = mid;
			}
		}
		return left;
	}

	private boolean errorRange(double num) {
		if (Math.abs(num * num - 2) < 1e-5) {
			return true;
		}
		return false;
	}
}