package leetcode;
class NumberOfIslands {
	int numIslands(char[][] grid) {
		int ROWS = grid.length, COLS = grid[0].length;
		int count = 0;
		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLS; c++) {
				if (grid[r][c] == '1') {
					count++;
					dfs(grid, r, c, ROWS, COLS);
				}
			}
		}
		return count;
	}

	void dfs(char[][] grid, int r, int c, int ROWS, int COLS) {
		if (r < 0 || c < 0 || r == ROWS || c == COLS || grid[r][c] == '0') {
			return;
		}
		grid[r][c] = '0';
		dfs(grid, r - 1, c, ROWS, COLS);
		dfs(grid, r + 1, c, ROWS, COLS);
		dfs(grid, r, c - 1, ROWS, COLS);
		dfs(grid, r, c + 1, ROWS, COLS);
	}

	public static void main(String[] args) {
		NumberOfIslands lzr = new NumberOfIslands();
		char[][] grid = { { '1', '1', '0', '0', '0' }, { '1', '1', '0', '0', '0' }, { '0', '0', '1', '0', '0' },
				{ '0', '0', '0', '1', '1' } };
		int res = lzr.numIslands(grid);
		System.out.print(res);
	}
}
