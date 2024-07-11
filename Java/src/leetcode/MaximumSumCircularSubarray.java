package leetcode;
class MaximumSumCircularSubarray {
	int maxSubarraySumCircular(int[] nums) {
		int maxSum, minSum, curMax, curMin, sum;
		maxSum = minSum = nums[0];
		curMax = curMin = sum = 0;
		for (int num : nums) {
			curMax = Math.max(num, curMax + num);
			maxSum = Math.max(maxSum, curMax);
			curMin = Math.min(num, curMin + num);
			minSum = Math.min(minSum, curMin);
			sum += num;
		}
		return maxSum > 0 ? Math.max(maxSum, sum - minSum) : maxSum;
	}

	public static void main(String[] args) {
		MaximumSumCircularSubarray lzr = new MaximumSumCircularSubarray();
		int[] nums = { 8, -15, -29, -19 };
		int res = lzr.maxSubarraySumCircular(nums);
		System.out.print(res);
	}
}