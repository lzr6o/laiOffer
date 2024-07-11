package leetcode;
class WordSearch {
	boolean exist(char[][] board, String word) {
		int ROWS = board.length, COLS = board[0].length;
		boolean[][] visited = new boolean[ROWS][COLS];
		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLS; c++) {
				if (dfs(r, c, ROWS, COLS, board, word, visited, 0)) {
					return true;
				}
			}
		}
		return false;
	}

	boolean dfs(int r, int c, int ROWS, int COLS, char[][] board, String word, boolean[][] visited, int idx) {
		if (idx == word.length()) {
			return true;
		}
		if (r < 0 || c < 0 || r >= ROWS || c >= COLS || board[r][c] != word.charAt(idx) || visited[r][c]) {
			return false;
		}
		visited[r][c] = true;
		boolean res = dfs(r - 1, c, ROWS, COLS, board, word, visited, idx + 1)
				|| dfs(r + 1, c, ROWS, COLS, board, word, visited, idx + 1)
				|| dfs(r, c - 1, ROWS, COLS, board, word, visited, idx + 1)
				|| dfs(r, c + 1, ROWS, COLS, board, word, visited, idx + 1);
		visited[r][c] = false;
		return res;
	}

	public static void main(String[] args) {
		WordSearch lzr = new WordSearch();
		char[][] board = { { 'a' } };
		String word = "a";
		boolean res = lzr.exist(board, word);
		System.out.print(res);
	}
}