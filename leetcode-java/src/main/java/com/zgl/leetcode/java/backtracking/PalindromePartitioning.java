package com.zgl.leetcode.java.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zgl
 * @date 2019/5/28 下午1:50
 */
public class PalindromePartitioning {

	/**
	 * 131. Palindrome Partitioning
	 *
	 * Given a string s, partition s such that every substring of the partition is a palindrome.
	 *
	 * Return all possible palindrome partitioning of s.
	 *
	 * Example:
	 *
	 * Input: "aab"
	 * Output:
	 * [
	 *   ["aa","b"],
	 *   ["a","a","b"]
	 * ]
	 */
	public List<List<String>> partition(String s) {
		List<String> answer = new ArrayList<>();
		List<List<String>> result = new ArrayList<>();
		backtracking(answer, result, 0, s);
		return result;
	}

	private void backtracking(List<String> answer, List<List<String>> result, int start, String s) {
		if (start == s.length()) {
			result.add(new ArrayList<>(answer));
			return;
		}
		for (int i = start; i < s.length(); i++) {
			if (!isPalindrome(s, start, i)) {
				continue;
			}
			answer.add(s.substring(start, i + 1));
			backtracking(answer, result, i + 1, s);
			answer.remove(answer.size() - 1);
		}
	}

	private boolean isPalindrome(String s, int start, int end) {
		while (start < end) {
			if (s.charAt(start) == s.charAt(end)) {
				start++;
				end--;
			} else {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		String s = "hello";
		System.out.println(s.substring(1, 3));
	}
}