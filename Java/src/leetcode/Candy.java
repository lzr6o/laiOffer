package leetcode;

class Candy {
	int candy(int[] ratings) {
		int idx = 0;
		for (int i = 0; i < ratings.length; i++) {
			if (ratings[i] < ratings[idx]) {
				idx = i;
			}
		}
		int sum = 1;
		int start = idx - 1;
		int[] dp = new int[ratings.length];
		dp[idx] = 1;
		while (start >= 0) {
			if (ratings[start] > ratings[start + 1]) {
				dp[start] = dp[start + 1] + 1;
			} else {
				dp[start] = dp[start + 1];
			}
			sum += dp[start];
			start--;
		}
		start = idx + 1;
		while (start < ratings.length) {
			if (ratings[start] > ratings[start - 1]) {
				dp[start] = dp[start - 1] + 1;
			} else {
				dp[start] = dp[start - 1];
			}
			sum += dp[start];
			start++;
		}
		return sum;
	}

	public static void main(String[] args) {
		Candy lzr = new Candy();
		int[] ratings = { 1, 2, 2 };
		int res = lzr.candy(ratings);
		System.out.print(res);
	}
}