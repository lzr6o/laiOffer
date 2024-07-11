package leetcode;
import java.util.HashSet;
import java.util.Set;

class NumberOfArithmeticTriplets {
	int arithmeticTriplets(int[] nums, int diff) {
		Set<Integer> set = new HashSet<>();
		for (int num : nums) {
			set.add(num);
		}
		int res = 0;
		for (int num : nums) {
			if (set.contains(num + diff) && set.contains(num + 2 * diff)) {
				res++;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		NumberOfArithmeticTriplets lzr = new NumberOfArithmeticTriplets();
		int[] nums = { 4, 5, 6, 7, 8, 9 };
		int diff = 2;
		int res = lzr.arithmeticTriplets(nums, diff);
		System.out.print(res);
	}
}