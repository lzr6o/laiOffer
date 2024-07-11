package leetcode;
class MaximumAverageSubarray {
	double findMaxAverage(int[] nums, int k) {
		int head = 0;
		int sum = 0, res = Integer.MIN_VALUE;
		for (int tail = 0; tail < nums.length; tail++) {
			if (tail - head + 1 < k) {
				sum += nums[tail];
			} else {
				sum += nums[tail];
				res = Math.max(res, sum);
				sum -= nums[head];
				head++;
			}
		}
		return res/1.0/k;
	}

	public static void main(String[] args) {
		MaximumAverageSubarray lzr = new MaximumAverageSubarray();
		int[] nums = { -1 };
		int k = 1;
		double res = lzr.findMaxAverage(nums, k);
		System.out.print(res);
	}
}