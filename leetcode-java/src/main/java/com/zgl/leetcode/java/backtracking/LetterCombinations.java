package com.zgl.leetcode.java.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zgl
 * @date 2019/5/15 下午2:16
 */
public class LetterCombinations {

	/**
	 * 17. Letter Combinations of a Phone Number
	 * <p>
	 * Given a string containing digits from 2-9 inclusive,
	 * return all possible letter combinations that the number could represent.
	 * <p>
	 * A mapping of digit to letters (just like on the telephone buttons) is given below. Note that 1 does not map to any letters.
	 * <p>
	 * Example:
	 * <p>
	 * Input: "23"
	 * Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
	 */
	private String[] table = new String[]{"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

	public List<String> letterCombinations(String digits) {
		List<String> result = new ArrayList<>();
		backtracking(digits, 0, "", result);
		return result;
	}

	private void backtracking(String digits, int index, String current, List<String> result) {
		if (index == digits.length()) {
			if (current.length() != 0) {
				result.add(current);
			}
			return;
		}
		String temp = table[digits.charAt(index) - '0'];
		for (int i = 0; i < temp.length(); i++) {
			String next = current + temp.charAt(i);
			backtracking(digits, index + 1, next, result);
		}
		System.out.println(result);
	}

	public static void main(String[] args) {
		List<String> res = new LetterCombinations().letterCombinations("234");
		System.out.println(res);
	}
}