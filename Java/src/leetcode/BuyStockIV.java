package leetcode;

class BuyStockIV {

	int maxProfit(int[] prices, int k) {
		if (prices.length <= 1) {
			return 0;
		}
		int[][] profit = new int[k + 1][prices.length];
		for (int i = 1; i <= k; i++) {
			int maxHoldStock = -prices[0];
			for (int j = 1; j < profit[0].length; j++) {
				profit[i][j] = Math.max(profit[i][j - 1], prices[j] + maxHoldStock);
				maxHoldStock = Math.max(maxHoldStock, profit[i - 1][j] - prices[j]);
				System.out.print(maxHoldStock + " ");
			}
			System.out.println();
		}
		return profit[k][prices.length - 1];
	}

	public static void main(String[] args) {
		BuyStockIV lzr = new BuyStockIV();
		int[] prices = { 2, 3, 2, 1, 4, 5, 2, 11 };
		int k = 3;
		int profit = lzr.maxProfit(prices, k);
		System.out.print(profit);
	}
}