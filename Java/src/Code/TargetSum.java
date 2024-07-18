package Code;
class TargetSum {
	int findTargetSumWays(int[] nums, int target) {
		int[] cnt = new int[1];
		dfs(nums, target, 0, cnt);
		return cnt[0];
	}

	void dfs(int[] nums, int target, int idx, int[] cnt) {
		if (idx == nums.length) {
			if (target == 0) {
				cnt[0]++;
			}
			return;
		}
		dfs(nums, target + nums[idx], idx + 1, cnt);
		dfs(nums, target - nums[idx], idx + 1, cnt);
	}
	
	public static void main(String[] args) {
		TargetSum lzr = new TargetSum();
		int[] nums = { 1, 1, 1, 1, 1 };
		int target = 3;
		int res = lzr.findTargetSumWays(nums, target);
		System.out.print(res);
	}
}