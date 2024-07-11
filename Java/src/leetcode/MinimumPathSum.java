package leetcode;
class MinimumPathSum {

	int minPathSum(int[][] grid) {
		int ROWS = grid.length, COLS = grid[0].length;
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				if (i != 0 || j != 0) {
					int top = i > 0 ? grid[i - 1][j] : Integer.MAX_VALUE;
					int left = j > 0 ? grid[i][j - 1] : Integer.MAX_VALUE;
					grid[i][j] += Math.min(top, left);
				}
			}
		}
		return grid[ROWS - 1][COLS - 1];
	}

	public static void main(String[] args) {
		MinimumPathSum lzr = new MinimumPathSum();
		int[][] grid = { { 1, 3, 1 }, { 1, 5, 1 }, { 4, 2, 1 } };
		int res = lzr.minPathSum(grid);
		System.out.print(res);
	}
}