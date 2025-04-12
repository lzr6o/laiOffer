package LeetCode.TwoSum;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class TwoSum {
	int[] twoSum(int[] nums, int target) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			int left = target - nums[i];
			if (map.containsKey(left)) {
				return new int[] { map.get(left), i };
			}
			map.put(nums[i], i);
		}
		return null;
	}

	public static void main(String[] args) {
		TwoSum lzr = new TwoSum();
		int[] nums = { 1, 2, 3 };
		int target = 5;
		int[] res = lzr.twoSum(nums, target);
		System.out.print(Arrays.toString(res));
	}
}