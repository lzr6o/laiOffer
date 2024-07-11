package leetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class FindEventualSafeStates {

	List<Integer> eventualSafeNodes(int[][] graph) {
		List<Integer> res = new ArrayList<>();
		Map<Integer, Boolean> safe = new HashMap<>();
		for (int i = 0; i < graph.length; i++) {
			if (dfs(graph, safe, i)) {
				res.add(i);
			}
		}
		return res;
	}

	boolean dfs(int[][] graph, Map<Integer, Boolean> safe, int idx) {
		if (safe.containsKey(idx)) {
			return safe.get(idx);
		}
		safe.put(idx, false);
		for (int nei : graph[idx]) {
			if (!dfs(graph, safe, nei)) {
				return safe.get(idx);
			}
		}
		safe.put(idx, true);
		return safe.get(idx);
	}

	public static void main(String[] args) {
		FindEventualSafeStates lzr = new FindEventualSafeStates();
		int[][] graph = { { 1, 2 }, { 2, 3 }, { 5 }, { 0 }, { 5 }, {}, {} };
		List<Integer> res = lzr.eventualSafeNodes(graph);
		for (int num : res) {
			System.out.print(num + " ");
		}
	}
}