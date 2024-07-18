package Code;

class CoinChangeII {
	int change(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		dp[0] = 1;
		for (int coin : coins) {
			for (int cur = coin; cur <= amount; cur++) {
				dp[cur] += dp[cur - coin];
			}
		}
		return dp[amount];
	}
	
	public static void main(String[] args) {
		CoinChangeII lzr = new CoinChangeII();
		int[] coins = { 1, 2, 5 };
		int amount = 5;
		int res = lzr.change(coins, amount);
		System.out.print(res);
	}
}