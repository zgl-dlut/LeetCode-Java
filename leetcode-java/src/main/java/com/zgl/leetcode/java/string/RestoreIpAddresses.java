package com.zgl.leetcode.java.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zgl
 * @date 2019/6/10 下午8:17
 */
public class RestoreIpAddresses {

	public static void main(String[] args) {
		String s = "25525511135";
		System.out.println(new RestoreIpAddresses().restoreIpAddresses(s));
		System.out.println(s.substring(1));
	}

	/**
	 * 93. Restore IP Addresses
	 * Given a string containing only digits, restore it by returning all possible valid IP address combinations.
	 *
	 * Example:
	 *
	 * Input: "25525511135"
	 * Output: ["255.255.11.135", "255.255.111.35"]
	 */
	public List<String> restoreIpAddresses1(String s) {
		int length = s.length();
		List<String> result = new ArrayList<>();
		for (int i = 1; i < 4 && i < length - 2; i++) {
			for (int j = i + 1; j < i + 4 && j < length - 1; j++) {
				for (int k = j + 1; k < j + 4 && k < length; k++) {
					String first = s.substring(0, i);
					String second = s.substring(i, j);
					String third = s.substring(j, k);
					String forth = s.substring(k, length);
					boolean tag = isValid(first) && isValid(second) && isValid(third) && isValid(forth);
					if (tag) {
						String answer = first + "." + second + "." + third + "." + forth;
						result.add(answer);
					}
				}
			}
		}
		return result;
	}

	private boolean isValid(String str) {
		if (str.length() > 3 || str.length() == 0 || (str.charAt(0) == '0') && str.length() > 1 || Integer.valueOf(str) > 255) {
			return false;
		}
		return true;
	}

	public List<String> restoreIpAddresses(String s) {
		List<String> result = new ArrayList<>();
		if (s.length() < 4 || s.length() > 12) {
			return result;
		}
		backtracking(s, "", result, 1);
		return result;
	}

	private void backtracking(String s, String answer, List<String> result, int index) {

		if (index == 4 && valid(s)) {
			result.add(answer + s);
			return;
		}
		for (int i = 1; i < Math.min(4, s.length()); i++) {
			String substring = s.substring(0, i);
			if (valid(substring)) {
				backtracking(s.substring(i), answer + substring + ".", result, index + 1);
			}
		}
	}

	private boolean valid(String substring) {
		if (substring.charAt(0) == '0') {
			return "0".equals(substring);
		}
		return Integer.parseInt(substring) <= 255;
	}
}