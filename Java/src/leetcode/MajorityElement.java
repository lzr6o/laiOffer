package leetcode;

import java.util.HashMap;
import java.util.Map;

class MajorityElement {
	int majorityElement(int[] nums) {
		int res = 0, max = Integer.MIN_VALUE;
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : nums) {
			map.put(num, map.getOrDefault(num, 0) + 1);
			res = map.get(num) > max ? num : res;
			max = Math.max(max, map.get(num));
		}
		return res;
	}

	public static void main(String[] args) {
		MajorityElement lzr = new MajorityElement();
		int[] nums = { 2, 2, 1, 1, 1, 2, 2 };
		int res = lzr.majorityElement(nums);
		System.out.print(res);
	}
}