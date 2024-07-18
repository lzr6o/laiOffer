package Code;
class PartitionEqualSubsetSum {
	boolean canPartition(int[] nums) {
		int sum = 0;
		for (int n : nums) {
			sum += n;
		}
		if (sum % 2 != 0) {
			return false;
		}
		int target = sum / 2;
		int[] dp = new int[target + 1];
		dp[0] = 1;
		for (int num : nums) {
			for (int i = target; i >= num; i--) {
				dp[i] += dp[i - num];
			}
		}
		return dp[target] != 0;
	}

	public static void main(String[] args) {
		PartitionEqualSubsetSum lzr = new PartitionEqualSubsetSum();
		int[] nums = { 1, 5, 11, 5 };
		boolean res = lzr.canPartition(nums);
		System.out.print(res);
	}
}