package leetcode;

class BuyStockIII {

	int maxProfit(int[] prices) {
		int firstBuy = Integer.MAX_VALUE;
		int secondBuy = Integer.MAX_VALUE;
		int firstSell = 0;
		int secondSell = 0;
		for (int p : prices) {
			firstBuy = Math.min(firstBuy, p);
			firstSell = Math.max(firstSell, p - firstBuy);
			secondBuy = Math.min(secondBuy, p - firstSell);
			secondSell = Math.max(secondSell, p - secondBuy);
		}
		return secondSell;
	}

	public static void main(String[] args) {
		BuyStockIII lzr = new BuyStockIII();
		int[] prices = { 1, 3 };
		int profit = lzr.maxProfit(prices);
		System.out.print(profit);
	}
}