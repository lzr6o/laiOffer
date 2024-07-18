package Code;
import java.util.Arrays;

class RedundantConnection {
	int[] findRedundantConnection(int[][] edges) {
		int len = edges.length;
		int[] par = new int[len + 1];
		int[] rank = new int[len + 1];
		for (int i = 0; i <= len; i++) {
			par[i] = i;
			rank[i] = 1;
		}
		int[] res = new int[2];
		for (int[] edge : edges) {
			int n1 = edge[0], n2 = edge[1];
			if (!union(par, rank, n1, n2)) {
				res = edge;
				break;
			}
		}
		return res;
	}

	int find(int[] par, int n) {
		int p = par[n];
		while (p != par[p]) {
			par[p] = par[par[p]];
			p = par[p];
		}
		return p;
	}
	
	boolean union(int[] par, int[] rank, int n1, int n2) {
		int p1 = find(par, n1), p2 = find(par, n2);
		if (p1 == p2) {
			return false;
		}
		if (rank[p1] > rank[p2]) {
			par[p2] = p1;
			rank[p1] += rank[p2];
		} else {
			par[p1] = p2;
			rank[p2] += rank[p1];
		}
		return true;
	}
	
	public static void main(String[] args) {
		RedundantConnection lzr = new RedundantConnection();
		int[][] edges = { { 1, 2 }, { 2, 3 }, { 3, 4 }, { 1, 4 }, { 1, 5 } };
		int[] res = lzr.findRedundantConnection(edges);
		System.out.print(Arrays.toString(res));
	}
}