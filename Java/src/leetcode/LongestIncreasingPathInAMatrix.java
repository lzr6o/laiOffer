package leetcode;

class LongestIncreasingPathInAMatrix {
	int longestIncreasingPath(int[][] matrix) {
		int ROWS = matrix.length, COLS = matrix[0].length, res = Integer.MIN_VALUE;
		int[][] dp = new int[ROWS][COLS];
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				res = Math.max(res, dfs(matrix, dp, ROWS, COLS, i, j, -1));
			}
		}
		return res;
	}

	int dfs(int[][] matrix, int[][] dp, int ROWS, int COLS, int r, int c, int pre) {
		if (r < 0 || r == ROWS || c < 0 || c == COLS || matrix[r][c] <= pre) {
			return 0;
		}
		if (dp[r][c] != 0) {
			return dp[r][c];
		}
		int step = 1;
		pre = matrix[r][c];
		step = Math.max(step, 1 + dfs(matrix, dp, ROWS, COLS, r + 1, c, pre));
		step = Math.max(step, 1 + dfs(matrix, dp, ROWS, COLS, r - 1, c, pre));
		step = Math.max(step, 1 + dfs(matrix, dp, ROWS, COLS, r, c + 1, pre));
		step = Math.max(step, 1 + dfs(matrix, dp, ROWS, COLS, r, c - 1, pre));
		dp[r][c] = step;
		return step;
	}

	public static void main(String[] args) {
		LongestIncreasingPathInAMatrix lzr = new LongestIncreasingPathInAMatrix();
		int[][] matrix = { { 9, 9, 4 }, { 6, 6, 8 }, { 2, 1, 1 } };
		int res = lzr.longestIncreasingPath(matrix);
		System.out.print(res);
	}
}