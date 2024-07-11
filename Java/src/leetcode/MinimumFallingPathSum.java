package leetcode;

class MinimumFallingPathSum {
	int minFallingPathSum(int[][] matrix) {
		int ROWS, COLS;
		ROWS = matrix.length;
		COLS = matrix[0].length;
		for (int i = 1; i < COLS; i++) {
			for (int j = 0; j < COLS; j++) {
				matrix[i][j] += Math.min(matrix[i - 1][Math.max(j - 1, 0)],
						Math.min(matrix[i - 1][j], matrix[i - 1][Math.min(j + 1, COLS - 1)]));
			}
		}
		int min = Integer.MAX_VALUE;
		for (int num : matrix[ROWS - 1]) {
			min = Math.min(min, num);
		}
		return min;
	}

	public static void main(String[] args) {
		MinimumFallingPathSum lzr = new MinimumFallingPathSum();
		int[][] matrix = { { 2, 1, 3 }, { 6, 5, 4 }, { 7, 8, 9 } };
		int res = lzr.minFallingPathSum(matrix);
		System.out.print(res);
	}
}