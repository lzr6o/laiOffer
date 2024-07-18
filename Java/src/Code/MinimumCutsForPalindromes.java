package Code;

class MinimumCutsForPalindromes {
	int minCut(String s) {
		int len = s.length();
		char[] arr = s.toCharArray();
		int[] dp = new int[len + 1];
		for (int i = 0; i <= len; i++) {
			dp[i] = i - 1;
		}
		for (int i = 0; i < len; i++) {
			extend(arr, i, i, dp);
			extend(arr, i, i + 1, dp);
		}
		return dp[len];
	}

	void extend(char[] arr, int head, int tail, int[] dp) {
		while (head >= 0 && tail < arr.length && arr[head] == arr[tail]) {
			dp[tail + 1] = Math.min(dp[tail + 1], dp[head] + 1);
			head--;
			tail++;
		}
	}

	public static void main(String[] args) {
		MinimumCutsForPalindromes lzr = new MinimumCutsForPalindromes();
		String input = "aba";
		int res = lzr.minCut(input);
		System.out.print(res);
	}
}