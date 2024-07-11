package leetcode;
class MinimumCostForTickets {
	int mincostTickets(int[] days, int[] costs) {
		int seven = 0;
		int thirty = 0;
		int[] dp = new int[days.length + 1];
		for (int i = 0; i < days.length; i++) {
			while (days[i] - days[seven] > 6) {
				seven++;
			}
			while (days[i] - days[thirty] > 29) {
				thirty++;
			}
			dp[i + 1] = Math.min(dp[i] + costs[0], dp[seven] + costs[1]);
			dp[i + 1] = Math.min(dp[i + 1], dp[thirty] + costs[2]);
		}
		return dp[dp.length - 1];
	}
	
	public static void main(String[] args) {
		MinimumCostForTickets lzr = new MinimumCostForTickets();
		int[] days = { 1,4,6,9,10,11,12,13,14,15,16,17,18,20,21,22,23,27,28 };
		int[] costs = { 3, 13, 45 };
		int res = lzr.mincostTickets(days, costs);
		System.out.print(res);
	}
}