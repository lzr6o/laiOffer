package leetcode;

class BuyStock {
	int maxProfit(int[] prices) {
		int res = 0, min = 0;
		for (int i = 1; i < prices.length; i++) {
			res = Math.max(res, prices[i] - prices[min]);
			min = prices[i] < prices[min] ? i : min;
		}
		return res;
	}

	public static void main(String[] args) {
		BuyStock lzr = new BuyStock();
		int[] prices = { 2, 3, 2, 1, 4, 5 };
		int profit = lzr.maxProfit(prices);
		System.out.print(profit);
	}
}