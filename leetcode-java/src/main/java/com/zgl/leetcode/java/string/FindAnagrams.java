package com.zgl.leetcode.java.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zgl
 * @date 2019/11/10 下午4:17
 */
public class FindAnagrams {
	public static void main(String[] args) {
		String s = "cbaebabacd", p = "abc";
		System.out.println(new FindAnagrams().findAnagrams(s, p));
	}

	/**
	 * 438. Find All Anagrams in a String
	 * Example 1:
	 *
	 * Input:
	 * s: "cbaebabacd" p: "abc"
	 *
	 * Output:
	 * [0, 6]
	 *
	 * Explanation:
	 * The substring with start index = 0 is "cba", which is an anagram of "abc".
	 * The substring with start index = 6 is "bac", which is an anagram of "abc".
	 * Example 2:
	 *
	 * Input:
	 * s: "abab" p: "ab"
	 *
	 * Output:
	 * [0, 1, 2]
	 *
	 * Explanation:
	 * The substring with start index = 0 is "ab", which is an anagram of "ab".
	 * The substring with start index = 1 is "ba", which is an anagram of "ab".
	 * The substring with start index = 2 is "ab", which is an anagram of "ab".
	 */
	public List<Integer> findAnagrams(String s, String p) {
		List<Integer> result = new ArrayList<>();
		if (s == null || s.length() == 0 || p == null || p.length() == 0) {
			return result;
		}
		int[] hash = new int[256];
		for (char c : p.toCharArray()) {
			hash[c]++;
		}
		int left = 0, right = 0, count = p.length();
		while (right < s.length()) {
			if (hash[s.charAt(right++)]-- > 0) {
				count--;
			}
			if (count == 0) {
				result.add(left);
			}
			if (right - left == p.length() && hash[s.charAt(left++)]++ >= 0) {
				count++;
			}
		}
		return result;

	}
}