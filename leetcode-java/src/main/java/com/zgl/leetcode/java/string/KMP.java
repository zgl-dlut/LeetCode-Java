package com.zgl.leetcode.java.string;

/**
 * @author zgl
 * @date 2019/10/29 下午5:33
 */
public class KMP {
	public int force(String s, String p) {
		int sLen = s.length();
		int pLen = p.length();
		int i = 0, j = 0;
		while (i < sLen && j < pLen) {
			if (s.charAt(i) == p.charAt(j)) {
				i++;
				j++;
			} else {
				i = i - j + 1;
				j = 0;
			}
		}
		if (j == pLen) {
			return i - j;
		} else {
			return -1;
		}
	}
}