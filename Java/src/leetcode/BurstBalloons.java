package leetcode;

class BurstBalloons {
	int maxCoins(int[] nums) {
		int n = nums.length;
		int[][] dp = new int[n + 2][n + 2];
		for (int i = 0; i < n + 2; i++) {
			for (int j = i - 2; j >= 0; j--) {
				int left = (j == 0) ? 1 : nums[j - 1];
				int right = (i == n + 1) ? 1 : nums[i - 1];
				for (int k = j + 1; k < i; k++) {
					dp[j][i] = Math.max(dp[j][i], left * right * nums[k - 1] + dp[j][k] + dp[k][i]);
				}
			}
		}
		return dp[0][n + 1];
	}

	public static void main(String[] args) {
		BurstBalloons lzr = new BurstBalloons();
		int[] nums = { 3, 1, 5, 8 };
		int res = lzr.maxCoins(nums);
		System.out.print(res);
	}
}