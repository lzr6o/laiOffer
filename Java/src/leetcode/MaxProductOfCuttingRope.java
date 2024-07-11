package leetcode;
class MaxProductOfCuttingRope {
	int maxProduct(int len) {
		int[] dp = new int[len + 1];
		dp[1] = 0;
		for (int i = 2; i <= len; i++) {
			for (int j = 1; j < i; j++) {
				dp[i] = Math.max(dp[i], Math.max(j, dp[j]) * (i - j));
			}
		}
		return dp[len];
	}

	public static void main(String[] args) {
		MaxProductOfCuttingRope lzr = new MaxProductOfCuttingRope();
		int len = 12;
		int res = lzr.maxProduct(len);
		System.out.print(res);
	}
}