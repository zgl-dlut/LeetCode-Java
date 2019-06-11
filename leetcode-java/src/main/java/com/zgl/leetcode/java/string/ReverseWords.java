package com.zgl.leetcode.java.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zgl
 * @date 2019/6/11 下午3:52
 */
public class ReverseWords {

	public static void main(String[] args) {
		String s = " ";
		System.out.println(new ReverseWords().reverseWords(s));
	}

	/**
	 * 151. Reverse Words in a String
	 *
	 * Given an input string, reverse the string word by word.
	 * Example 1:
	 *
	 * Input: "the sky is blue"
	 * Output: "blue is sky the"
	 * Example 2:
	 *
	 * Input: "  hello world!  "
	 * Output: "world! hello"
	 * Explanation: Your reversed string should not contain leading or trailing spaces.
	 * Example 3:
	 *
	 * Input: "a good   example"
	 * Output: "example good a"
	 * Explanation: You need to reduce multiple spaces between two words to a single space in the reversed string.
	 */
	public String reverseWords(String s) {
		int length = s.length();
		if (length == 0) {
			return "";
		}
		List<String> list = new ArrayList<>();
		int index = 0;
		String temp;
		while (index < length) {
			while (index < length && s.charAt(index) == ' ') {
				index++;
			}
			temp = "";
			while (index < length && s.charAt(index) != ' ') {
				temp += s.charAt(index);
				index++;
			}
			if (!"".equals(temp)) {
				list.add(temp);
			}
		}
		StringBuilder result = new StringBuilder();
		for (int i = list.size() - 1; i > 0; i--) {
			result.append(list.get(i)).append(" ");
		}
		if (list.size() > 0) {
			result.append(list.get(0));
		}
		return result.toString();
	}
}