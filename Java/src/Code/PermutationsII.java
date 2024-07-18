package Code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class PermutationsII {
	List<List<Integer>> permuteUnique(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> cur = new ArrayList<>();
		Arrays.sort(nums);
		for (int i = 0; i < nums.length; i++) {
			cur.add(nums[i]);
		}
		dfs(cur, 0, res);
		return res;
	}

	void dfs(List<Integer> cur, int idx, List<List<Integer>> res) {
		if (idx == cur.size()) {
			res.add(new ArrayList<>(cur));
			return;
		}
		Set<Integer> used = new HashSet<>();
		for (int i = idx; i < cur.size(); i++) {
			if (used.add(cur.get(i))) {
				Collections.swap(cur, idx, i);
				dfs(cur, idx + 1, res);
				Collections.swap(cur, idx, i);
			}
		}
	}

	public static void main(String[] args) {
		PermutationsII lzr = new PermutationsII();
		int[] nums = { 1, 1, 2 };
		List<List<Integer>> res = lzr.permuteUnique(nums);
		for (List<Integer> list : res) {
			System.out.print(list + " ");
		}
	}
}