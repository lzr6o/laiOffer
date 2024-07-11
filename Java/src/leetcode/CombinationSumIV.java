package leetcode;

class CombinationSumIV {

	int combinationSum4(int[] nums, int target) {
		int[] dp = new int[target + 1];
		dp[0] = 1;
	    for (int i = 1; i <= target; i++) {
	        for (int j = 0; j < nums.length; j++) {
	            if (i - nums[j] >= 0) {
	            	dp[i] += dp[i - nums[j]];
	            }
	        }
	    }
	    return dp[target];
	}
	
	public static void main(String[] args) {
		CombinationSumIV lzr = new CombinationSumIV();
		int[] nums = { 1, 2, 4 };
		int target = 4;
		int res = lzr.combinationSum4(nums, target);
		System.out.print(res);
	}
}