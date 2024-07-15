package leetcode;

class MinimumSizeSubarraySum {
	int minSubArrayLen(int target, int[] nums) {
		int L = 0, R = 0, sum = 0, min = Integer.MAX_VALUE;
		while (R < nums.length) {
			sum += nums[R++];
			while (sum >= target) {
				min = Math.min(min, R - L);
				sum -= nums[L++];
			}
		}
		return min == Integer.MAX_VALUE ? 0 : min;
	}

	public static void main(String[] args) {
		MinimumSizeSubarraySum lzr = new MinimumSizeSubarraySum();
		int target = 7;
		int[] nums = { 2, 3, 1, 2, 4, 3 };
		int res = lzr.minSubArrayLen(target, nums);
		System.out.print(res);
	}
}