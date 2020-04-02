package com.zgl.leetcode.java.backtracking;

/**
 * @author zgl
 * @date 2020/3/25 下午8:30
 */
public class SurroundedRegions {
	public static void main(String[] args) {
		char[][] board = {{'X', 'X', 'X', 'X'},{'X', 'O', 'O', 'X'},{'X', 'X', 'O', 'X'},{'X', 'O', 'O', 'X'}};
		/*for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}*/
		SurroundedRegions surroundedRegions = new SurroundedRegions();
		surroundedRegions.solve(board);
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}
	}

	/**
	 * 130. Surrounded Regions
	 * Given a 2D board containing 'X' and 'O' (the letter O), capture all regions surrounded by 'X'.
	 *
	 * A region is captured by flipping all 'O's into 'X's in that surrounded region.
	 *
	 * Example:
	 *
	 * X X X X
	 * X O O X
	 * X X O X
	 * X O X X
	 * After running your function, the board should be:
	 *
	 * X X X X
	 * X X X X
	 * X X X X
	 * X O X X
	 */
	public void solve(char[][] board) {
		if (board.length == 0 || board[0].length == 0) {
			return;
		}
		int m = board.length;
		int n = board[0].length;
		for (int i = 0; i < m; i++){
			for (int j = 0; j < n; j++) {
				if ((i == 0 || i == board.length - 1 ||j == 0 || j == board[0].length - 1) && board[i][j] == 'O') {
					dfs(board, i, j);
				}
			}
		}

		/*for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				System.out.print(board[i][i] + " ");
			}
			System.out.println();
		}*/

		for (int i = 0; i < m; i++){
			for (int j = 0; j < n; j++){
				if (board[i][j] == 'O') {
					board[i][j] = 'X';
				}
				if (board[i][j] == '$') {
					board[i][j] = 'O';
				}
			}
		}
		return;

	}

	void dfs(char[][] board, int i, int j){
		if (board[i][j] == 'O'){
			int m = board.length;
			int n = board[0].length;
			board[i][j] = '$';

			if (i > 0 && board[i - 1][j] == 'O'){
				dfs(board, i - 1, j);
			}

			if (i < m - 1 && board[i + 1][j] == 'O'){
				dfs(board, i + 1, j);
			}

			if (j > 0 && board[i][j - 1] == 'O'){
				dfs(board, i, j - 1);
			}

			if (j < n - 1 && board[i][j + 1] == 'O'){
				dfs(board, i, j + 1);
			}
			return;
		}
	}
}