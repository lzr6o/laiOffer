package LeetCode.UniquePathsIII;

class UniquePathsIII {
	int uniquePathsIII(int[][] grid) {
		int row, col, steps;
		row = col = steps = 0;
		int ROWS = grid.length, COLS = grid[0].length;
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				if (grid[i][j] == 1) {
					row = i;
					col = j;
				}
				if (grid[i][j] == 0) {
					steps++;
				}
			}
		}
		int[] res = new int[1];
		boolean[][] visited = new boolean[ROWS][COLS];
		dfs(grid, visited, ROWS, COLS, row, col, 0, steps, res);
		return res[0];
	}

	void dfs(int[][] grid, boolean[][] visited, int ROWS, int COLS, int r, int c, int step, int steps, int[] res) {
		if (r < 0 || r == ROWS || c < 0 || c == COLS || grid[r][c] == -1 || visited[r][c]) {
			return;
		}
		if (grid[r][c] == 2 && step == steps + 1) {
			res[0]++;
			return;
		}
		visited[r][c] = true;
		dfs(grid, visited, ROWS, COLS, r - 1, c, step + 1, steps, res);
		dfs(grid, visited, ROWS, COLS, r + 1, c, step + 1, steps, res);
		dfs(grid, visited, ROWS, COLS, r, c - 1, step + 1, steps, res);
		dfs(grid, visited, ROWS, COLS, r, c + 1, step + 1, steps, res);
		visited[r][c] = false;
	}

	public static void main(String[] args) {
		UniquePathsIII lzr = new UniquePathsIII();
		int[][] grid = { { 1, 0, 0, 0 }, { 0, 0, 0, 0 }, { 0, 0, 2, -1 } };
		int res = lzr.uniquePathsIII(grid);
		System.out.print(res);
	}
}