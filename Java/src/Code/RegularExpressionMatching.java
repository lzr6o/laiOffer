package Code;
class RegularExpressionMatching {
	boolean isMatch(String s, String p) {
		int m = p.length(), n = s.length();
		boolean[][] dp = new boolean[m + 1][n + 1];
		dp[0][0] = true;
		for (int i = 1; i <= m; i++) {
			if (p.charAt(i - 1) == '*') {
				dp[i][0] = dp[i - 2][0];
			}
		}
		for (int i = 1; i <= m; i++) {
			for (int j = 1; j <= n; j++) {
				if (p.charAt(i - 1) == s.charAt(j - 1) || p.charAt(i - 1) == '.') {
					dp[i][j] = dp[i - 1][j - 1];
				}
				if (p.charAt(i - 1) == '*') {
					if (p.charAt(i - 2) == s.charAt(j - 1) || p.charAt(i - 2) == '.') {
						dp[i][j] = dp[i - 2][j] || dp[i - 1][j] || dp[i][j - 1];
					} else {
						dp[i][j] = dp[i - 2][j];
					}
				}
			}
		}
		return dp[m][n];
	}

	public static void main(String[] args) {
		RegularExpressionMatching lzr = new RegularExpressionMatching();
		String s = "aabc";
		String p = "c*a*b.";
		boolean res = lzr.isMatch(s, p);
		System.out.print(res);
	}
}