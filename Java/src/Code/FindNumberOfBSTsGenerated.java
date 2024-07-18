package Code;

class FindNumberOfBSTsGenerated {

	int numOfTrees(int n) {
		int[] bst = new int[n + 1];
		bst[0] = 1;
		for (int k = 1; k <= n; k++) {
			for (int root = 1; root <= k; root++) {
				bst[k] += bst[root - 1] * bst[k - root];
			}
		}
		return bst[n];
	}

	public static void main(String[] args) {
		FindNumberOfBSTsGenerated lzr = new FindNumberOfBSTsGenerated();
		int n = 3;
		int result = lzr.numOfTrees(n);
		System.out.print(result);
	}
}