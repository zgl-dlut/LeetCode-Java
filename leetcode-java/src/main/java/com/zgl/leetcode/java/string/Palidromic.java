package com.zgl.leetcode.java.string;

import java.util.ArrayList;
import java.util.List;

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


	/**
	 * 647. Palindromic Substrings
	 * Given a string, your task is to count how many palindromic substrings in this string.
	 *
	 * The substrings with different start indexes or end indexes are counted as different substrings even they consist of same characters.
	 *
	 * Example 1:
	 *
	 * Input: "abc"
	 * Output: 3
	 * Explanation: Three palindromic strings: "a", "b", "c".
	 *
	 *
	 * Example 2:
	 *
	 * Input: "aaa"
	 * Output: 6
	 * Explanation: Six palindromic strings: "a", "a", "a", "aa", "aa", "aaa".
	 */
	public int countSubstrings1(String s) {
		int n = s.length();
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		int[] dp = new int[n];
		dp[0] = 1;
		for (int i = 1; i < n; i++) {
			dp[i] = dp[i - 1];
			for (int j = 0; j <= i; j++) {
				dp[i] += isPalidromic(s, j, i) ? 1 : 0;
			}
		}
		return dp[n - 1];
	}

	//dp
	public int countSubstrings2(String s) {
		int n = s.length();
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		int result = 1;
		for (int i = 1; i < n; i++) {
			for (int j = 0; j <= i; j++) {
				result += isPalidromic(s, j, i) ? 1 : 0;
			}
		}
		return result;
	}

	//中心扩展
	public int countSubstrings(String s) {
		int n = s.length();
		if (n == 0) {
			return 0;
		}
		if (n == 1) {
			return 1;
		}
		int result = 0;
		for (int i = 0; i < n; i++) {
			int left = i, right = i;
			while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
				left--;
				right++;
				result++;
			}
			left = i;
			right = i + 1;
			while (left >= 0 && right < n && s.charAt(left) == s.charAt(right)) {
				left--;
				right++;
				result++;
			}
		}
		return result;
	}

	private boolean isPalidromic(String s, int left, int right) {
		while(left < right) {
			if (s.charAt(left) == s.charAt(right)) {
				left++;
				right--;
			} else {
				return false;
			}
		}
		return true;
	}

	private boolean isPalindromic(String substring) {
		if (substring.length() == 0) {
			return false;
		}
		int left = 0, right = substring.length() - 1;
		while (left < right) {
			if (substring.charAt(left) == substring.charAt(right)) {
				left++;
				right--;
			} else {
				return false;
			}
		}
		return true;
	}

	/**
	 * substring[a,b)左闭右开
	 */
	public static void main(String[] args) {
		String s= "A man, a plan, a canal: Panama";
		Palidromic mock=new Palidromic();
		System.out.println(mock.isPalindrome(s));
	}

	/**
	 * 125. Valid Palindrome
	 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
	 *
	 * Note: For the purpose of this problem, we define empty string as valid palindrome.
	 *
	 * Example 1:
	 *
	 * Input: "A man, a plan, a canal: Panama"
	 * Output: true
	 * Example 2:
	 *
	 * Input: "race a car"
	 * Output: false
	 */
	public boolean isPalindrome(String s) {
		s = s.toLowerCase();
		int left = 0, right = s.length() - 1;
		while (left < right) {
			while (left < right && !judge(s, left)) {
				left++;
			}
			while (left < right && !judge(s, right)) {
				right--;
			}
			if (s.charAt(left) == s.charAt(right)) {
				left++;
				right--;
			} else {
				return false;
			}
		}
		return true;
	}

	private boolean judge(String s, int pos) {
		return (s.charAt(pos) >= 'a'&& s.charAt(pos) <= 'z') || (s.charAt(pos) >= '0' && s.charAt(pos) <= '9');
	}
}
