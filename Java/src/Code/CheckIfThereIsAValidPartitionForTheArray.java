package Code;

class CheckIfThereIsAValidPartitionForTheArray {
	boolean validPartition(int[] nums) {
		int n = nums.length;
		boolean[] dp = new boolean[n + 1];
		dp[0] = true;
		dp[2] = nums[1] == nums[0] ? true : false;
		for (int i = 3; i <= n; i++) {
			if (nums[i - 1] == nums[i - 2]) {
				dp[i] |= dp[i - 2];
			}
			if ((nums[i - 1] == nums[i - 2] && nums[i - 2] == nums[i - 3])
					|| (nums[i - 1] == nums[i - 2] + 1 && nums[i - 2] == nums[i - 3] + 1)) {
				dp[i] |= dp[i - 3];
			}
		}
		return dp[n];
	}

	public static void main(String[] args) {
		CheckIfThereIsAValidPartitionForTheArray lzr = new CheckIfThereIsAValidPartitionForTheArray();
		int[] nums = { 1, 1, 1, 1, 2, 3 };
		boolean res = lzr.validPartition(nums);
		System.out.print(res);
	}
}