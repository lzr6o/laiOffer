package leetcode;

import java.util.HashMap;
import java.util.Map;

class DegreeOfAnArray {
	int findShortestSubArray(int[] nums) {
		Map<Integer, Integer> map = new HashMap<>();
		int cnt = 0;
		int tail = 0;
		int target = 0;
		for (int i = 0; i < nums.length; i++) {
			int num = nums[i];
			if (!map.containsKey(num)) {
				map.put(num, 1);
			} else {
				map.put(num, map.get(num) + 1);
			}
			if (map.get(num) > cnt) {
				target = num;
				cnt = map.get(num);
				tail = i;
			}
		}
		return res;
	}

	public static void main(String[] args) {
		DegreeOfAnArray lzr = new DegreeOfAnArray();
		int[] nums = { 1, 2, 2, 3, 1 };
		int res = lzr.findShortestSubArray(nums);
		System.out.print(res);
	}
}