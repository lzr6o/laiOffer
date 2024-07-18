package Code;

class CuttingWood {
	int minCost(int[] cuts, int len) {
		int[] arr = new int[cuts.length + 2];
		arr[0] = 0;
		for (int i = 0; i < cuts.length; i++) {
			arr[i + 1] = cuts[i];
		}
		arr[arr.length - 1] = len;
		int[][] dp = new int[arr.length][arr.length];
		for (int i = 1; i < arr.length; i++) {
			for (int j = i - 1; j >= 0; j--) {
				if (j + 1 == i) {
					dp[j][i] = 0;
				} else {
					dp[j][i] = Integer.MAX_VALUE;
					for (int k = j + 1; k <= i - 1; k++) {
						dp[j][i] = Math.min(dp[j][i], dp[j][k] + dp[k][i]);
					}
					dp[j][i] += arr[i] - arr[j];
				}
			}
		}
		return dp[0][arr.length - 1];
	}

	public static void main(String[] args) {
		CuttingWood lzr = new CuttingWood();
		int len = 10;
		int[] cuts = { 2, 4, 7 };
		int minCost = lzr.minCost(cuts, len);
		System.out.println(minCost);
	}
}