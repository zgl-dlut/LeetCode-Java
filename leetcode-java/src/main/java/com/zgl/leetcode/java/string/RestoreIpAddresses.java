package com.zgl.leetcode.java.string;

import java.util.ArrayList;
import java.util.List;

/**
 * @author zgl
 * @date 2019/6/10 下午8:17
 */
public class RestoreIpAddresses {

	public static void main(String[] args) {
		String s = "0000";
		System.out.println(new RestoreIpAddresses().restoreIpAddresses(s));
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
	public List<String> restoreIpAddresses(String s) {
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
}