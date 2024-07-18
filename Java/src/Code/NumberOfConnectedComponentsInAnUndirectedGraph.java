package Code;

class NumberOfConnectedComponentsInAnUndirectedGraph {
	int countComponents(int n, int[][] edges) {
		int[] cnt = new int[1];
		cnt[0] = n;
		int[] root = new int[n];
		for (int i = 0; i < n; i++) {
			root[i] = i;
		}
		for (int[] edge : edges) {
			union(root, cnt, edge[0], edge[1]);
		}
		return cnt[0];
	}

	void union(int[] root, int[] cnt, int x, int y) {
		int rootX = find(root, x), rootY = find(root, y);
		if (rootX != rootY) {
			root[rootY] = rootX;
			cnt[0]--;
		}
	}

	int find(int[] root, int x) {
		if (root[x] == x) {
			return x;
		}
		return root[x] = find(root, root[x]);
	}

	public static void main(String[] args) {
		NumberOfConnectedComponentsInAnUndirectedGraph lzr = new NumberOfConnectedComponentsInAnUndirectedGraph();
		int n = 5;
		int[][] edges = { { 0, 1 }, { 1, 2 }, { 3, 4 } };
		int res = lzr.countComponents(n, edges);
		System.out.print(res);
	}
}