package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class AllPermutationsII {
	List<String> permutations(String set) {
		List<String> res = new ArrayList<>();
		if (set == null) {
			return res;
		}
		char[] arr = set.toCharArray();
		dfs(arr, 0, res);
		return res;
	}

	void dfs(char[] arr, int idx, List<String> res) {
		if (idx == arr.length) {
			res.add(new String(arr));
			return;
		}
		Set<Character> used = new HashSet<>();
		for (int i = idx; i < arr.length; i++) {
			if (used.add(arr[i])) {
				swap(arr, i, idx);
				dfs(arr, idx + 1, res);
				swap(arr, i, idx);
			}
		}
	}

	void swap(char[] arr, int left, int right) {
		char tmp = arr[left];
		arr[left] = arr[right];
		arr[right] = tmp;
	}

	public static void main(String args[]) {
		AllPermutationsII lzr = new AllPermutationsII();
		String set = "aba";
		List<String> res = lzr.permutations(set);
		System.out.print(res);
	}
}