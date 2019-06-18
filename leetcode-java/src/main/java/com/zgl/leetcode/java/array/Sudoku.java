package com.zgl.leetcode.java.array;

import java.util.HashSet;
import java.util.Set;

/**
 * 数独
 * @author zgl
 * @date 2019/6/18 上午11:02
 */
public class Sudoku {

	/**
	 * 36. Valid Sudoku
	 * Determine if a 9x9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
	 *
	 * Each row must contain the digits 1-9 without repetition.
	 * Each column must contain the digits 1-9 without repetition.
	 * Each of the 9 3x3 sub-boxes of the grid must contain the digits 1-9 without repetition.
	 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
	 *
	 * Example 1:
	 *
	 * Input:
	 * [
	 *   ["5","3",".",".","7",".",".",".","."],
	 *   ["6",".",".","1","9","5",".",".","."],
	 *   [".","9","8",".",".",".",".","6","."],
	 *   ["8",".",".",".","6",".",".",".","3"],
	 *   ["4",".",".","8",".","3",".",".","1"],
	 *   ["7",".",".",".","2",".",".",".","6"],
	 *   [".","6",".",".",".",".","2","8","."],
	 *   [".",".",".","4","1","9",".",".","5"],
	 *   [".",".",".",".","8",".",".","7","9"]
	 * ]
	 * Output: true
	 * Example 2:
	 *
	 * Input:
	 * [
	 *   ["8","3",".",".","7",".",".",".","."],
	 *   ["6",".",".","1","9","5",".",".","."],
	 *   [".","9","8",".",".",".",".","6","."],
	 *   ["8",".",".",".","6",".",".",".","3"],
	 *   ["4",".",".","8",".","3",".",".","1"],
	 *   ["7",".",".",".","2",".",".",".","6"],
	 *   [".","6",".",".",".",".","2","8","."],
	 *   [".",".",".","4","1","9",".",".","5"],
	 *   [".",".",".",".","8",".",".","7","9"]
	 * ]
	 * Output: false
	 * Explanation: Same as Example 1, except with the 5 in the top left corner being
	 *     modified to 8. Since there are two 8's in the top left 3x3 sub-box, it is invalid.
	 * Note:
	 *
	 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
	 * Only the filled cells need to be validated according to the mentioned rules.
	 * The given board contain only digits 1-9 and the character '.'.
	 * The given board size is always 9x9.
	 */
	public boolean isValidSudoku(char[][] board) {
		for (int i = 0; i < 9; i++) {
			Set<Character> row = new HashSet<>();
			Set<Character> column = new HashSet<>();
			Set<Character> cube = new HashSet<>();
			for (int j = 0; j < 9; j++) {
				if (board[i][j] != '.' && !row.add(board[i][j])) {
					return false;
				}
				if (board[j][i] != '.' && !column.add(board[j][i])) {
					return false;
				}
				int rowIndex = 3 * (i / 3) + j % 3;
				int columnIndex = 3 * (i % 3) + j / 3;
				if (board[rowIndex][columnIndex] != '.' && !cube.add(board[rowIndex][columnIndex])) {
					return false;
				}
			}
		}
		return true;
	}
}