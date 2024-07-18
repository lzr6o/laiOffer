package Code;

class InterleaveStrings {

	boolean canMerge(String a, String b, String c) {
		int m = a.length(), n = b.length();
		if (m + n != c.length()) {
			return false;
		}
		boolean[][] dp = new boolean[m + 1][n + 1];
		dp[0][0] = true;
		for (int i = 0; i <= m; i++) {
			for (int j = 0; j <= n; j++) {
				if (i > 0 && a.charAt(i - 1) == c.charAt(i + j - 1) && dp[i - 1][j]) {
					dp[i][j] = true;
				}
				if (j > 0 && b.charAt(j - 1) == c.charAt(i + j - 1) && dp[i][j - 1]) {
					dp[i][j] = true;
				}
			}
		}
		return dp[m][n];
	}

	public static void main(String[] args) {
		InterleaveStrings lzr = new InterleaveStrings();
		String a = "aabcc";
		String b = "dbbca";
		String c = "aadbbcbcac";
		boolean res = lzr.canMerge(a, b, c);
		System.out.print(res);
	}
}