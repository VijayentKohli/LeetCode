package com.iamvkohli.leetcode.medium;

public class GameOfLife_289 {

	int numRows;
	int numCols;

	public boolean isSafe(int row, int col) {
		if (row >= 0 && row < numRows && col >= 0 && col < numCols)
			return true;
		return false;
	}

	public int countLive(int[][] board, int r, int c) {
		int[] dirX = { -1, -1, -1, 0, 1, 1, 1, 0 };
		int[] dirY = { -1, 0, 1, 1, 1, 0, -1, -1 };

		int count = 0;
		for (int i = 0; i < 8; i++) {
			int row = r + dirX[i];
			int col = c + dirY[i];
			if (isSafe(row, col)) {
				if (board[row][col] == 1 || board[row][col] < 0)
					count++;
			}
		}
		return count;
	}

	public void gameOfLife(int[][] board) {
		numRows = board.length;
		numCols = board[0].length;

		// int[][] grid = board.clone();
		// int[][] grid = new int[numRows][numCols];

//      for(int i=0; i<board.length; i++)
//          for(int j=0; j<board[i].length; j++)
//              grid[i][j]=board[i][j];

		for (int i = 0; i < numRows; i++) {
			for (int j = 0; j < numCols; j++) {

				int zinda = countLive(board, i, j);
				System.out.println("row=" + i + "\tCol=" + j + "\tNeighbours=" + zinda);

				if (board[i][j] == 1) {
					if (zinda < 2 || zinda > 3)
						board[i][j] = -1;
					else if (zinda == 2 || zinda == 3) {
						board[i][j] = 1;
					}
				} else if (zinda == 3) {
					board[i][j] = 2;
				}
			}
		}

		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[i].length; j++) {
				if (board[i][j] <= 0) {
					board[i][j] = 0;
				} else
					board[i][j] = 1;
			}
		}

		System.out.println(board);
	}
}