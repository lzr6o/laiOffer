package leetcode;

class OneThreeTwoPattern {
	boolean find132pattern(int[] nums) {
		int N = nums.length, top = N, third = Integer.MIN_VALUE;
		for (int i = N - 1; i >= 0; i--) {
			if (nums[i] < third) {
				return true;
			}
			while (top < N && nums[top] < nums[i]) {
				third = nums[top++];
			}
			nums[--top] = nums[i];
		}
		return false;
	}

	public static void main(String[] args) {
		OneThreeTwoPattern lzr = new OneThreeTwoPattern();
		int[] nums = { 4, 0, 1, -4, -3, -1, -2 };
		boolean res = lzr.find132pattern(nums);
		System.out.print(res);
	}
}