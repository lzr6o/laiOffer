package leetcode;
class LargestSquareOf1s {
	int largest(int[][] matrix) {
		int n = matrix.length;
		if (n == 0) {
			return 0;
		}
		int res = 0;
		int[][] dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				if (i == 0 || j == 0) {
					dp[i][j] = matrix[i][j] == 1 ? 1 : 0;
				} else if (matrix[i][j] == 1) {
					dp[i][j] = Math.min(dp[i][j - 1] + 1, dp[i - 1][j] + 1);
					dp[i][j] = Math.min(dp[i - 1][j - 1] + 1, dp[i][j]);
				}
				res = Math.max(res, dp[i][j]);
			}
		}
		return res;
	}
	
	public static void main(String[] args) {
		LargestSquareOf1s lzr = new LargestSquareOf1s();
		int[][] matrix = { { 0, 0, 0, 0 },
				           { 1, 1, 1, 1 },
				           { 0, 1, 1, 1 },
				           { 1, 0, 1, 1 } };
		int res = lzr.largest(matrix);
		System.out.print(res);
	}
}