package leetcode;

class BackpackIII {

	int backPackIII(int[] A, int[] V, int m) {
		int[] dp = new int[m + 1];
		for (int i = 0; i < A.length; i++) {
			for (int j = A[i]; j <= m; j++) {
				dp[j] = Math.max(dp[j], dp[j - A[i]] + V[i]);
			}
		}
		return dp[m];
	}
	
	public static void main(String[] args) {
		BackpackIII lzr = new BackpackIII();
		int[] A = { 2, 3, 5, 7 };
		int[] V = { 1, 5, 2, 4 };
		int m = 10;
		int res = lzr.backPackIII(A, V, m);
		System.out.print(res);
	}
}