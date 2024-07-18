package Code;
class NonDecreasingArray {
	boolean checkPossibility(int[] nums) {
		for (int i = 1, err = 0; i < nums.length; i++) {
			if (nums[i] < nums[i - 1]) {
				if (err++ > 0 || (i > 1 && i < nums.length - 1 && nums[i - 2] > nums[i] && nums[i + 1] < nums[i - 1])) {
					return false;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		NonDecreasingArray lzr = new NonDecreasingArray();
		int[] nums = { 4, 2, 1 };
		boolean res = lzr.checkPossibility(nums);
		System.out.print(res);
	}
}