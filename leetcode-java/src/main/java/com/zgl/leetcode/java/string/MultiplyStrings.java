package com.zgl.leetcode.java.string;

import java.util.Arrays;

/**
 * @author zgl
 * @date 2019/4/4 上午10:14
 */
public class MultiplyStrings {

	/**
	 * 43. Multiply Strings
	 * Given two non-negative integers num1 and num2 represented as strings,
	 * return the product of num1 and num2, also represented as a string.
	 *
	 * Example 1:
	 *
	 * Input: num1 = "2", num2 = "3"
	 * Output: "6"
	 * Example 2:
	 *
	 * Input: num1 = "123", num2 = "456"
	 * Output: "56088"
	 * Note:
	 *
	 * The length of both num1 and num2 is < 110.
	 * Both num1 and num2 contain only digits 0-9.
	 * Both num1 and num2 do not contain any leading zero, except the number 0 itself.
	 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
	 */
	public String multiply(String num1, String num2) {
		int m = num1.length();
		int n = num2.length();
		int[] result = new int[m + n];
		Arrays.fill(result, 0);
		int i, j;
		for (i = m - 1; i >= 0; i--) {
			for (j = n - 1; j >= 0; j--) {
				int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
				int sum = result[i + j + 1] + mul;
				result[i + j + 1] = sum % 10;
				result[i + j] += sum / 10;
				for (int i1 : result) {
					System.out.print(i1 + " ");
				}
				System.out.println();
			}
		}
		StringBuilder stringBuilder = new StringBuilder();
		for (i = 0; i < result.length; i++) {
			if (!(result[i] == 0 && stringBuilder.length() == 0)) {
				stringBuilder.append(result[i]);
			}
		}
		return stringBuilder.length() == 0 ? "0" : stringBuilder.toString();
	}

	public static void main(String[] args) {
		System.out.println(new MultiplyStrings().multiply("39","99"));
	}
}