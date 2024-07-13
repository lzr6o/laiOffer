package leetcode;

class MinimumSizeSubarraySum {
	int minSubArrayLen(int target, int[] nums) {
		
	}

	public static void main(String[] args) {
		MinimumSizeSubarraySum lzr = new MinimumSizeSubarraySum();
		int target = 7;
		int[] nums = { 2, 3, 1, 2, 4, 3 };
		int res = lzr.minSubArrayLen(target, nums);
		System.out.print(res);
	}
}