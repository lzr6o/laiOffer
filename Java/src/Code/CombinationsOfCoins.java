package Code;

import java.util.ArrayList;
import java.util.List;

class CombinationsOfCoins {
	List<List<Integer>> combinations(int target, int[] coins) {
		List<List<Integer>> res = new ArrayList<>();
		List<Integer> cur = new ArrayList<>();
		dfs(target, coins, 0, cur, res);
		return res;
	}

	void dfs(int target, int[] coins, int idx, List<Integer> cur, List<List<Integer>> res) {
		if (idx == coins.length - 1) {
			if (target % coins[coins.length - 1] == 0) {
				cur.add(target / coins[coins.length - 1]);
				res.add(new ArrayList<Integer>(cur));
				cur.remove(cur.size() - 1);
			}
			return;
		}
		int max = target / coins[idx];
		for (int i = 0; i <= max; i++) {
			cur.add(i);
			dfs(target - i * coins[idx], coins, idx + 1, cur, res);
			cur.remove(cur.size() - 1);
		}
	}

	public static void main(String args[]) {
		CombinationsOfCoins lzr = new CombinationsOfCoins();
		int target = 25;
		int[] coins = { 1, 5, 10, 25 };
		List<List<Integer>> res = lzr.combinations(target, coins);
		System.out.print(res);
	}
}