package com.zgl.leetcode.java.string;

import java.util.*;

/**
 * @author zgl
 * @date 2018/12/8 下午4:25
 */
public class LongestSubstring {
	/**
	 * 3. Longest Substring Without Repeating Characters
	 * Given a string, find the length of the longest substring without repeating characters.
	 *
	 * Example 1:
	 *
	 * Input: "abcabcbb"
	 * Output: 3
	 * Explanation: The answer is "abc", with the length of 3.
	 * Example 2:
	 *
	 * Input: "bbbbb"
	 * Output: 1
	 * Explanation: The answer is "b", with the length of 1.
	 * Example 3:
	 *
	 * Input: "pwwkew"
	 * Output: 3
	 * Explanation: The answer is "wke", with the length of 3.
	 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
	 */
	public int lengthOfLongestSubstring(String s) {
		if (s.length() == 0) {
			return 0;
		}
		int[] dp = new int[256];
		Arrays.fill(dp, -1);
		int result = 1, left = -1;
		for (int i = 0; i < s.length(); i++) {
			left = Math.max(left, dp[s.charAt(i)]);
			dp[s.charAt(i)] = i;
			result = Math.max(result, i - left);
		}
		return result;
	}

	public static void main(String[] args) {
		String s="abcabcbb";
		LongestSubstring mock=new LongestSubstring();
		System.out.println(s.length());
		System.out.println(mock.lengthOfLongestSubstring(s));

	}

	public int lengthOfLongestSubstring1(String s) {
		Map<Character, Integer> map = new HashMap<>();
		int result = 0;
		for (int left = 0, cur = 0; cur < s.length(); cur++) {
			if (map.containsKey(s.charAt(cur))) {
				left = Math.max(left, map.get(s.charAt(cur)));
			}
			map.put(s.charAt(cur), cur + 1);
			result = Math.max(result, cur - left + 1);
		}
		return result;
	}
}
