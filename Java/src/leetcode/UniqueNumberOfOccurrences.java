package leetcode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class UniqueNumberOfOccurrences {
	
	boolean uniqueOccurrences(int[] arr) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int num : arr) {
			map.put(num, map.getOrDefault(num, 0) + 1);
		}
		Set<Integer> set = new HashSet<>();
		for (int val : map.values()) {
			if (!set.add(val)) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) {
		UniqueNumberOfOccurrences lzr = new UniqueNumberOfOccurrences();
		int[] arr = { 1, 2 };
		boolean res = lzr.uniqueOccurrences(arr);
		System.out.print(res);
	}
}