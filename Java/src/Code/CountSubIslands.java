package Code;

class CountSubIslands {

	int countSubIslands(int[][] grid1, int[][] grid2) {
		int ROWS = grid1.length, COLS = grid1[0].length;
		boolean[][] visited = new boolean[ROWS][COLS];
		int cnt = 0;
		for (int r = 0; r < ROWS; r++) {
			for (int c = 0; c < COLS; c++) {
				if (grid2[r][c] == 1 && !visited[r][c] && dfs(r, c, ROWS, COLS, grid1, grid2, visited)) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	boolean dfs(int r, int c, int ROWS, int COLS, int[][] grid1, int[][] grid2, boolean[][] visited) {
		if (r < 0 || c < 0 || r == ROWS || c == COLS || grid2[r][c] == 0 || visited[r][c]) {
			return true;
		}
		visited[r][c] = true;
		boolean valid = true;
		if (grid1[r][c] == 0) {
			valid = false;
		}
		valid &= dfs(r - 1, c, ROWS, COLS, grid1, grid2, visited);
		valid &= dfs(r + 1, c, ROWS, COLS, grid1, grid2, visited);
		valid &= dfs(r, c - 1, ROWS, COLS, grid1, grid2, visited);
		valid &= dfs(r, c + 1, ROWS, COLS, grid1, grid2, visited);
		return valid;
	}

	public static void main(String[] args) {
		CountSubIslands lzr = new CountSubIslands();
		int[][] grid1 = { { 1, 1, 1, 0, 0 }, { 0, 1, 1, 1, 1 }, { 0, 0, 0, 0, 0 }, { 1, 0, 0, 0, 0 }, { 1, 1, 0, 1, 1 } };
		int[][] grid2 = { { 1, 1, 1, 0, 0 }, { 0, 0, 1, 1, 1 }, { 0, 1, 0, 0, 0 }, { 1, 0, 1, 1, 0 }, { 0, 1, 0, 1, 0 } };
		int res = lzr.countSubIslands(grid1, grid2);
		System.out.print(res);
	}
}