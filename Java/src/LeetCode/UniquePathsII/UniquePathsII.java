package LeetCode.UniquePathsII;
class UniquePathsII {
	int uniquePathsWithObstacles(int[][] obstacleGrid) {
		int ROWS = obstacleGrid.length, COLS = obstacleGrid[0].length;
		int[][] dp = new int[ROWS + 1][COLS + 1];
		for (int i = 1; i <= ROWS; i++) {
			for (int j = 1; j <= COLS; j++) {
				if (obstacleGrid[i - 1][j - 1] == 1) {
					dp[i][j] = 0;
				} else {
					if (i == 1 && j == 1) {
						dp[i][j] = 1;
					} else {
						dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
					}
				}
			}
		}
		return dp[ROWS][COLS];
	}

	public static void main(String[] args) {
		UniquePathsII lzr = new UniquePathsII();
		int[][] obstacleGrid = { { 0, 0, 0 }, { 0, 1, 0 }, { 0, 0, 0 } };
		int res = lzr.uniquePathsWithObstacles(obstacleGrid);
		System.out.print(res);
	}
}