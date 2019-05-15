package com.zgl.leetcode.java.backtracking;

import java.util.List;

/**
 * @author zgl
 * @date 2019/5/15 下午2:52
 */
public class WordSearch {

	/**
	 * 79. Word Search
	 *
	 * Given a 2D board and a word, find if the word exists in the grid.
	 *
	 * The word can be constructed from letters of sequentially adjacent cell,
	 * where "adjacent" cells are those horizontally or vertically neighboring.
	 * The same letter cell may not be used more than once.
	 *
	 * Example:
	 *
	 * board =
	 * [
	 *   ['A','B','C','E'],
	 *   ['S','F','C','S'],
	 *   ['A','D','E','E']
	 * ]
	 *
	 * Given word = "ABCCED", return true.
	 * Given word = "SEE", return true.
	 * Given word = "ABCB", return false.
	 */
	public boolean exist(char[][] board, String word) {
		for (int x = 0; x < board.length; x++) {
			for (int y = 0; y < board[0].length; y++) {
				if (backtracking(board, word, x, y, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean backtracking(char[][] board, String word, int x, int y, int index) {
		if (index == word.length()) {
			return true;
		}
		if (x >= board.length || x < 0 || y >= board[0].length || y < 0 || board[x][y] != word.charAt(index)) {
			return false;
		}
		board[x][y] ^= 128;
		boolean flag = backtracking(board, word, x + 1, y, index + 1) ||
				backtracking(board, word, x - 1, y, index + 1) ||
				backtracking(board, word, x, y + 1, index + 1) ||
				backtracking(board, word, x, y - 1, index + 1);
		board[x][y] ^= 128;
		return flag;
	}

	/**
	 * 212. Word Search II
	 *
	 * Given a 2D board and a list of words from the dictionary, find all words in the board.
	 *
	 * Each word must be constructed from letters of sequentially adjacent cell,
	 * where "adjacent" cells are those horizontally or vertically neighboring.
	 * The same letter cell may not be used more than once in a word.
	 *
	 *
	 *
	 * Example:
	 *
	 * Input:
	 * board = [
	 *   ['o','a','a','n'],
	 *   ['e','t','a','e'],
	 *   ['i','h','k','r'],
	 *   ['i','f','l','v']
	 * ]
	 * words = ["oath","pea","eat","rain"]
	 *
	 * Output: ["eat","oath"]
	 */
	public List<String> findWords(char[][] board, String[] words) {
		return null;
	}
}