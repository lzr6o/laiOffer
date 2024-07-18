package Code;

class OnesAndZeros {
	int findMaxForm(String[] strs, int m, int n) {
		int[][] dp = new int[m + 1][n + 1];
		for (String str : strs) {
			int zero = 0, one = 0;
			char[] arr = str.toCharArray();
			for (char c : arr) {
				if (c == '0') {
					zero++;
				} else {
					one++;
				}
			}
			for (int i = m; i >= zero; i--) {
				for (int j = n; j >= one; j--) {
					dp[i][j] = Math.max(dp[i][j], dp[i - zero][j - one] + 1);
				}
			}
		}
		return dp[m][n];
	}

	public static void main(String[] args) {
		OnesAndZeros lzr = new OnesAndZeros();
		String[] strs = { "10", "0001", "111001", "1", "0" };
		int m = 5;
		int n = 3;
		int res = lzr.findMaxForm(strs, m, n);
		System.out.print(res);
	}
}