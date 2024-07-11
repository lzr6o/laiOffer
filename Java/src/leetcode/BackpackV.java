package leetcode;

class BackpackV {

	int backPackV(int[] nums, int target) {
        int[] dp = new int[target + 1];
        dp[0] = 1;
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] += dp[j - nums[i]];
            }
        }
        return dp[target];
	}

	public static void main(String[] args) {
		BackpackV lzr = new BackpackV();
		int[] nums = { 1, 2, 3, 3, 7 };
		int target = 7;
		int res = lzr.backPackV(nums, target);
		System.out.print(res);
	}
}