package Code;

import java.util.HashMap;
import java.util.Map;

class ContinuousSubarraySum {
	boolean checkSubarraySum(int[] nums, int k) {
		Map<Integer, Integer> mod = new HashMap<>();
		mod.put(0, -1);
		int sum = 0;
		for (int i = 0; i < nums.length; i++) {
			sum += nums[i];
			int r = sum % k;
			if (!mod.containsKey(r)) {
				mod.put(r, i);
			} else if (i - mod.get(r) > 1) {
				return true;
			}
		}
		return false;
	}

	public static void main(String[] args) {
		ContinuousSubarraySum lzr = new ContinuousSubarraySum();
		int[] nums = { 23, 2, 4, 6, 7 };
		int k = 6;
		boolean res = lzr.checkSubarraySum(nums, k);
		System.out.print(res);
	}
}