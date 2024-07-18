package LaiCode.ArrayHopperII;

class ArrayHopperII {
	int minJump(int[] arr) {
		int[] dp = new int[arr.length];
		dp[0] = 0;
		for (int i = 1; i < dp.length; i++) {
			dp[i] = -1;
			for (int j = i - 1; j >= 0; j--) {
				if (j + arr[j] >= i && dp[j] != -1) {
					if (dp[i] == -1 || dp[i] > dp[j] + 1) {
						dp[i] = dp[j] + 1;
					}
				}
			}
		}
		return dp[dp.length - 1];
	}
	
	public static void main(String[] args) {
		ArrayHopperII lzr = new ArrayHopperII();
		int[] arr = { 3, 3, 1, 0, 4 };
		int res = lzr.minJump(arr);
		System.out.print(res);
	}
}