package leetcode;

class CountingAscendingSubsequence {

	int numIncreasingSubsequences(int[] arr) {
		int cnt = 0;
		int[] dp = new int[arr.length];
		for (int i = 0; i < dp.length; i++) {
			dp[i] = 1;
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i]) {
					dp[i] += dp[j];
				}
			}
			cnt += dp[i];
		}
		return cnt;
	}

	public static void main(String[] args) {
		CountingAscendingSubsequence lzr = new CountingAscendingSubsequence();
		int[] arr = { 2, 5, 7, 6, 3, 4, 5 };
		int res = lzr.numIncreasingSubsequences(arr);
		System.out.print(res);
	}
}