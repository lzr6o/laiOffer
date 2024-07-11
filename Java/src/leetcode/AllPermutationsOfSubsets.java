package leetcode;

import java.util.ArrayList;
import java.util.List;

class AllPermutationsOfSubsets {
	List<String> allPermutationsOfSubsets(String set) {
		List<String> res = new ArrayList<>();
		if (set == null) {
			return res;
		}
		char[] arr = set.toCharArray();
		helper(arr, 0, res);
		return res;
	}
	
	void helper(char[] arr, int idx, List<String> res) {
		res.add(new String(arr, 0, idx));
		for (int i = idx; i < arr.length; i++) {
			swap(arr, idx, i);
			helper(arr, idx + 1, res);
			swap(arr, idx, i);
		}
	}
	
	void swap(char[] arr, int left, int right) {
		char tmp = arr[left];
		arr[left] = arr[right];
		arr[right] = tmp;
	}
	
	public static void main(String[] args) {
		AllPermutationsOfSubsets lzr = new AllPermutationsOfSubsets();
		String set = "abc";
		List<String> res = new ArrayList<>();
		res = lzr.allPermutationsOfSubsets(set);
		System.out.print(res);
	}
}