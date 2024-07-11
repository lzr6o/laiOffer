package leetcode;

class BuyStockII {

	int maxProfit(int[] prices) {
		int profit = 0;
		int j = 0;
		for (int i = 1; i < prices.length; i++) {
			if (prices[i] > prices[i - 1]) {
				profit += prices[i] - prices[i - 1];
				j = i;
			}
			j = prices[i] < prices[j] ? i : j;
		}
		return profit;
	}
	
	public static void main(String[] args) {
		BuyStockII lzr = new BuyStockII();
		int[] prices = { 2, 3, 2, 1, 4, 5 };
		int profit = lzr.maxProfit(prices);
		System.out.print(profit);
	}
}