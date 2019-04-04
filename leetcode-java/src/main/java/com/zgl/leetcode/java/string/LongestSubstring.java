package com.zgl.leetcode.java.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zgl
 * @date 2018/12/8 下午4:25
 */
public class LongestSubstring {
	/**
	 * 3. Longest Substring Without Repeating Characters
	 * Given a string, find the length of the longest substring without repeating characters.
	 *
	 * Example 1:
	 *
	 * Input: "abcabcbb"
	 * Output: 3
	 * Explanation: The answer is "abc", with the length of 3.
	 * Example 2:
	 *
	 * Input: "bbbbb"
	 * Output: 1
	 * Explanation: The answer is "b", with the length of 1.
	 * Example 3:
	 *
	 * Input: "pwwkew"
	 * Output: 3
	 * Explanation: The answer is "wke", with the length of 3.
	 *              Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
	 */
	public int lengthOfLongestSubstring(String s) {
		if (s.length() == 0) {
			return 0;
		}
		int[] dp = new int[256];
		Arrays.fill(dp, -1);
		int result = 1, left = -1;
		for (int i = 0; i < s.length(); i++) {
			left = Math.max(left, dp[s.charAt(i)]);
			dp[s.charAt(i)] = i;
			result = Math.max(result, i - left);
		}
		return result;
	}


	public static void main(String[] args) {
		/*String s="abba";
		LongestSubstring mock=new LongestSubstring();
		System.out.println(s.length());
		System.out.println(mock.lengthOfLongestSubstring(s));*/
		int i,tag,plat;
		List<Integer> platform=new ArrayList<>();
		i=1;
		tag=1;
		plat=63;
		for(;i<=6;i++){
			if((plat&tag)==tag){
				platform.add(tag);
			}
			tag=tag<<1;
		}
		for(int j:platform){
			System.out.println(j);
		}
	}
}
