package leetcode;

class HouseRobberII {

	int rob(int[] nums) {
		if (nums.length == 1) {
			return nums[0];
		}
		int first = rob(nums, 0, nums.length - 1);
		int second = rob(nums, 1, nums.length);
		return Math.max(first, second);
	}
	
	int rob(int[] nums, int head, int tail) {
		int one = 0, two = 0;
		for (int i = head; i < tail; i++) {
			int tmp = Math.max(nums[i] + one, two);
			one = two;
			two = tmp;
		}
		return two;
	}
	
	public static void main(String[] args) {
		HouseRobberII lzr = new HouseRobberII();
		int[] nums = { 1, 1, 2, 3 };
		int res = lzr.rob(nums);
		System.out.print(res);
	}
}