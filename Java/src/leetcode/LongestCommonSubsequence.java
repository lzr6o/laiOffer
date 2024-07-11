package leetcode;
class LongestCommonSubsequence {
	int longest(String one, String two) {
		int m = one.length(), n = two.length();
		int[][] dp = new int[m + 1][n + 1];
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (one.charAt(i - 1) == two.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				} else {
					dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
				}
			}
		}
		return dp[m][n];
	}

	public static void main(String[] args) {
		LongestCommonSubsequence lzr = new LongestCommonSubsequence();
		String one = "abcde";
		String two = "cbabdfe";
		int res = lzr.longest(one, two);
		System.out.print(res);
	}
}