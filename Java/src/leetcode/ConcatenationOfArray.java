package leetcode;

import java.util.Arrays;

class ConcatenationOfArray {
	int[] getConcatenation(int[] nums) {
		int j = 0;
		int[] ans = new int[nums.length * 2];
		for (int i = 0; i < 2; i++) {
			for (int num : nums) {
				ans[j++] = num;
			}
		}
		return ans;
	}

	public static void main(String[] args) {
		ConcatenationOfArray lzr = new ConcatenationOfArray();
		int[] nums = { 1, 2, 1 };
		int[] res = lzr.getConcatenation(nums);
		System.out.print(Arrays.toString(res));
	}
}