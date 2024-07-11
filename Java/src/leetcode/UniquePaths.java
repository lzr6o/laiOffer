package leetcode;
class UniquePaths {
	int uniquePaths(int m, int n) {
		int[][] dp = new int[m][n];
		for (int i = 0; i < m; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = 1;
					continue;
				}
				dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
			}
		}
		return dp[m - 1][n - 1];
	}

	public static void main(String[] args) {
		UniquePaths lzr = new UniquePaths();
		int m = 3, n = 7;
		int res = lzr.uniquePaths(m, n);
		System.out.print(res);
	}
}