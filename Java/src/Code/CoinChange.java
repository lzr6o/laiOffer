package Code;

import java.util.Arrays;

class CoinChange {
	int coinChange(int[] coins, int amount) {
		int[] dp = new int[amount + 1];
		Arrays.fill(dp, amount + 1);
		dp[0] = 0;
		for (int cur = 1; cur <= amount; cur++) {
			for (int coin : coins) {
				if (cur >= coin) {
					dp[cur] = Math.min(dp[cur], 1 + dp[cur - coin]);
				}
			}
		}
		return dp[amount] != amount + 1 ? dp[amount] : -1;
	}

	public static void main(String[] args) {
		CoinChange lzr = new CoinChange();
		int[] coins = { 1, 2, 5 };
		int amount = 11;
		int res = lzr.coinChange(coins, amount);
		System.out.print(res);
	}
}