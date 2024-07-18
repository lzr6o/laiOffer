package leetcode;

import java.util.ArrayList;
import java.util.List;

class combinations {
	List<List<Integer>> combine(int n, int k) {
		List<List<Integer>> combo = new ArrayList<>();
		List<Integer> cur = new ArrayList<>();
		backtrack(combo, cur, n, k, 1);
		return combo;
	}

	void backtrack(List<List<Integer>> combo, List<Integer> cur, int n, int k, int idx) {
		if (cur.size() == k) {
			combo.add(new ArrayList<>(cur));
			return;
		}
		for (int i = idx; i <= n; i++) {
			cur.add(i);
			backtrack(combo, cur, n, k, i + 1);
			cur.remove(cur.size() - 1);
		}
	}

	public static void main(String[] args) {
		combinations lzr = new combinations();
		int n = 4;
		int k = 2;
		List<List<Integer>> combo = lzr.combine(n, k);
		for (List<Integer> list : combo) {
			System.out.print(list.toString() + " ");
		}
	}
}