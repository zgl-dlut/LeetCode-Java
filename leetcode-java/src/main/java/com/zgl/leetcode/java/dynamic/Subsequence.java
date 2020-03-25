package com.zgl.leetcode.java.dynamic;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zgl
 * @date 2020/3/24 下午2:41
 */
public class Subsequence {
	public static void main(String[] args) {
		String s = "";
		String t = "ahbgdc";
		System.out.println(new Subsequence().isSubsequence(s, t));
	}

	/**
	 * 392. Is Subsequence
	 * Given a string s and a string t, check if s is subsequence of t.
	 *
	 * You may assume that there is only lower case English letters in both s and t. t is potentially a very long (length ~= 500,000) string, and s is a short string (<=100).
	 *
	 * A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ace" is a subsequence of "abcde" while "aec" is not).
	 *
	 * Example 1:
	 * s = "abc", t = "ahbgdc"
	 *
	 * Return true.
	 *
	 * Example 2:
	 * s = "axc", t = "ahbgdc"
	 *
	 * Return false.
	 *
	 * Follow up:
	 * If there are lots of incoming S, say S1, S2, ... , Sk where k >= 1B, and you want to check one by one to see if T has its subsequence. In this scenario, how would you change your code?
	 */
	//贪心算法
	public boolean isSubsequence1(String s, String t) {
		int sLength = s.length(), tLength = t.length();
		int sIdx = 0, tIdx = 0;
		while (tIdx < tLength) {
			if (sIdx < sLength && s.charAt(sIdx) == t.charAt(tIdx)) {
				sIdx++;
				if (sIdx == sLength) {
					return true;
				}
			}
			tIdx++;
		}
		if (sIdx == sLength) {
			return true;
		}
		return false;
	}

	public boolean isSubsequence(String s, String t) {
		int pos = 0;
		if (s.length() == 0) {
			return true;
		}
		for (int i = 0; i < t.length(); i++) {
			if (s.charAt(pos) == t.charAt(i)) {
				pos++;
				if (pos == s.length()) {
					return true;
				}
			}
		}
		return false;
	}
}