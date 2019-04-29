package com.zgl.leetcode.java.string;

/**
 * @author zgl
 * @date 2019/4/28 下午4:51
 */
public class AddBinary {

	/**
	 * 67. Add Binary
	 * Given two binary strings, return their sum (also a binary string).
	 *
	 * The input strings are both non-empty and contains only characters 1 or 0.
	 *
	 * Example 1:
	 *
	 * Input: a = "11", b = "1"
	 * Output: "100"
	 * Example 2:
	 *
	 * Input: a = "1010", b = "1011"
	 * Output: "10101"
	 */
	public String addBinary(String a, String b) {
		int lengthA = a.length();
		int lengthB = b.length();
		int length = Math.max(lengthA, lengthB);
		int value, carry = 0, tempA, tempB;
		StringBuilder res = new StringBuilder();
		for (int i = 0; i < length; i++) {
			tempA = lengthA > i ? a.charAt(lengthA - i - 1) - '0' : 0;
			tempB = lengthB > i ? b.charAt(lengthB - i - 1) - '0' : 0;
			value = tempA + tempB + carry;
			carry = value / 2;
			value = value % 2;
			res.append(value);
		}
		if (carry == 1) {
			res.append(carry);
		}
		return res.reverse().toString();
	}

	public static void main(String[] args) {
		String a ="1010", b = "1011";
		System.out.println(new AddBinary().addBinary(a, b));
	}
}