package com.zgl.leetcode.java.string;

/**
 * @author zgl
 * @date 2019/4/24 下午7:46
 */
public class PermutationSequence {

	/**
	 * 60. Permutation Sequence
	 * The set [1,2,3,...,n] contains a total of n! unique permutations.
	 *
	 * By listing and labeling all of the permutations in order, we get the following sequence for n = 3:
	 *
	 * "123"
	 * "132"
	 * "213"
	 * "231"
	 * "312"
	 * "321"
	 * Given n and k, return the kth permutation sequence.
	 *
	 * Example 1:
	 *
	 * Input: n = 3, k = 3
	 * Output: "213"
	 * Example 2:
	 *
	 * Input: n = 4, k = 9
	 * Output: "2314"
	 */
	public String getPermutation(int n, int k) {
		StringBuilder result = new StringBuilder();
		int factorial = factorial(n);
		StringBuilder temp = new StringBuilder();
		for (int i = 1; i <= n; i++) {
			temp.append(i);
		}
		for (int i = n; i >= 1; i--) {
			factorial /= i;
			int index = (k - 1) / factorial;
			//第k个排列的第一个元素在0-n中的位置为（k-1）/（n-1）！
			//总共有n个数字，那么以每个数字开头都有(n-1)!种
			String tag = "" + temp.charAt(index);
			result.append(tag);
			temp.deleteCharAt(index);
			//﻿在剩下的元素中继续找第一个
			k -= index * factorial;
		}
		return result.toString();
	}

	private int factorial(int n) {
		int result = 1;
		for (int i = 1; i <= n; i++) {
			result *= i;
		}
		return result;
	}

	public static void main(String[] args) {
		System.out.println(new PermutationSequence().getPermutation(4, 9));
	}
}