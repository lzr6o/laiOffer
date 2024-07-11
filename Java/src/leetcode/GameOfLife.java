package leetcode;

class GameOfLife {
	void gameOfLife(int[][] board) {
		int ROWS = board.length, COLS = board[0].length;
		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLS; c++) {
				int nei = countNeighbors(r, c, ROWS, COLS, board);
				if (board[r][c] == 1) {
					if (nei == 2 || nei == 3) {
						board[r][c] = 3;
					}
				} else if (nei == 3) {
					board[r][c] = 2;
				}
			}
		}
		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLS; c++) {
				if (board[r][c] == 1) {
					board[r][c] = 0;
				} else if (board[r][c] == 2 || board[r][c] == 3) {
					board[r][c] = 1;
				}
			}
		}
	}

	int countNeighbors(int r, int c, int ROWS, int COLS, int[][] board) {
		int nei = 0;
		for (int i = r - 1; i < r + 2; i++) {
			for (int j = c - 1; j < c + 2; j++) {
				if ((i == r && j == c) || i < 0 || j < 0 || i == ROWS || j == COLS) {
					continue;
				}
				if (board[i][j] == 1 || board[i][j] == 3) {
					nei++;
				}
			}
		}
		return nei;
	}

	public static void main(String[] args) {
		GameOfLife lzr = new GameOfLife();
		int[][] board = { { 0, 1, 0 }, { 0, 0, 1 }, { 1, 1, 1 }, { 0, 0, 0 } };
		lzr.gameOfLife(board);
		int ROWS = board.length, COLS = board[0].length;
		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLS; c++) {
				System.out.print(board[r][c] + " ");
			}
			System.out.print("\n");
		}
	}
}