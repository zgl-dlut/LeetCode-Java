package com.zgl.leetcode.java.array;

/**
 * LeetCode 28
 *
 * @author zgl
 * @date 2018/11/26 下午7:58
 */

/**
 *Return the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.
 *
 * Example 1:
 *
 * Input: haystack = "hello", needle = "ll"
 * Output: 2
 * Example 2:
 *
 * Input: haystack = "aaaaa", needle = "bba"
 * Output: -1
 */
public class StrStr {
	public int strStr(String haystack, String needle) {
		int i, j;
		if (haystack.length() < needle.length()) {
			return -1;
		} else {
			for (i = j = 0; i < haystack.length() && j < needle.length(); ) {
				if (haystack.charAt(i) == needle.charAt(j)) {
					i++;
					j++;
				} else {
					i = i - j + 1;
					j = 0;
				}
			}
			return j == needle.length() ? i - j : -1;
		}
	}

	public static void main(String[] args) {
		String haystack = "hello";
		String needle = "";
		System.out.println(new StrStr().strStr(haystack,needle));
	}
}
