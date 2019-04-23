package com.zgl.leetcode.java.string;

import java.util.Arrays;

/**
 * @author zgl
 * @date 2019/4/23 上午10:58
 */
public class LengthOfLastWord {

	/**
	 * 58. Length of Last Word
	 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
	 * return the length of last word in the string.
	 *
	 * If the last word does not exist, return 0.
	 *
	 * Note: A word is defined as a character sequence consists of non-space characters only.
	 *
	 * Example:
	 *
	 * Input: "Hello World"
	 * Output: 5
	 */
	public int lengthOfLastWord(String s) {
		String[] words = s.split(" ");
		if(words.length == 0){
			return 0;
		}
		return words[words.length-1].length();
	}

	public static void main(String[] args) {
		String s = "  ";
		System.out.println(new LengthOfLastWord().lengthOfLastWord(s));
	}
}