package leetcode;
class NumberOfIncreasingPathsInAGrid {
	int countPaths(int[][] grid) {
		int ROWS = grid.length, COLS = grid[0].length;
		int[][] path = new int[ROWS][COLS];
		int res = 0, mod = (int) Math.pow(10, 9) + 7;
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				res = (res % mod + dfs(grid, ROWS, COLS, i, j, mod, -1, path) % mod) % mod;
			}
		}
		return res;
	}

	int dfs(int[][] grid, int ROWS, int COLS, int r, int c, int mod, int pre, int[][] path) {
		if (r < 0 || r == ROWS || c < 0 || c == COLS || grid[r][c] <= pre) {
			return 0;
		}
		if (path[r][c] != 0) {
			return path[r][c];
		}
		int step = 1;
		step += dfs(grid, ROWS, COLS, r + 1, c, mod, grid[r][c], path);
		step += dfs(grid, ROWS, COLS, r - 1, c, mod, grid[r][c], path);
		step += dfs(grid, ROWS, COLS, r, c + 1, mod, grid[r][c], path);
		step += dfs(grid, ROWS, COLS, r, c - 1, mod, grid[r][c], path);
		path[r][c] = step % mod;
		return path[r][c];
	}

	public static void main(String[] args) {
		NumberOfIncreasingPathsInAGrid lzr = new NumberOfIncreasingPathsInAGrid();
		int[][] grid = { { 1, 1 }, { 3, 4 } };
		int res = lzr.countPaths(grid);
		System.out.print(res);
	}
}