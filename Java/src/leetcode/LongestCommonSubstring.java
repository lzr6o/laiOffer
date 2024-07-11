package leetcode;
class LongestCommonSubstring {
	String longestCommon(String source, String target) {
		int head = 0;
		int max = 0;
		int[][] dp = new int[source.length() + 1][target.length() + 1];
		for (int i = 1; i <= source.length(); i++) {
			for (int j = 1; j <= target.length(); j++) {
				if (source.charAt(i - 1) == target.charAt(j - 1)) {
					dp[i][j] = dp[i - 1][j - 1] + 1;
				}
				if (dp[i][j] > max) {
					max = dp[i][j];
					head = i - max;
				}
			}
		}
		return source.substring(head, head + max);
	}

	public static void main(String[] args) {
		LongestCommonSubstring lzr = new LongestCommonSubstring();
		String source = "abcde";
		String target = "cdf";
		String res = lzr.longestCommon(source, target);
		System.out.print(res);
	}
}