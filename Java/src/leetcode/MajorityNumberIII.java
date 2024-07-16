package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class MajorityNumberIII {
	List<Integer> majority(int[] arr, int k) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : arr) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		List<Integer> res = new ArrayList<>();
		for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
			if (entry.getValue() > arr.length / k) {
				res.add(entry.getKey());
			}
		}
		return res;
	}

	public static void main(String[] args) {
		MajorityNumberIII lzr = new MajorityNumberIII();
		int[] arr = { 1, 2, 2 };
		int k = 3;
		List<Integer> res = lzr.majority(arr, k);
		System.out.print(res);
	}
}