package Code;
class MaximumNonNegativeProductInAMatrix {
	int maxProductPath(int[][] grid) {
		int m = grid.length;
		int n = grid[0].length;
		int mod = 1_000_000_007;
		long[][][] dp = new long[m][n][2];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 && j == 0) {
					dp[i][j][0] = grid[i][j];
					dp[i][j][1] = grid[i][j];
				} else if (i == 0) {
					dp[i][j][0] = dp[i][j][1] = dp[i][j - 1][0] * grid[i][j];
				} else if (j == 0) {
					dp[i][j][0] = dp[i][j][1] = dp[i - 1][j][0] * grid[i][j];
				} else {
					long a = Math.min(dp[i][j - 1][0], dp[i - 1][j][0]) * grid[i][j];
					long b = Math.max(dp[i][j - 1][1], dp[i - 1][j][1]) * grid[i][j];;
					dp[i][j][0] = Math.min(a, b);
					dp[i][j][1] = Math.max(a, b);
				}
			}
		}
		if (dp[m - 1][n - 1][1] < 0) {
			return -1;
		}
		return (int)(dp[m - 1][n - 1][1] % mod);
	}
	
	public static void main(String[] args) {
		MaximumNonNegativeProductInAMatrix lzr = new MaximumNonNegativeProductInAMatrix();
		int[][] grid = { { 1, -2, 1 },
				         { 1, -2, 1 },
				         { 3, -4, 1 } };
		int res = lzr.maxProductPath(grid);
		System.out.print(res);
	}
}