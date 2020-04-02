package com.zgl.leetcode.java.datastructure;

import java.util.*;

/**
 * @author zgl
 * @date 2020/3/25 下午6:56
 */
public class WordLadder {
	public static void main(String[] args) {
		String beginWord = "hit";
		String endWord = "hog";
		List<String> wordList = Arrays.asList("hot","hog");
		System.out.println(new WordLadder().ladderLength(beginWord, endWord, wordList));
	}

	/**
	 * 127. Word Ladder
	 * Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:
	 *
	 * Only one letter can be changed at a time.
	 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
	 * Note:
	 *
	 * Return 0 if there is no such transformation sequence.
	 * All words have the same length.
	 * All words contain only lowercase alphabetic characters.
	 * You may assume no duplicates in the word list.
	 * You may assume beginWord and endWord are non-empty and are not the same.
	 * Example 1:
	 *
	 * Input:
	 * beginWord = "hit",
	 * endWord = "cog",
	 * wordList = ["hot","dot","dog","lot","log","cog"]
	 *
	 * Output: 5
	 *
	 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
	 * return its length 5.
	 * Example 2:
	 *
	 * Input:
	 * beginWord = "hit"
	 * endWord = "cog"
	 * wordList = ["hot","dot","dog","lot","log"]
	 *
	 * Output: 0
	 *
	 * Explanation: The endWord "cog" is not in wordList, therefore no possible transformation.
	 */
	public int ladderLength(String beginWord, String endWord, List<String> wordList) {
		if (!wordList.contains(endWord)) {
			return 0;
		}
		int result = 1;
		Set<String> set = new HashSet<>();
		Queue<String> queue = new LinkedList<>();
		queue.offer(beginWord);
		while (!queue.isEmpty()) {
			int n = queue.size();
			while (n-- > 0) {
				String top = queue.poll();
				for (String s : wordList) {
					if (getDifference(top, s)) {
						if (!set.contains(s)) {
							if (endWord.equals(s)) {
								return result + 1;
							}
							set.add(s);
							queue.offer(s);
						}
 					}
				}
			}
			result++;
		}
		return 0;
	}

	private boolean getDifference(String a, String b) {
		int count = 0;
		int i = 0;
		while (i < a.length()) {
			if (a.charAt(i) != b.charAt(i)) {
				count++;
			}
			i++;
		}
		return count == 1;
	}
}