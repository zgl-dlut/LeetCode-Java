package com.zgl.leetcode.java.dynamic;

/**
 * @author zgl
 * @date 2019/7/1 上午11:27
 */
public class DecodeWays {
	public static void main(String[] args) {
		String s = "0200";
		System.out.println(new DecodeWays().numDecodings(s));
	}

	/**
	 * 91. Decode Ways
	 * A message containing letters from A-Z is being encoded to numbers using the following mapping:
	 *
	 * 'A' -> 1
	 * 'B' -> 2
	 * ...
	 * 'Z' -> 26
	 * Given a non-empty string containing only digits, determine the total number of ways to decode it.
	 *
	 * Example 1:
	 *
	 * Input: "12"
	 * Output: 2
	 * Explanation: It could be decoded as "AB" (1 2) or "L" (12).
	 * Example 2:
	 *
	 * Input: "226"
	 * Output: 3
	 * Explanation: It could be decoded as "BZ" (2 26), "VF" (22 6), or "BBF" (2 2 6).
	 */
	public int numDecodings(String s) {
		int length = s.length();
		if (length == 0) {
			return 0;
		}
		int[] dp = new int[length + 1];
		dp[0] = 1;
		if (s.charAt(0) >= '1') {
			dp[1] = 1;
		}
		for (int i = 2; i <= length; i++) {
			if (s.charAt(i - 1) >= '1') {
				dp[i] = dp[i - 1];
			}
			int compare = Integer.parseInt(s.substring(i - 2, i));
			if (s.charAt(i - 2) != '0' && compare <= 26) {
				dp[i] += dp[i - 2];
			}
		}
		return dp[length];
	}

}