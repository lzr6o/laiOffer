package Code;
class NodeWithHighestEdgeScore {
	int edgeScore(int[] edges) {
		int n = edges.length;
		long[] score = new long[n];
		for (int i = 0; i < n; i++) {
			score[edges[i]] += i;
		}
		int idx = 0;
		for (int i = 0; i < n; i++) {
			if (score[i] > score[idx]) {
				idx = i;
			}
		}
		return idx;
	}

	public static void main(String[] args) {
		NodeWithHighestEdgeScore lzr = new NodeWithHighestEdgeScore();
		int[] edges = { 1, 0, 0, 0, 0, 7, 7, 5 };
		int res = lzr.edgeScore(edges);
		System.out.print(res);
	}
}