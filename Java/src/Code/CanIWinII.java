package Code;

class CanIWinII {
	int canWin(int[] nums) {
		int len = nums.length;
		int[][] dp = new int[len][len];
		for (int i = 0; i < len; i++) {
			for (int j = 0; j < len - i; j++) {
				int x = j;
				int y = j + i;
				if (x == y) {
					dp[x][y] = nums[x];
				} else if (y == x + 1) {
					dp[x][y] = Math.max(nums[x], nums[y]);
				} else {
					int head = nums[x] + (nums[x + 1] > nums[y] ? dp[x + 2][y] : dp[x + 1][y - 1]);
					int tail = nums[y] + (nums[x] > nums[y - 1] ? dp[x + 1][y - 1] : dp[x][y - 2]);
					dp[x][y] = Math.max(head, tail);
				}
			}
		}
		return dp[0][len - 1];
	}

	public static void main(String[] args) {
		CanIWinII lzr = new CanIWinII();
		int[] nums = { 2, 1, 100, 3 };
		int res = lzr.canWin(nums);
		System.out.print(res);
	}
}