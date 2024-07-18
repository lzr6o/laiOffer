package Code;

class BackpackII {
	int backPackII(int m, int[] A, int[] V) {
		int[] dp = new int[m + 1];
		for (int i = 0; i < A.length; i++) {
            for (int j = m; j >= A[i]; j--) {
            	dp[j] = Math.max(dp[j], dp[j - A[i]] + V[i]);
            }
        }
		return dp[m];
	}
	
	public static void main(String[] args) {
		BackpackII lzr = new BackpackII();
		int m = 10;
		int[] A = { 2, 3, 5, 7 };
		int[] V = { 1, 5, 2, 4 };
		int res = lzr.backPackII(m, A, V);
		System.out.print(res);
	}
}
