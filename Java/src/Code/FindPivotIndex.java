package Code;

class FindPivotIndex {

	int pivotIndex(int[] nums) {
		int sum = 0;
		for (int n : nums) {
			sum += n;
		}
		int leftSum = 0;
		for (int i = 0; i < nums.length; i++) {
			int rightSum = sum - nums[i] - leftSum;
			if (leftSum == rightSum) {
				return i;
			}
			leftSum += nums[i];
		}
		return -1;
	}

	public static void main(String[] args) {
		FindPivotIndex lzr = new FindPivotIndex();
		int[] nums = { 1, 2, 3 };
		int res = lzr.pivotIndex(nums);
		System.out.print(res);
	}
}