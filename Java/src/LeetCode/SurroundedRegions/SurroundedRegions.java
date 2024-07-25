package LeetCode.SurroundedRegions;

class SurroundedRegions {
	void solve(char[][] board) {
		int ROWS = board.length, COLS = board[0].length;
		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLS; c++) {
				if (board[r][c] == 'O' && ((0 == r || r == ROWS - 1) || 0 == c || c == COLS - 1)) {
					dfs(board, ROWS, COLS, r, c);
				}
			}
		}
		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLS; c++) {
				if (board[r][c] == 'O') {
					board[r][c] = 'X';
				}
			}
		}
		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLS; c++) {
				if (board[r][c] == 'T') {
					board[r][c] = 'O';
				}
			}
		}
	}

	void dfs(char[][] board, int ROWS, int COLS, int r, int c) {
		if (r < 0 || c < 0 || r == ROWS || c == COLS || board[r][c] != 'O') {
			return;
		}
		board[r][c] = 'T';
		dfs(board, ROWS, COLS, r + 1, c);
		dfs(board, ROWS, COLS, r - 1, c);
		dfs(board, ROWS, COLS, r, c + 1);
		dfs(board, ROWS, COLS, r, c - 1);
	}

	public static void main(String[] args) {
		SurroundedRegions lzr = new SurroundedRegions();
		char[][] board = { { 'X', 'X', 'X', 'X' }, { 'X', 'O', 'O', 'X' }, { 'X', 'X', 'O', 'X' },
				{ 'X', 'O', 'X', 'X' } };
		lzr.solve(board);
		int ROWS = board.length, COLS = board[0].length;
		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLS; c++) {
				System.out.print(board[r][c] + " ");
			}
			System.out.print("\n");
		}
	}
}