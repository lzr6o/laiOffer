package leetcode;

class SignOfTheProductOfAnArray {
	int arraySign(int[] nums) {
		int cnt = 0;
		for (int num : nums) {
			if (num == 0) {
				return 0;
			}
			if (num < 0) {
				cnt++;
			}
		}
		return cnt % 2 == 0 ? 1 : -1;
	}

	public static void main(String[] args) {
		SignOfTheProductOfAnArray lzr = new SignOfTheProductOfAnArray();
		int[] nums = { -1, -2, -3, -4, 3, 2, 1 };
		int res = lzr.arraySign(nums);
		System.out.print(res);
	}
}