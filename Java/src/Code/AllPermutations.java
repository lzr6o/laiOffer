package Code;

import java.util.ArrayList;
import java.util.List;

class AllPermutations {
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
		for (int i = idx; i < arr.length; i++) {
			swap(arr, idx, i);
			dfs(arr, idx + 1, res);
			swap(arr, idx, i);
		}
	}

	void swap(char[] arr, int a, int b) {
		char tmp = arr[a];
		arr[a] = arr[b];
		arr[b] = tmp;
	}

	public static void main(String args[]) {
		AllPermutations lzr = new AllPermutations();
		List<String> res = lzr.permutations("abc");
		System.out.print(res);
	}
}