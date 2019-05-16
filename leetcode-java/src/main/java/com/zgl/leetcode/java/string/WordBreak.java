package com.zgl.leetcode.java.string;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author zgl
 * @date 2019/5/16 下午2:31
 */
public class WordBreak {

	/**
	 * 139. Word Break
	 *
	 *
	 * Given a non-empty string s and a dictionary wordDict containing a list of non-empty words,
	 * determine if s can be segmented into a space-separated sequence of one or more dictionary words.
	 *
	 * Note:
	 *
	 * The same word in the dictionary may be reused multiple times in the segmentation.
	 * You may assume the dictionary does not contain duplicate words.
	 * Example 1:
	 *
	 * Input: s = "leetcode", wordDict = ["leet", "code"]
	 * Output: true
	 * Explanation: Return true because "leetcode" can be segmented as "leet code".
	 * Example 2:
	 *
	 * Input: s = "applepenapple", wordDict = ["apple", "pen"]
	 * Output: true
	 * Explanation: Return true because "applepenapple" can be segmented as "apple pen apple".
	 *              Note that you are allowed to reuse a dictionary word.
	 * Example 3:
	 *
	 * Input: s = "catsandog", wordDict = ["cats", "dog", "sand", "and", "cat"]
	 * Output: false
	 */
	public boolean wordBreak1(String s, List<String> wordDict) {
		if (wordDict.contains(s)) {
			return true;
		}
		/**
		 * s.substring(a, b)表示的是[a, b)的子串, tag数组下标从1开始算(与字符串的第几位相对应)
		 * dp[i]表示substring(0, i)在字典中存在,分为0~j和j~i两部分
		 */
		boolean[] dp = new boolean[s.length() + 1];
		dp[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (dp[j] && wordDict.contains(s.substring(j, i))) {
					dp[i] = true;
					break;
				}
			}
		}
		return dp[s.length()];
	}

	/**
	 * 140. Word Break II
	 * Example 1:
	 *
	 * Input:
	 * s = "catsanddog"
	 * wordDict = ["cat", "cats", "and", "sand", "dog"]
	 * Output:
	 * [
	 *   "cats and dog",
	 *   "cat sand dog"
	 * ]
	 * Example 2:
	 *
	 * Input:
	 * s = "pineapplepenapple"
	 * wordDict = ["apple", "pen", "applepen", "pine", "pineapple"]
	 * Output:
	 * [
	 *   "pine apple pen apple",
	 *   "pineapple pen apple",
	 *   "pine applepen apple"
	 * ]
	 * Explanation: Note that you are allowed to reuse a dictionary word.
	 * Example 3:
	 *
	 * Input:
	 * s = "catsandog"
	 * wordDict = ["cats", "dog", "sand", "and", "cat"]
	 * Output:
	 * []
	 */
	public List<String> wordBreak2(String s, List<String> wordDict) {
		Long start = System.currentTimeMillis();
		List<String> result = new ArrayList<>();
		backtracking(s, wordDict, 0, "", result);
		Long end = System.currentTimeMillis();
		System.out.println("消耗时长:" + (end - start) + "ms");
		return result;
	}
	private void backtracking(String s, List<String> workDict, int index, String answer, List<String> result){
		if (index == s.length()){
			result.add(answer);
			return;
		}
		StringBuilder sb = new StringBuilder();
		for (int i = index; i < s.length(); i++){
			sb.append(s.charAt(i));
			if (workDict.contains(sb.toString())){
				String newAnswer = answer.length() > 0 ? (answer + " " + sb.toString()) : sb.toString();
				/**
				 * 传了一个新的answer参数,所以不需要还原现场
				 */
				backtracking(s, workDict, i + 1, newAnswer, result);
			}
		}
	}

	/**
	 * dp + dfs(backtracking)
	 */
	public List<String> wordBreak(String s, List<String> wordDict) {
		Long start = System.currentTimeMillis();
		boolean[] dp = new boolean[s.length() + 1];
		/*dp[0] = true;
		for (int i = 1; i <= s.length(); i++) {
			for (int j = 0; j < i; j++) {
				if (wordDict.contains(s.substring(j, i)) && dp[j]) {
					dp[i] = true;
					break;
				}
			}
		}*/
		dp[s.length()] = true;
		for (int i = s.length() - 1; i >= 0; --i) {
			for (int j = i; j < s.length(); ++j) {
				if (wordDict.contains(s.substring(i, j + 1)) && dp[j + 1]) {
					dp[i] = true;
					break;
				}
			}
		}
		List<String> result = new ArrayList<>();
		helper(s, wordDict, new StringBuilder(), 0, dp, result);
		Long end = System.currentTimeMillis();
		System.out.println("消耗时长:" + (end - start) + "ms");
		return result;
	}
	private void helper(String s, List<String> workDict, StringBuilder answer, int index, boolean[] dp, List<String> result){
		if (index == s.length()){
			result.add(answer.toString());
			return;
		}
		for (int i = index; i < s.length(); i++){
			String sub = s.substring(index, i + 1);
			if (!workDict.contains(sub)){
				continue;
			}
			if (!dp[i + 1]){
				continue;
			}
			int answerLength = answer.length();
			//answer = answerLength > 0 ? answer.append(" ").append(sub) : answer.append(sub);
			if (answerLength > 0){
				answer.append(" ");
			}
			answer.append(sub);
			helper(s, workDict, answer, i + 1, dp, result);
			/**
			 * 恢复现场
			 */
			answer.setLength(answerLength);
		}
	}

	public static void main(String[] args) {
		String s = "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaabaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" ;
		List<String> wordDict = Arrays.asList("a", "aa", "aaa", "aaaa", "aaaaa", "aaaaaa", "aaaaaaa", "aaaaaaaa", "aaaaaaaaa", "aaaaaaaaaa");
		System.out.println(new WordBreak().wordBreak(s, wordDict));
	}
}