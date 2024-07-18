package Code;

class MaxAreaOfIsland {
	int maxAreaOfIsland(int[][] grid) {
		int ROWS = grid.length, COLS = grid[0].length;
		int area = 0;
		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLS; c++) {
				if (grid[r][c] == 1) {
					area = Math.max(area, dfs(grid, r, c, ROWS, COLS));
				}
			}
		}
		return area;
	}

	int dfs(int[][] grid, int r, int c, int ROWS, int COLS) {
		if (r < 0 || c < 0 || r == ROWS || c == COLS || grid[r][c] == 0) {
			return 0;
		}
		grid[r][c] = 0;
		return (1 + dfs(grid, r - 1, c, ROWS, COLS) + dfs(grid, r + 1, c, ROWS, COLS) + dfs(grid, r, c - 1, ROWS, COLS)
				+ dfs(grid, r, c + 1, ROWS, COLS));
	}

	public static void main(String[] args) {
		MaxAreaOfIsland lzr = new MaxAreaOfIsland();
		int[][] grid = { { 1, 1, 0, 0, 0 }, { 1, 1, 0, 0, 0 }, { 0, 0, 1, 0, 0 }, { 0, 0, 0, 1, 1 } };
		int res = lzr.maxAreaOfIsland(grid);
		System.out.print(res);
	}
}