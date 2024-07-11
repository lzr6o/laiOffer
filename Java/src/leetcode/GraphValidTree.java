package leetcode;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

class GraphValidTree {
	boolean validTree(int n, int[][] edges) {
		ArrayList<ArrayList<Integer>> adj = new ArrayList<>();
		for (int i = 0; i < n; i++) {
			adj.add(i, new ArrayList<>());
		}
		for (int[] edge : edges) {
			int u = edge[0];
			int v = edge[1];
			adj.get(u).add(v);
			adj.get(v).add(u);
		}
		Set<Integer> visited = new HashSet<>();
		return dfs(adj, 0, -1, visited) && n == visited.size();
	}

	boolean dfs(ArrayList<ArrayList<Integer>> adj, int cur, int prev, Set<Integer> visited) {
		if (visited.contains(cur)) {
			return false;
		}
		visited.add(cur);
		for (int nei : adj.get(cur)) {
			if (nei == prev) {
				continue;
			}
			if (!dfs(adj, nei, cur, visited)) {
				return false;
			}
		}
		return true;
	}
	
	public static void main(String[] args) {
		GraphValidTree lzr = new GraphValidTree();
		int n = 5;
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 3 }, { 1, 3 }, { 1, 4 }, };
		boolean res = lzr.validTree(n, edges);
		System.out.print(res);
	}
}