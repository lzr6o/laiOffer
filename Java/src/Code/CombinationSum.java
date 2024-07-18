package Code;

import java.util.ArrayList;
import java.util.List;

class CombinationSum {
	List<List<Integer>> combinationSum(int[] candidates, int target) {
		List<List<Integer>> combo = new ArrayList<>();
		List<Integer> cur = new ArrayList<>();
		dfs(candidates, target, cur, combo, 0);
		return combo;
	}
	
	void dfs(int[] candidates, int target, List<Integer> cur, List<List<Integer>> combo, int idx) {
		if (target == 0) {
			combo.add(new ArrayList<>(cur));
			return;
		}
		if (idx == candidates.length || target < 0) {
			return;
		}
		cur.add(candidates[idx]);
		dfs(candidates, target - candidates[idx], cur, combo, idx);
		cur.remove(cur.size() - 1);
		dfs(candidates, target, cur, combo, idx + 1);
	}
	
	public static void main(String[] args) {
		CombinationSum lzr = new CombinationSum();
		int[] candidates = { 2, 3, 5 };
		int target = 8;
		List<List<Integer>> res = lzr.combinationSum(candidates, target);
		System.out.print(res);
	}
}