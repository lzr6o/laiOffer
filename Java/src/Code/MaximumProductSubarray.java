package Code;
class MaximumProductSubarray {
	int maxProduct(int[] nums) {
		int min, max, res;
		min = max = 1;
		res = Integer.MIN_VALUE;
		for (int num : nums) {
			int minPro = num * min;
			int maxPro = num * max;
			min = Math.min(Math.min(minPro, maxPro), num);
			max = Math.max(Math.max(minPro, maxPro), num);
			res = Math.max(res, max);
		}
		return res;
	}

	public static void main(String[] args) {
		MaximumProductSubarray lzr = new MaximumProductSubarray();
		int[] nums = { 2, 3, -2, -4 };
		int res = lzr.maxProduct(nums);
		System.out.print(res);
	}
}