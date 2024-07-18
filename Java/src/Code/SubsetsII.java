package Code;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

class SubsetsII {
	List<List<Integer>> subsetsWithDup(int[] nums) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> cur = new ArrayList<>();
		Arrays.sort(nums);
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
		while (idx < nums.length - 1 && nums[idx] == nums[idx + 1]) {
			idx++;
		}
		dfs(nums, cur, res, idx + 1);
	}
	
	public static void main(String[] args) {
		SubsetsII lzr = new SubsetsII();
		int[] nums = { 4, 4, 4, 1, 4 };
		List<List<Integer>> res = lzr.subsetsWithDup(nums);
		System.out.print(res);
	}
}