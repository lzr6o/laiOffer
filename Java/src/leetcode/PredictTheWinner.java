package leetcode;
class PredictTheWinner {
	boolean PredictTheWinner(int[] nums) {
		int n = nums.length;
		int[][] dp = new int[n][n];
		for (int i = 0; i < n; i++) {
			dp[i][i] = nums[i];
		}
		for (int len = 1; len < n; len++) {
			for (int i = 0; i < n - len; i++) {
				int j = i + len;
				dp[i][j] = Math.max(nums[i] - dp[i + 1][j], nums[j] - dp[i][j - 1]);
			}
		}
		return dp[0][n - 1] >= 0;
	}

	public static void main(String[] args) {
		PredictTheWinner lzr = new PredictTheWinner();
		int[] nums = { 2, 1, 100, 3 };
		boolean res = lzr.PredictTheWinner(nums);
		System.out.print(res);
	}
}