package leetcode;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

class ReachableNodesWithRestrictions {
	int reachableNodes(int n, int[][] edges, int[] restricted) {
		Map<Integer, List<Integer>> neis = new HashMap<>();
		for (int i = 0; i < n; i++) {
			neis.put(i, new ArrayList<>());
		}
		for (int[] edge : edges) {
			neis.get(edge[0]).add(edge[1]);
			neis.get(edge[1]).add(edge[0]);
		}
		Set<Integer> visited = new HashSet<>();
		for (int node : restricted) {
			visited.add(node);
		}
		int res = 1;
		Queue<Integer> q = new LinkedList<>();
		q.offer(0);
		while (!q.isEmpty()) {
			int cur = q.poll();
			visited.add(cur);
			List<Integer> curNeis = neis.get(cur);
			for (int nei : curNeis) {
				if (!visited.contains(nei)) {
					q.offer(nei);
					visited.add(nei);
					res++;
				}
			}
		}
		return res;
	}

	public static void main(String[] args) {
		ReachableNodesWithRestrictions lzr = new ReachableNodesWithRestrictions();
		int n = 7;
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 3, 1 }, { 4, 0 }, { 0, 5 }, { 5, 6 } };
		int[] restricted = { 4, 5 };
		int res = lzr.reachableNodes(n, edges, restricted);
		System.out.print(res);
	}
}