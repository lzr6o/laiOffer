package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class CommonNumbersOfTwoArraysII {
	List<Integer> common(int[] a, int[] b) {
		List<Integer> common = new ArrayList<Integer>();
		Map<Integer, Integer> freqMap = new HashMap<>();
		for (int num : a) {
			Integer freq = freqMap.get(num);
			if (freq == null) {
				freqMap.put(num, 1);
			} else {
				freqMap.put(num, freq + 1);
			}
		}
		for (int num : b) {
			Integer freq = freqMap.get(num);
			if (freq != null && freq > 0) {
				common.add(num);
				freqMap.put(num, freq - 1);
			}
		}
		common.sort(null);
		return common;
	}

	public static void main(String args[]) {
		CommonNumbersOfTwoArraysII lzr = new CommonNumbersOfTwoArraysII();
		int[] a = { 1, 2, 3, 2 };
		int[] b = { 3, 4, 2, 2, 2 };
		List<Integer> result = new ArrayList<Integer>();
		result = lzr.common(a, b);
		System.out.print(result);
	}
}