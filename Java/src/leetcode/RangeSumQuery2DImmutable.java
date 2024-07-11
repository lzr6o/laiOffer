package leetcode;
class RangeSumQuery2DImmutable {

	int[][] dp;

	RangeSumQuery2DImmutable(int[][] matrix) {
		int ROWS = matrix.length, COLS = matrix[0].length;
		dp = new int[ROWS + 1][COLS + 1];
		for (int i = 0; i < ROWS; i++) {
			for (int j = 0; j < COLS; j++) {
				dp[i + 1][j + 1] = dp[i][j + 1] + dp[i + 1][j] + matrix[i][j] - dp[i][j];
			}
		}
	}

	int sumRegion(int row1, int col1, int row2, int col2) {
		return dp[row2 + 1][col2 + 1] - dp[row1][col2 + 1] - dp[row2 + 1][col1] + dp[row1][col1];
	}

	public static void main(String[] args) {
		int[][] matrix = { { 3, 0, 1, 4, 2 }, { 5, 6, 3, 2, 1 }, { 1, 2, 0, 1, 5 }, { 4, 1, 0, 1, 7 },
				{ 1, 0, 3, 0, 5 } };
		RangeSumQuery2DImmutable lzr = new RangeSumQuery2DImmutable(matrix);
		int res = lzr.sumRegion(2, 1, 4, 3);
		System.out.print(res);
	}
}