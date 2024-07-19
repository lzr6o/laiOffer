package LeetCode.TwoSumIIInputArrayIsSorted;

import java.util.Arrays;

class TwoSumIIInputArrayIsSorted {
	int[] twoSum(int[] numbers, int target) {
		int L = 0, R = numbers.length - 1;
		while (L < R) {
			int sum = numbers[L] + numbers[R];
			if (sum > target) {
				R--;
			} else if (sum < target) {
				L++;
			} else {
				return new int[] { L + 1, R + 1 };
			}
		}
		return new int[] {};
	}

	public static void main(String[] args) {
		TwoSumIIInputArrayIsSorted lzr = new TwoSumIIInputArrayIsSorted();
		int[] numbers = { 2, 7, 11, 15 };
		int target = 9;
		int[] res = lzr.twoSum(numbers, target);
		System.out.print(Arrays.toString(res));
	}
}