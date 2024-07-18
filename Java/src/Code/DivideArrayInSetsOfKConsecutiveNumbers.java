package Code;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class DivideArrayInSetsOfKConsecutiveNumbers {
	boolean isPossibleDivide(int[] nums, int k) {
		int n = nums.length;
		if (n % k != 0) {
			return false;
		}
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		Arrays.sort(nums);
		for (int i = 0; i < n; i++) {
			if (map.get(nums[i]) != 0) {
				for (int j = 0; j < k; j++) {
					int next = nums[i] + j;
					if (map.getOrDefault(next, 0) == 0) {
						return false;
					}
					map.put(next, map.get(next) - 1);
				}
			}
		}
		return true;
	}

	public static void main(String[] args) {
		DivideArrayInSetsOfKConsecutiveNumbers lzr = new DivideArrayInSetsOfKConsecutiveNumbers();
		int[] nums = { 1, 2, 3, 3, 4, 4, 5, 6 };
		int k = 4;
		boolean res = lzr.isPossibleDivide(nums, k);
		System.out.print(res);
	}
}