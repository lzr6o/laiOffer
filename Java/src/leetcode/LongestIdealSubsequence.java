package leetcode;

class LongestIdealSubsequence {
	int longestIdealString(String s, int k) {
		int dp[] = new int[26], ans = 1;
		for (int c = 0, n = s.length(); c < n; c++) {
			int i = s.charAt(c) - 'a';
			dp[i]++;
			for (int j = Math.max(0, i - k); j <= Math.min(25, i + k); j++) {
				if (j != i) {
					dp[i] = Math.max(dp[i], dp[j] + 1);
				}
			}
			ans = Math.max(ans, dp[i]);
		}
		return ans;
	}

	public static void main(String[] args) {
		LongestIdealSubsequence lzr = new LongestIdealSubsequence();
		String s = "slddedwfmo";
		int k = 16;
		int res = lzr.longestIdealString(s, k);
		System.out.print(res);
	}
}