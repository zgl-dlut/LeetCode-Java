package com.zgl.leetcode.java.interview.bianlifeng;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zgl
 * @date 2020/4/24 下午3:51
 */
public class LetterCasePermutation {
	/**
	 * 784. Letter Case Permutation
	 * >输入: str = "a1b2"<br/>
	 * >输出: ["a1b2", "a1B2", "A1b2", "A1B2"]
	 * <p>
	 * >输入: str = "3z4"<br/>
	 * >输出: ["3z4", "3Z4"]
	 * <p>
	 * >输入: str = "12345"<br/>
	 * >输出: ["12345"]
	 */
	public List<String> letterCasePermutation(String str) {
		List<String> result = new ArrayList<>();
		backtracking(str.toCharArray(), 0, result);
		return result;
	}

	private void backtracking(char[] charArray, int start, List<String> result) {
		if (start == charArray.length) {
			result.add(new String(charArray));
		} else {
			if (Character.isDigit(charArray[start])) {
				backtracking(charArray, start + 1, result);
			} else {
				charArray[start] = Character.toLowerCase(charArray[start]);
				backtracking(charArray, start + 1, result);
				charArray[start] = Character.toUpperCase(charArray[start]);
				backtracking(charArray, start + 1, result);
			}
		}
	}

	public static void main(String[] args) {
		String str = "a1b2";
		System.out.println(new LetterCasePermutation().letterCasePermutation(str));
	}
}