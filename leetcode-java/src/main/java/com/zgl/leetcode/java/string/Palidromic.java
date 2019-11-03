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
	private String result = "";

	/**
	 * substring[a,b)左闭右开
	 */
	public static void main(String[] args) {
		String s="a";
		System.out.println(s.substring(0, 1));
		Palidromic mock=new Palidromic();
		System.out.println(mock.longestPalindrome1(s));
	}

	public String longestPalindrome1(String s) {
		if (s.length() < 2) {
			return result;
		}
		for (int i = 0; i < s.length(); i++) {
			helper(s, i, i);
			helper(s, i, i + 1);
		}
		return result;
	}

	private void helper(String s, int left, int right) {
		while(left >= 0 && right < s.length()) {
			if (s.charAt(left) != s.charAt(right)) {
				break;
			} else {
				left--;
				right++;
			}
		}
		result = result.length() >= s.substring(left + 1, right).length() ? result : s.substring(left + 1, right);
	}

	/**
	 * 516. Longest Palindromic Subsequence
	 * Given a string s, find the longest palindromic subsequence's length in s. You may assume that the maximum length of s is 1000.
	 *
	 * Example 1:
	 * Input:
	 *
	 * "bbbab"
	 * Output:
	 * 4
	 * One possible longest palindromic subsequence is "bbbb".
	 * Example 2:
	 * Input:
	 *
	 * "cbbd"
	 * Output:
	 * 2
	 */
	public int longestPalindromeSubseq(String s) {
		int n = s.length();
		int[][] dp = new int[n][n];
		for (int i = n - 1; i >= 0; i--) {
			dp[i][i] = 1;
			for (int j = i + 1; j < n; j++) {
				if (s.charAt(i) == s.charAt(j)) {
					dp[i][j] = dp[i + 1][j - 1] + 2;
				} else {
					dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[0][n - 1];
	}
}
