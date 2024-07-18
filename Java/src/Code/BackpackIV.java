package Code;

class BackpackIV {
	int backPackIV(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = nums[i]; j <= target; j++) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[target];
	}

	public static void main(String[] args) {
		BackpackIV lzr = new BackpackIV();
		int[] nums = { 2, 3, 6, 7 };
		int target = 7;
		int res = lzr.backPackIV(nums, target);
		System.out.print(res);
	}
}