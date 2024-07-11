package leetcode;
class MaximumNumberByRemoveASingle5 {
	int remove5(int n) {		
		int max = Integer.MIN_VALUE;
		int tens = 10;
		String s = Integer.toString(n);
		int[] dp = new int[s.length() + 1];
		for (int i = dp.length - 2; i >= 0 ; i--) {
			dp[i] = n % tens;
			tens *= 10;
		}
		for (int i = 0; i < dp.length; i++) {
			if (i < s.length() && s.charAt(i) == '5') {
				max = Math.max(max, (n - dp[i]) / 10 + dp[i + 1]);
			}
		}
		return max;
	}
	
	public static void main(String[] args) {
		MaximumNumberByRemoveASingle5 lzr = new MaximumNumberByRemoveASingle5();
		int n = -5500;
		int res = lzr.remove5(n);
		System.out.print(res);
	}
}