package com.zgl.leetcode.java.integer;

/**
 * @author zgl
 * @date 2018/12/20 上午10:40
 */
public class Palidromic {
	/**
	 * 9. Palindrome Number
	 * Determine whether an integer is a palindrome. An integer is a palindrome when it reads the same backward as forward.
	 *
	 * Example 1:
	 *
	 * Input: 121
	 * Output: true
	 * Example 2:
	 *
	 * Input: -121
	 * Output: false
	 * Explanation: From left to right, it reads -121. From right to left, it becomes 121-. Therefore it is not a palindrome.
	 * Example 3:
	 *
	 * Input: 10
	 * Output: false
	 * Explanation: Reads 01 from right to left. Therefore it is not a palindrome.
	 * Follow up:
	 *
	 * Coud you solve it without converting the integer to a string?
	 */
	public boolean isPalindrome(int x) {
		if (x < 0) {
			return false;
		}
		int target = 0, current = x;
		while (current != 0) {
			target = target * 10 + current % 10;
			current = current / 10;
		}
		return target == x;
	}

	public static void main(String[] args) {
		Palidromic mock=new Palidromic();
		System.out.println(mock.isPalindrome(-113));
	}
}
