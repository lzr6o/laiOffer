package LeetCode.Permutations;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Permutations {
	List<List<Integer>> permute(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> cur = new ArrayList<>();
		for (int num : nums) {
			cur.add(num);
		}
		dfs(cur, res, 0);
		return res;
	}

	void dfs(List<Integer> cur, List<List<Integer>> res, int idx) {
		if (idx == cur.size()) {
			res.add(new ArrayList<>(cur));
			return;
		}
		for (int i = idx; i < cur.size(); i++) {
			Collections.swap(cur, i, idx);
			dfs(cur, res, idx + 1);
			Collections.swap(cur, i, idx);
		}
	}

	public static void main(String[] args) {
		Permutations lzr = new Permutations();
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> res = lzr.permute(nums);
		System.out.print(res);
	}
}