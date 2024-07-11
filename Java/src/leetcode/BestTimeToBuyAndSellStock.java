package leetcode;

class BestTimeToBuyAndSellStock {

	int maxProfit(int[] prices) {
		int l = 0, r = 1, profit = 0, max = 0;
		while (r < prices.length) {
			if (prices[l] < prices[r]) {
				profit = prices[r] - prices[l];
				max = Math.max(max, profit);
			} else {
				l = r;
			}
			r++;
		}
		return max;
	}

	public static void main(String[] args) {
		BestTimeToBuyAndSellStock lzr = new BestTimeToBuyAndSellStock();
		int[] prices = { 1, 2, 4, 2, 5, 7, 2, 4, 9, 0, 9 };
		int res = lzr.maxProfit(prices);
		System.out.print(res);
	}
}