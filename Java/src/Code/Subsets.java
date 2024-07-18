package Code;

import java.util.ArrayList;
import java.util.List;

class Subsets {
	List<List<Integer>> subsets(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> cur = new ArrayList<>();
		dfs(nums, cur, res, 0);
		return res;
	}

	void dfs(int[] nums, List<Integer> cur, List<List<Integer>> res, int idx) {
		if (idx == nums.length) {
			res.add(new ArrayList<>(cur));
			return;
		}
		cur.add(nums[idx]);
		dfs(nums, cur, res, idx + 1);
		cur.remove(cur.size() - 1);
		dfs(nums, cur, res, idx + 1);
	}

	public static void main(String[] args) {
		Subsets lzr = new Subsets();
		int[] nums = { 1, 2, 3 };
		List<List<Integer>> res = lzr.subsets(nums);
		System.out.print(res);
	}
}