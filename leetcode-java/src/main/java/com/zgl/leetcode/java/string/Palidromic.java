package com.zgl.leetcode.java.string;

/**
 * @author zgl
 * @date 2018/12/11 下午3:39
 */
public class Palidromic {
	/**
	 * 5. Longest Palindromic Substring
	 * Given a string s, find the longest palindromic substring in s. You may assume that the maximum length of s is 1000.
	 *
	 * Example 1:
	 *
	 * Input: "babad"
	 * Output: "bab"
	 * Note: "aba" is also a valid answer.
	 * Example 2:
	 *
	 * Input: "cbbd"
	 * Output: "bb"
	 */
	public String longestPalindrome(String s) {
		if (s.length() <= 1) {
			return s;
		}
		String result = "";
		int left, right;
		for (int i = 0; i < s.length(); i++) {
			left = i;
			right = i;
			String temp = getCurrentPalindrome(s, left, right);
			if (temp.length() > result.length()) {
				result = temp;
			}
			right = i + 1;
			temp = getCurrentPalindrome(s, left, right);
			if (temp.length() > result.length()) {
				result = temp;
			}
		}
		return result;
	}

	public String getCurrentPalindrome(String s, int left, int right) {
		while (left >= 0 && right < s.length()) {
			if (s.charAt(left) != s.charAt(right)) {
				break;
			} else {
				left--;
				right++;
			}
		}
		return s.substring(left + 1, right);
	}

	/**
	 * 理解错了——回文序列（求出的是首位相同的最长子串）
	 */
	public String longestPalindromeWrong(String s){
		if(s.length()==0||s.length()==1){
			return s;
		}
		int[]dp=new int[s.length()];
		int maxTag=0,max=0;
		for(int i=0,tag=i;i<s.length();i++){
			for (int j=i+1;j<s.length();j++){
				if(s.charAt(j)==s.charAt(i)){
					tag=j;
				}
			}
			dp[i]=tag-i+1;
			if(max<tag-i){
				max=tag-i;
				maxTag=i;
			}
		}
		return s.substring(maxTag,dp[maxTag]+maxTag);
	}

	/**
	 * substring[a,b)左闭右开
	 */
	public static void main(String[] args) {
		String s="babad";
		Palidromic mock=new Palidromic();
		System.out.println(mock.longestPalindrome(s));
	}
}
