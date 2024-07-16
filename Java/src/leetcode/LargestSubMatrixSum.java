package leetcode;

class LargestSubMatrixSum {
	int largest(int[][] matrix) {
		int m = matrix.length;
		int n = matrix[0].length;
		int res = Integer.MIN_VALUE;
		for (int i = 0; i < m; i++) {
			int[] cur = new int[n];
			for (int j = i; j < m; j++) {
				add(cur, matrix[j]);
				res = Math.max(res, max(cur));
			}
		}
		return res;
	}

	void add(int[] cur, int[] add) {
		for (int i = 0; i < cur.length; i++) {
			cur[i] += add[i];
		}
	}

	int max(int[] cur) {
		int res = cur[0];
		int tmp = cur[0];
		for (int i = 1; i < cur.length; i++) {
			tmp = Math.max(tmp + cur[i], cur[i]);
			res = Math.max(res, tmp);
		}
		return res;
	}

	public static void main(String[] args) {
		LargestSubMatrixSum lzr = new LargestSubMatrixSum();
		int[][] matrix = { { 1, -2, -1, 4 }, { 1, -1, 1, 1 }, { 0, -1, -1, 1 }, { 0, 0, 1, 1 } };
		int res = lzr.largest(matrix);
		System.out.print(res);
	}
}