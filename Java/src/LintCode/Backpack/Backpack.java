package LintCode.Backpack;

class Backpack {

	int backPack(int m, int[] A) {
		int[] dp = new int[m + 1];
		for (int i = 0; i < A.length; i++) {
            for (int j = m; j >= A[i]; j--) {
            	dp[j] = Math.max(dp[j], dp[j - A[i]] + A[i]);
            }
        }
        return dp[m];
	}
	
	public static void main(String[] args) {
		Backpack lzr = new Backpack();
		int m = 10;
		int[] A = { 3, 4, 8, 5 };
		int res = lzr.backPack(m, A);
		System.out.print(res);
	}
}