package leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class CombinationSumII {

	List<List<Integer>> combinationSum2(int[] candidates, int target) {
		Arrays.sort(candidates);
		List<List<Integer>> combo = new ArrayList<>();
		List<Integer> cur = new ArrayList<>();
		backtrack(candidates, target, 0, -1, cur, combo);
		return combo;
	}

	void backtrack(int[] candidates, int target, int idx, int pre, List<Integer> cur, List<List<Integer>> combo) {
		if (target == 0) {
			combo.add(new ArrayList<Integer>(cur));
			return;
		}
		if (target < 0) {
			return;
		}
		for (int i = idx; i < candidates.length; i++) {
			if (candidates[i] == pre) {
				continue;
			}
			cur.add(candidates[i]);
			backtrack(candidates, target - candidates[i], i + 1, pre, cur, combo);
			cur.remove(cur.size() - 1);
			pre = candidates[i];
		}
	}

	public static void main(String[] args) {
		CombinationSumII lzr = new CombinationSumII();
		int[] candidates = { 2, 5, 2, 1, 2 };
		int target = 5;
		List<List<Integer>> combo = lzr.combinationSum2(candidates, target);
		System.out.print(combo);
	}
}