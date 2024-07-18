package Code;

class ClimbingStairs {
	int stairs(int n) {
		int[] dp = new int[n + 1];
		dp[0] = dp[1] = 1;
		for (int i = 2; i <= n; i++) {
			dp[i] = dp[i - 2] + dp[i - 1];
		}
		return dp[n];
	}

	public static void main(String[] args) {
		ClimbingStairs lzr = new ClimbingStairs();
		int n = 5;
		int res = lzr.stairs(n);
		System.out.print(res);
	}
}