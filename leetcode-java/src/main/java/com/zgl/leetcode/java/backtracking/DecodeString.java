package com.zgl.leetcode.java.backtracking;

/**
 * @author zgl
 * @date 2019/11/6 下午5:20
 */
public class DecodeString {
	/**
	 * 394. Decode String
	 * s = "3[a]2[bc]", return "aaabcbc".
	 * s = "3[a2[c]]", return "accaccacc".
	 * s = "2[abc]3[cd]ef", return "abcabccdcdcdef".
	 */

	//java采用值传递,因此需要一个全局变量
	private int i = 0;

	public static void main(String[] args) {
		String s = "2[abc]3[cd]ef";
		System.out.println(new DecodeString().decodeString(s));
	}

	public String decodeString(String s) {
		return decode(s, new StringBuilder());
	}

	private String decode(String s, StringBuilder stringBuilder) {
		int n = s.length();
		while (i < n && s.charAt(i) != ']') {
			if (s.charAt(i) < '0' || s.charAt(i) > '9') {
				stringBuilder.append(s.charAt(i++));
			} else {
				int count = 0;
				while (s.charAt(i) >= '0' && s.charAt(i) <= '9') {
					count = count * 10 + s.charAt(i++) - '0';
				}
				//跳过下一个'['
				i++;
				String subResult = decode(s, new StringBuilder());
				//跳过下一个']'
				i++;
				while (count > 0) {
					stringBuilder.append(subResult);
					count--;
				}
			}
		}
		return stringBuilder.toString();

	}
}