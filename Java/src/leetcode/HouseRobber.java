package leetcode;

class HouseRobber {
	int rob(int[] nums) {
		int one = 0, two = 0;
		for (int num : nums) {
			int tmp = Math.max(num + one, two);
			one = two;
			two = tmp;
		}
		return two;
	}
	
	public static void main(String[] args) {
		HouseRobber lzr = new HouseRobber();
		int[] nums = { 2, 3 };
		int res = lzr.rob(nums);
		System.out.print(res);
	}
}